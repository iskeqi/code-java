package com.keqi.nettyspringbootclient.init;

import com.keqi.nettyspringbootclient.netty.SimpleChatClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UpperComputerRunner implements CommandLineRunner {

    public static final Map<String, Channel> CHANNEL_MAP = new ConcurrentHashMap<>();

    @Override
    public void run(String... args) throws Exception {
        // 从数据库中读取到所有的上位机
        List<String> list = new ArrayList<>();
        list.add("127.0.0.1:6666");
        list.add("127.0.0.1:7777");

        // 开启对应个数的线程
        for (String str : list) {
            Thread t = new Thread(() -> {
                EventLoopGroup group = new NioEventLoopGroup();
                try {
                    Bootstrap bootstrap = new Bootstrap()
                            .group(group)
                            .channel(NioSocketChannel.class)
                            .handler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    ChannelPipeline pipeline = ch.pipeline();
                                    //pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                                    pipeline.addLast(new StringDecoder());
                                    pipeline.addLast(new StringEncoder());
                                    pipeline.addLast(new SimpleChatClientHandler());
                                }
                            });
                    String[] split = str.split(":");
                    Channel channel = bootstrap.connect(split[0], Integer.parseInt(split[1])).sync().channel();
                    // 每一个客户端对应的 channel 都保存起来
                    CHANNEL_MAP.put(str, channel);
                    channel.writeAndFlush(str);
                } catch (Throwable e) {
                    e.printStackTrace();
                    group.shutdownGracefully();
                }
            });
            t.start();
        }

        Thread.sleep(4000);
        System.out.println(CHANNEL_MAP.size());

        for (Map.Entry<String, Channel> entry : CHANNEL_MAP.entrySet()) {
            String key = entry.getKey();
            Channel value = entry.getValue();
            value.writeAndFlush(key);
        }
    }
}
