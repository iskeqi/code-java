package com.keqi.client;

import com.keqi.client.itlong.ItlongMsg;
import com.keqi.client.itlong.ItlongProtocol;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;
import org.smartboot.socket.transport.WriteBuffer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringClient {

    public static void main(String[] args) throws IOException {
        MessageProcessor<ItlongMsg> processor = new MessageProcessor<ItlongMsg>() {
            @Override
            public void process(AioSession session, ItlongMsg msg) {
                System.out.println("receive from server: " + msg);
            }
        };

        AioQuickClient client = new AioQuickClient("localhost", 8888, new ItlongProtocol(), processor);
        // 启动客户端
        AioSession session = client.start();

        WriteBuffer writeBuffer = session.writeBuffer();

        // 发送报文

        // 49 54 4C 00 05 00 01 10 04 10
        writeBuffer.write("ITL".getBytes(StandardCharsets.UTF_8));
        writeBuffer.writeShort((short) 5);
        writeBuffer.writeByte((byte) 0);
        writeBuffer.writeByte((byte) 1);
        writeBuffer.writeShort((short) 4100);
        writeBuffer.writeByte((byte) 16);

        writeBuffer.flush();
    }
}
