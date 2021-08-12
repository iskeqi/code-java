package com.keqi.client.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MultipleClient {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ClientInit());
        Thread t2 = new Thread(new ClientInit());
        Thread t3 = new Thread(new ClientInit());
        t1.start();
        t2.start();
        t3.start();

        // Thread.sleep(Integer.MAX_VALUE);
        while (true);
    }


    public static class ClientInit implements Runnable {
        @Override
        public void run() {
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap  = new Bootstrap()
                        .group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new SimpleChatClientInitializer());
                Channel channel = bootstrap.connect("127.0.0.1", 8080).sync().channel();
                // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                channel.writeAndFlush(channel.id().asLongText() + "\r\n");
                /*while(true){
                    channel.writeAndFlush(channel.id().asLongText() + "\r\n");
                    Thread.sleep(30000);
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // group.shutdownGracefully();
            }
        }
    }
}
