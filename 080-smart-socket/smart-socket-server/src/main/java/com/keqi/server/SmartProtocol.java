package com.keqi.server;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

public class SmartProtocol implements Protocol<String> {

    @Override
    public String decode(ByteBuffer readBuffer, AioSession session) {
        // 获取报文总长度，单位是字节
        int remaining = readBuffer.remaining();

        // 如果报文总长度小于4的话，直接结束
        if (remaining < Integer.BYTES) {
            return null;
        }

        // 标记缓冲区
        readBuffer.mark();

        // 读取4个字节，并获取这4个字节对应的int值
        int length = readBuffer.getInt();

        // 如果剩余报文长度小于这个头部4个字节对应的值，直接结束
        if (length > readBuffer.remaining()) {
            readBuffer.reset();
            return null;
        }

        // 读取对应长度的字节
        byte[] b = new byte[length];
        readBuffer.get(b);

        // 继续标记下
        readBuffer.mark();

        // 将对应字节数组转换成字符串
        return new String(b);
    }
}
