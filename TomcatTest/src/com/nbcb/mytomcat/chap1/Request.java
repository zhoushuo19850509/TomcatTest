package com.nbcb.mytomcat.chap1;

import java.io.IOException;
import java.io.InputStream;

public class Request {

	private InputStream input;
	private String uri;


	/**
	 * default constructor
	 */
	public Request(){

	}

	/**
	 * constructor
	 * @param in
	 */
	public Request(InputStream in){
		this.input = in;
	}
	
	/**
	 * parse the incoming HTTP request
	 */
	public void parse(){
		/**
		 * this StringBuilder contains the url of the request
		 */
		StringBuilder request = new StringBuilder();

		/**
		 * the buffer bytes
		 * we does not put the request content to the Memory at once
		 * but deal with the content by buffer
		 */
		byte[] buffer = new byte[2048];
		int i ;

		try {
			i = input.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;  // read nothing from client
		}

		for(int j = 0 ; j < i ; j++){
			request.append((char)buffer[j]);
		}

		/**
		 * print the uri from client
		 */
//		System.out.println(request.toString());

		/**
		 * parse the uri from client
		 */
		 this.uri = parseUri(request.toString());


	}

	/**
	 * parse the request uri from client
	 * @param requestString GET /index.html HTTP/1.1
	 * @return /index.html
	 */
	public String parseUri(String requestString){
		String parsedUri = "";
		int index1 = -1;
		int index2 = -1;

		index1 = requestString.indexOf(" ");
//		System.out.println(index1);
		if(index1 != -1){
			index2 = requestString.indexOf(" ",index1 + 1);
		}
//		System.out.println(index2);
		if(index2 > index1){
			parsedUri = requestString.substring(index1 + 1,index2);

		}

		System.out.println(parsedUri);
		if(parsedUri != "" && parsedUri != null && parsedUri.length() > 0){
			return  parsedUri;
		}else{
			return null;
		}
	}

	public static void main(String[] argss){
		Request request = new Request();
		String uri = "GET /index.html HTTP/1.1";
		String result = request.parseUri(uri);
		System.out.println(result);
	}

	/**
	 * getter/setter
	 * @return
	 */
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
