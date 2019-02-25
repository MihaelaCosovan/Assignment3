package com.MihaelaCosovan.Assignment3;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandler4 implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		
		    	 
		
		//set the response as a string containing HTML code
		String response = "<html><body><h4>Available options for you:\n</h4></body></html>"
				+ "<p><a href=\"http://localhost:8001/html\"><h4>1. Go to Home page!</h4></a></p>"
				+ "<p><a href=\"http://localhost:8001/htmlDBquerry\"><h4>2. Go to DB</h4></a></p>"
				+ "<p><a href=\"http://localhost:8001/\"><h4>3. Leave my webpage!</h4></a></p>"
				+ "</body></html>";
		
		Globals.HttpRequest(t, response);
	}
}