package com.keqi.server.itlong;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

/**
 * 旺龙电梯协议解析类
 *
 * @author keqi
 */
public class ItlongProtocol implements Protocol<ItlongMsg> {

    @Override
    public ItlongMsg decode(ByteBuffer readBuffer, AioSession session) {
        ItlongMsg itlongMsg = new ItlongMsg();

        System.out.println("长度：" + readBuffer.remaining());

        // 解析包头
        byte[] header = new byte[3];
        readBuffer.get(header);
        System.out.println("ITL " + new String(header));
        System.out.println("长度：" + readBuffer.remaining());

        // 解析数据长度
        itlongMsg.setLen(readBuffer.getShort());
        System.out.println("长度：" + readBuffer.remaining());

        // 解析传输方向
        itlongMsg.setDir(readBuffer.get());
        System.out.println("长度：" + readBuffer.remaining());

        // 解析流水号
        itlongMsg.setSnr(readBuffer.get());
        System.out.println("长度：" + readBuffer.remaining());

        // 解析命令字
        itlongMsg.setCmd(readBuffer.getShort());
        System.out.println("长度：" + readBuffer.remaining());

        // 解析传输数据
        byte[] info = new byte[itlongMsg.getLen() - 5];
        readBuffer.get(info);
        itlongMsg.setInfo(new String(info));
        System.out.println("长度：" + readBuffer.remaining());

        // 解析校验字
        itlongMsg.setChk(readBuffer.get());
        System.out.println("长度：" + readBuffer.remaining());

        return itlongMsg;
    }
}
