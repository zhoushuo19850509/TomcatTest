package com.nbcb.mytomcat.chap1;

import java.io.*;

public class Response {

	private Request request;
	private static final int BUFFER_SIZE = 1024;
	private OutputStream output;

	/**
	 * constructor
	 * @param out
	 */
	public Response(OutputStream out){
		this.output = out;
	}

	/**
	 * set the request to get the actual uri from client
	 * such as the static resource request: /index.html
	 * @param request
	 */
	public void setRequest(Request request){
		this.request = request;
	}
	
	/**
	 * send the static resource back to the client
	 */
	public void sendStaticResource(){

		/**
		 * the File object(static resource) ,that the client request
		 */
		File file = new File(HttpServer.WEB_ROOT + request.getUri());

		FileInputStream fis = null;

		byte[] bytes = new byte[BUFFER_SIZE];

		try {
			if(file.exists()){
				fis = new FileInputStream(file);
				int ch = fis.read(bytes,0,BUFFER_SIZE);
				/**
				 * 这个while循环的意思是，每次都从FileInputStream中
				 * 读取固定长度的内容(长度为BUFFER_SIZE)
				 */
				while(ch != -1){
					output.write(bytes,0,BUFFER_SIZE);
					ch = fis.read(bytes,0,BUFFER_SIZE);
				}
			}else{
				String errorMsg = "error";
				output.write(errorMsg.getBytes());

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * send the file content back to the client as OutputStream
		 */


	}

	public static void main(String[] args){
		System.out.println(HttpServer.WEB_ROOT);

	}

}
