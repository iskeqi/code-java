package com.keqi.server;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.extension.protocol.StringProtocol;
import org.smartboot.socket.transport.AioQuickServer;
import org.smartboot.socket.transport.AioSession;
import org.smartboot.socket.transport.WriteBuffer;

import java.io.IOException;

public class StringServer {

    public static void main(String[] args) throws IOException {
        MessageProcessor<String> processor = new MessageProcessor<String>() {
            @Override
            public void process(AioSession session, String msg) {
                System.out.println("receive from client: " + msg);
                WriteBuffer outputStream = session.writeBuffer();
                try {
                    byte[] bytes = msg.getBytes();
                    outputStream.writeInt(bytes.length);
                    outputStream.write(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        AioQuickServer server = new AioQuickServer(8888, new SmartProtocol(), processor);
        server.start();
    }
}
