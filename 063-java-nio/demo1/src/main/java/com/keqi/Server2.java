package com.keqi;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            // 等待客户端进行连接
            Socket socket = serverSocket.accept();

            Thread t = new Thread(() -> {
                //
                try {
                    socket.getInputStream().read(buffer);
                    System.out.println(new java.lang.String(buffer));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
