package com.keqi.client.itlong;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

/**
 * 旺龙电梯协议解析类
 *
 * @author keqi
 */
public class ItlongProtocol implements Protocol<ItlongMsg> {

    /*
        如果与某个系统通讯采用的是TCP私有协议，且协议是基于二进制报文的，那么应该如何处理呢？

        解析报文：
            通过网络编程框架提供的API来对接收到的


        发送报文：
     */



    @Override
    public ItlongMsg decode(ByteBuffer readBuffer, AioSession session) {
        // 解析报文
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
