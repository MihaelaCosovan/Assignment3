package com.MihaelaCosovan.Assignment3;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyStringHandler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		//set the response as a normal string
		String response = "This is the output from MyStringHandler class";
		
		Globals.HttpRequest(t, response);
	}

}

