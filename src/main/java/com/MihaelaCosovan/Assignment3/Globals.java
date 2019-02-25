package com.MihaelaCosovan.Assignment3;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class Globals {
	
	public static void HttpRequest(HttpExchange t, String response) throws IOException {
			//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
				
		//send response
		os.write(response.getBytes());
				
		//close request
		os.close();
	}

}
