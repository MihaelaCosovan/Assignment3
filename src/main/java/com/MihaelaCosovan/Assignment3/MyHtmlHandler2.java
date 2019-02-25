package com.MihaelaCosovan.Assignment3;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandler2 implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {

		//set headers and statur code
		
//t.getRequestURI().getQuery().split("=")[1] + ", please select the appropriat list of shapes you'd like to see:";
		
		
		String response = "<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Available shapes:</title></head><body><left><h4>"
				+ t.getRequestURI().getQuery().split("=")[1]
				+ ",\n"
				+ "\nPlease select one shapes:</h4>"
				+ "<form method=\"GET\" action=\"../html3\"><br>"
				+ "<input type=\"radio\" name=\"shape\" value=\"Shape3\">Shape 3<br>"
				+ "<input type=\"radio\" name=\"shape\" value=\"Shape4\">Shape 4<br>"
				+ "<input type=\"radio\" name=\"shape\" value=\"Shape5\">Shape 5<br><br>"
				+ "<input type=\"submit\"></form></center></body></html>";

		
		Globals.HttpRequest(t, response);			
	}

}

