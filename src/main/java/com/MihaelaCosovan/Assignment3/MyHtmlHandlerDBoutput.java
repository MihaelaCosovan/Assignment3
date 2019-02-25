// wippp

package com.MihaelaCosovan.Assignment3;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandlerDBoutput implements HttpHandler {
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	static String dbTable = "USERS";
	private static PreparedStatement prepareStatement = null;
	
	 public static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	 public static String JDBC_URL = "jdbc:derby:Assignment3_DB;create=true";
	
	 public void handle(HttpExchange t) throws IOException {
			
			 try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(JDBC_URL);
				
				//System.out.println(id + fn + ln + age +adr);
				
				SelectOutput(t, dbTable);
				
				 if (t.getRequestURI().getQuery() == null) { 
			        	System.out.println("No parameters"); }
			        else {
			        	String URI = t.getRequestURI().getQuery().toString();
			        	
			        	
			        String[] parameters = URI.split("&");
			        Map<String, String> queryParameters = new HashMap<String, String>();
			               

			      for (String parameter : parameters) {
			    	  String[] keyValuePair = parameter.split("=");
			          queryParameters.put(keyValuePair[0], keyValuePair[1]);
			          System.out.println(queryParameters.get(keyValuePair[0])); }
			      
				 
				 String id = t.getRequestURI().getQuery().split("=")[1];
				 String fn = t.getRequestURI().getQuery().split("=")[2];
				 String ln = t.getRequestURI().getQuery().split("=")[3];
				 String age = t.getRequestURI().getQuery().split("=")[4];
				 String adr = t.getRequestURI().getQuery().split("=")[5];
				 
				 System.out.println("Values to be inserted: " + id + ", " + fn + ", " + ln + ", " + age + ", " + adr);
	
			}} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		    
	}
		 
		public void InsertNewRecord(int i, String id, String fn, String ln, String age, String addr, String dbTable) throws SQLException {
				 			
		prepareStatement = connection.prepareStatement("INSERT INTO " + dbTable + "VALUES (?, ?, ?, ?, ?, ?)");
		//prepareStatement.setString(id, fn, ln, age, addr, dbTable);			
		} 
		
	
	public void SelectOutput(HttpExchange t, String dbTable) throws SQLException, IOException {
		String response = "<html> <head> <style> table, th, td { border: 1px solid black; border-collapse: collapse; }"
				+ "th, td { padding: 5px; text-align: left; } </style> </head>"
				+ "<body><h3>Available data:\n</h3>";	
		String responsec = "";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM "+dbTable);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

				
		response +="<div><table style=\"width:50%\">";
		response +="<tr>"
					  + "<th>Id</th> "
					  + "<th>FirstName</th> "
					  + "<th>LastName</th> "
					  + "<th>Age</th> "
					  + "<th>Address</th> "
			     + "</tr>"; 
		 
		response +="<tr> <td> " + rs.getString(1) + " </td>";
		response +="     <td> " + rs.getString(2) + " </td>";
		response +="     <td> " + rs.getString(3) + " </td>";
		response +="     <td> " + rs.getString(4) + "    </td>";
		response +="     <td> " + rs.getString(5) + " </td>";
	
		response += "</tr> </table> "
				 + "<form action=\"../html\" method=\"POST\"> "
				/// + "<h4><Hello there!\n</<br><br><input type=\"submit\" value=\"Lala\"/> </form> "
				 + "<input type=\"submit\" value=\"Go to Home Page!\"/> </form> </div> </body> </html>";
			Globals.HttpRequest(t, response);
			if (statement != null) statement.close();
			if (connection != null) connection.close();
			
			
	}
		
	public static boolean tableExists ( Connection connection, String table ) {
	    int numRows = 0;
	    try {
	      DatabaseMetaData dbmd = connection.getMetaData();
	      // Note the args to getTables are case-sensitive!
	      ResultSet rs = dbmd.getTables( null, "Assignment3_DB", table.toUpperCase(), null);
	      while( rs.next() ) ++numRows;
	    } catch ( SQLException e ) {
	        String theError = e.getSQLState();
	        System.out.println("Unable to query DB metadata: " + theError );
	        System.exit(1);
	    }
	    return numRows > 0;
	  }
	
	
}
