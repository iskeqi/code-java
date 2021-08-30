package com.keqi;

import java.io.IOException;
import java.net.Socket;

public class Consumer {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            socket.getOutputStream().write("向服务器发数据".getBytes());
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
