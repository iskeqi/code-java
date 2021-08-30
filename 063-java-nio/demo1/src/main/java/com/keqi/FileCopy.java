package com.keqi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {

    public static void main(String[] args) throws Exception {
        String source = "D:\\KEQI\\code-java\\063-java-nio\\demo1\\target\\classes\\source.txt";
        String dest = "D:\\KEQI\\code-java\\063-java-nio\\demo1\\target\\classes\\dest.txt";

        try (FileInputStream fileInputStream = new FileInputStream(source);
             FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
            FileChannel inputStreamChannel = fileInputStream.getChannel();
            FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(8);
            while (inputStreamChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                fileOutputStreamChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }
    }
}
