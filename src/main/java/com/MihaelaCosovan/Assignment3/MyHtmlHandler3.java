package com.MihaelaCosovan.Assignment3;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandler3 implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {

		//set headers and status code
		String response = "<html><body><p>Available shapes for your selection: </p>";
		String response2 = "Available shapes for your selection: ";
				
		 if (t.getRequestURI().getQuery() == null) { 
	        	System.out.println("No selection"); }
	        else {
	        	ShapeSide ss = new ShapeSide();
	        	String shape = t.getRequestURI().getQuery().split("=")[1];
	        	
	        	switch (shape)
	        	{
	        	case "Shape3": response += ss.getAvailableShapes(GeometricShape.Shape3).toString(); 
	        				   response2 +=ss.getAvailableShapes(GeometricShape.Shape3).toString(); break;
	        	case "Shape4": response += ss.getAvailableShapes(GeometricShape.Shape4).toString();  
	        				   response2 +=ss.getAvailableShapes(GeometricShape.Shape4).toString(); break;
	        	case "Shape5": response += ss.getAvailableShapes(GeometricShape.Shape5).toString();  
	        				   response2 +=ss.getAvailableShapes(GeometricShape.Shape5).toString(); break;
	        	default: response = "";
	        	}
	        	
	        	response += //t.getRequestURI().getQuery() +
	        			 "</p>\n\nThe above records have seen exported\n</p>"
	        			+ "\n\n<a href=\"http://localhost:8001/html4\""
	        			+ "</a>\n<h5><p>Click here to see your next options:</h5></p></body></html>";
	        	
	        	//Export Output
	        	ExportOutput(response2);	        	
	        	Globals.HttpRequest(t, response);		
	}}

//Export Output method
private static void ExportOutput (String response ) throws IOException {
	// BufferedWriter bfwriter = new BufferedWriter(new FileWriter("C:\\Users\\Mihaela\\Desktop\\Java\\java.txt"));
	BufferedWriter bfwriter = new BufferedWriter(new FileWriter("C:\\Users\\mihaela.macovei\\Desktop\\Java\\Assignment3\\java.txt"));
   	bfwriter.write(response);
   	bfwriter.close();
} 
}