package com.MihaelaCosovan.Assignment3;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandlerDBquerry implements HttpHandler {
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	static String dbTable = "USERS";
	
	 public static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	 public static String JDBC_URL = "jdbc:derby:Assignment3_DB;create=true";
	
	 public void handle(HttpExchange t) throws IOException {
			
			 try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(JDBC_URL);
				
				SelectOutput(t, dbTable);
				
				//create table statement - WIP
				/*
				if ( ! tableExists(connection, "USERS" ) ) {
				    connection.createStatement().execute("CREATE TABLE USERS(Id int, FirstName varchar(20), LastName varchar(20), Age int, Address varchar(50))");
					connection.createStatement().execute("INSERT INTO USERS values"
																+ " (1, 'Mihaela', 'Cosovan', 28, 'str. Luminii, nr.16, Valea Lupului'), "
																+ " (2, 'Andreea', 'Rosu', 29, 'str. Ionel Teodoreanu, nr.2, Valea Lupului'), "
																+ " (3, 'Ionut', 'Anastasiei', 25, 'str. Galata, nr.23, Iasi'), "
																+ " (4, 'Anca', 'Proca', 30, 'str. Alexandru cel Bun, nr.15, Iasi'), "
																+ " (5, 'Ana', 'Vitu', 27, 'str. Parcului, nr.9, Miroslava')"); 
					System.out.println("Your table: USERS has been created!");
					SelectOutput(t, dbTable); }
					else
					{System.out.println("Table USERS already exists - Nothing to create!");
					 SelectOutput(t, dbTable);
					// Globals.HttpRequest(t, response);
					 } */
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		    
	}
	
	public void SelectOutput(HttpExchange t, String dbTable) throws SQLException, IOException {
		String response = "<html> <head> <style> table, th, td { border: 1px solid black; border-collapse: collapse; }"
				+ "th, td { padding: 5px; text-align: left; } </style> </head>"
				+ "<body><h4>A new record was inserted.\n</h4>"
				+ "<h4>\n\nAvailable data:\n</h4>";	
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
		 
		while(rs.next()) {
						
			System.out.println("");
			for (int x = 1; x<=columnCount; x++)
				{ System.out.format("%20s", rs.getString(x) + "  |  " );
			    responsec += rs.getString(x) + "  |  " ; }
			
			
				
		response +="<tr> <td> " + rs.getInt(1) + " </td>";
		response +="     <td> " + rs.getString(2) + " </td>";
		response +="     <td> " + rs.getString(3) + " </td>";
		response +="     <td> " + rs.getInt(4) + "    </td>";
		response +="     <td> " + rs.getString(5) + " </td>";
		
	//	response += "</tr> </table> </div> </body> </html>";
		   
			}
			//response += "</body></html>";
		response += "</tr> </table> "
				 + "<form action=\"../htmlDBnewRecord\" method=\"POST\"> "
				 + "<h4></<br><br><input type=\"submit\" value=\"Add a new record\"/> </form> "
				 + "<form action=\"../htmlDBdeleteRecord\" method=\"POST\"> "
				 + "<h4><input type=\"submit\" value=\"Delete a record - WIP\"/> </form> "
				 + "</div> </body> </html>";
			Globals.HttpRequest(t, response);
		//	if (statement != null) statement.close();
		//	if (connection != null) connection.close();
			
			
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