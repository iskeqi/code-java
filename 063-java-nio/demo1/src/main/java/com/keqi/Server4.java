package com.keqi;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server4 {
    public static void main(String[] args) throws Exception {
        //http://www.52im.net/thread-2640-1-1.html
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            if (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                if (selectionKey.isAcceptable()) {
                    // 有新的连接事件建立
                }

                // 处理完一个事件后，必须要从 selectionKeys 中进行移除，否则下次还会被传递过来
                iterator.remove();
            }
        }
    }
}
