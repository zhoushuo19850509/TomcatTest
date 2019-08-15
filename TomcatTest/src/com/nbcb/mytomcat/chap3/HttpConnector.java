package com.nbcb.mytomcat.chap3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpConnector implements Runnable {

    private boolean stopped = false;



    @Override
    public void run() {

        ServerSocket server = null;

        int port = 8080;

        try {
            server = new ServerSocket(port ,1 , InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while(!stopped) {
            Socket socket = null;

            /**
             * accept the incoming connection
             */
            try {
                socket = server.accept();
                HttpProcessor processor = new HttpProcessor();
                processor.proccess(socket);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

                /**
                 * if catch an Exception
                 * we continue the Http server to listen to the next incoming connection
                 */
                continue;
            } finally {
                /**
                 * close all the resources finally
                 */
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

    }

    /**
     * 和之前HttpServer.java不同的是
     * 这里HttpConnector是新起一个线程，来处理客户端请求
     */
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }

}
