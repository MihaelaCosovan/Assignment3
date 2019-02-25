package com.MihaelaCosovan.Assignment3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		
		//String URI = t.getRequestURI().getQuery().toString();
        if (t.getRequestURI().getQuery() == null) { 
        	System.out.println("No parameters"); }
        else {
        	String URI = t.getRequestURI().getQuery().toString();
        	
        	// display the URL
			System.out.println("\nYou typed the following URL: localhost:8001/html?" + URI);
			
			//diplay the parameters
			System.out.println("\nThe parameter included in your URL is: ");
        
        String[] parameters = URI.split("&");
        Map<String, String> queryParameters = new HashMap<String, String>();
               

      for (String parameter : parameters) {
    	  String[] keyValuePair = parameter.split("=");
          queryParameters.put(keyValuePair[0], keyValuePair[1]);
          System.out.println(queryParameters.get(keyValuePair[0]));
                  }
      }

        String response = "<html><body><form action=\"../html2\" method=\"GET\"> <h4><Hello there!\n</h4>Pleade insert your name below: <br><br> <input type=\"text\" name=\"firstname\" /><br/><br> <input type=\"submit\" value=\"Submit\"/> </form> </body></html>";
		
        Globals.HttpRequest(t, response);
	}

}