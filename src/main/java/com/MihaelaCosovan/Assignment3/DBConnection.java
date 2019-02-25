package com.MihaelaCosovan.Assignment3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	
	 public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	 public static final String JDBC_URL = "jdbc:derby:Assignment3_DB;create=true";	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Class.forName(DRIVER);
		// Connection connection = DriverManager.getConnection(JDBC_URL);
	/*	
	    if ( ! tableExists(connection, "USERS" ) ) {
		  		
	    connection.createStatement().execute("CREATE TABLE USERS(id int, FirstName varchar(20), LastName varchar(20), Age int, Address varchar(50))");
		connection.createStatement().execute("INSERT INTO USERS values"
													+ " (1, 'Mihaela', 'Cosovan', 28, 'str. Luminii, nr.16, Valea Lupului'), "
													+ " (2, 'Andreea', 'Rosu', 29, 'str. Ionel Teodoreanu, nr.2, Valea Lupului'), "
													+ " (3, 'Ionut', 'Anastasiei', 25, 'str. Galata, nr.23, Iasi'), "
													+ " (4, 'Anca', 'Proca', 30, 'str. Alexandru cel Bun, nr.15, Iasi'), "
													+ " (5, 'Ana', 'Vitu', 27, 'str. Parcului, nr.9, Miroslava')"); 
		System.out.println("Your table: USERS has been created!");	}
		else
		{System.out.println("Table USERS already exists - Nothing to create!");	}*/


	}
	
	public void DBConection () throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
	
}
	
	public void DBConectionInsert1 () throws SQLException {
		if ( ! tableExists(connection, "USERS" ) ) {
		    connection.createStatement().execute("CREATE TABLE USERS(id int, FirstName varchar(20), LastName varchar(20), Age int, Address varchar(50))");
			connection.createStatement().execute("INSERT INTO USERS values"
														+ " (1, 'Mihaela', 'Cosovan', 28, 'str. Luminii, nr.16, Valea Lupului'), "
														+ " (2, 'Andreea', 'Rosu', 29, 'str. Ionel Teodoreanu, nr.2, Valea Lupului'), "
														+ " (3, 'Ionut', 'Anastasiei', 25, 'str. Galata, nr.23, Iasi'), "
														+ " (4, 'Anca', 'Proca', 30, 'str. Alexandru cel Bun, nr.15, Iasi'), "
														+ " (5, 'Ana', 'Vitu', 27, 'str. Parcului, nr.9, Miroslava')"); 
			System.out.println("Your table: USERS has been created!");	}
			else
			{System.out.println("Table USERS already exists - Nothing to create!");	}
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
	
	public void SelectOutput(String dbTable) throws SQLException {
		statement = connection.createStatement();
		statement.executeQuery("SELECT * FROM "+dbTable);
		
		ResultSet rs = statement.getResultSet();
		
		while(rs.next()) {
		System.out.println(rs.getString("FirstName"));
		System.out.println(rs.getString("LastName"));
		System.out.println(rs.getString("Age"));
		System.out.println(rs.getString("Address")); }
		}
	
	public void InsertData () {
		
	}
	
}