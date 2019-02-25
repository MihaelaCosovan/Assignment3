package com.MihaelaCosovan.Assignment3;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import java.sql.SQLException;

@SuppressWarnings("restriction")
public class App 
{
	
  //  public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
 //   public static final String JDBC_URL = "jdbc:derby:Assignment3_DB;create=true";	
	
	public static void main( String[] args ) throws IOException, ClassNotFoundException, SQLException
    {
		 //create weserver service
        HttpServer server = HttpServer.create(new InetSocketAddress(8001),0);
        
        //set handler to specified path
        server.createContext("/", new MyStringHandler());
        server.createContext("/html", new MyHtmlHandler());
        server.createContext("/html2", new MyHtmlHandler2());
        server.createContext("/html3", new MyHtmlHandler3());
        server.createContext("/html4", new MyHtmlHandler4());
        
        // DB handlers
        //server.createContext("/htmlDB", new MyHtmlHandlerDBoption());
        server.createContext("/htmlDBquerry", new MyHtmlHandlerDBquerry());
        server.createContext("/htmlDBquerry2", new MyHtmlHandlerDBquerry2());
        server.createContext("/htmlDBnewRecord", new MyHtmlHandlerDBnewRecord());
        server.createContext("/htmlDBoutput", new MyHtmlHandlerDBoutput());
        
        // htmlDBdeleteRecord
        
        
       /* 
        Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		
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
		{System.out.println("Table USERS already exists - Nothing to create!");	} */
		
		       
        //creates a default executor
        server.setExecutor(null);
        
        //start the server
        server.start();
        System.out.println("***** Server Strated on port 8001 *****\n");
    }}

/*
private static boolean tableExists ( Connection connection, String table ) {
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
  } } */