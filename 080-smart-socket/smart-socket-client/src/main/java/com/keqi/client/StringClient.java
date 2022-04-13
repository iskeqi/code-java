package com.keqi.client;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;
import org.smartboot.socket.transport.WriteBuffer;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StringClient {

    public static void main(String[] args) throws IOException {
        MessageProcessor<String> processor = new MessageProcessor<String>() {
            @Override
            public void process(AioSession session, String msg) {
                System.out.println("receive from server: " + msg);
            }
        };

        AioQuickClient client = new AioQuickClient("localhost", 8888, new SmartProtocol(), processor);

        AioSession session = client.start();
        WriteBuffer writeBuffer = session.writeBuffer();
        byte[] data = "hello smart-socket".getBytes();

        writeBuffer.writeInt(data.length);
        writeBuffer.write(data);
        writeBuffer.flush();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                byte[] data = "hello smart-socket".getBytes();

                try {
                    writeBuffer.writeInt(data.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writeBuffer.write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeBuffer.flush();
            }
        }, 1, 10, TimeUnit.SECONDS);
    }
}
