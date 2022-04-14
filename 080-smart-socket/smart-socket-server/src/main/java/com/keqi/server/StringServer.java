package com.keqi.server;

import com.keqi.server.itlong.ItlongMsg;
import com.keqi.server.itlong.ItlongProtocol;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.extension.protocol.StringProtocol;
import org.smartboot.socket.transport.AioQuickServer;
import org.smartboot.socket.transport.AioSession;
import org.smartboot.socket.transport.WriteBuffer;

import java.io.IOException;

public class StringServer {

    public static void main(String[] args) throws IOException {
        MessageProcessor<ItlongMsg> processor = new MessageProcessor<ItlongMsg>() {
            @Override
            public void process(AioSession session, ItlongMsg msg) {
                System.out.println("receive from client: " + msg);
                System.out.println(String.format("%4s", Integer.toHexString(msg.getLen())).replace(" ","0"));
                System.out.println(String.format("%2s", Integer.toHexString(msg.getDir())).replace(" ","0"));
                System.out.println(String.format("%2s", Integer.toHexString(msg.getSnr())).replace(" ","0"));
                System.out.println(String.format("%4s", Integer.toHexString(msg.getCmd())).replace(" ","0"));
                System.out.println(String.format("%2s", Integer.toHexString(msg.getChk())).replace(" ","0"));
//                WriteBuffer outputStream = session.writeBuffer();
//                try {
//                    byte[] bytes = msg.getBytes();
//                    outputStream.writeInt(bytes.length);
//                    outputStream.write(bytes);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        };

        AioQuickServer server = new AioQuickServer(8888, new ItlongProtocol(), processor);
        server.start();
    }
}
