package com.MihaelaCosovan.Assignment3;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandlerDBnewRecord implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		
		    	 
		
		//set the response as a string containing HTML code
		String response = "<html><body><h3>Insert new record below.\n</h3></body></html>"
				
				
				+ "<form action=\"../htmlDBquerry2\" method=\"GET\"> <h4>Pleade insert the details below: </h4> <br><br> "
				+ "Id:         <input type=\"text\" name=\"Id\" /><br/><br> "
				+ "FirstName:  <input type=\"text\" name=\"FirstName\" /><br/><br> "
				+ "LastName:   <input type=\"text\" name=\"LastName\" /><br/><br> "
				+ "Age:        <input type=\"text\" name=\"Age\" /><br/><br> "
				+ "Address:    <input type=\"text\" name=\"Address\" /><br/><br> "
				+ "<input type=\"submit\" value=\"Submit\"/> </form> </body></html>";
		
		Globals.HttpRequest(t, response);
	}
	
}