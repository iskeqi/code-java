package com.keqi;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server3 {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            // 非阻塞模式下，当前方法不会阻塞，没有连接时，返回值为 null
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                // 表示当前没有连接
                // Thread.sleep(5000);
            } else {
                socketChannel.configureBlocking(false);
                byteBuffer.flip();

                int read = socketChannel.read(byteBuffer);
                if (read != 0) {
                    System.out.println(StandardCharsets.UTF_8.decode(byteBuffer));
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
