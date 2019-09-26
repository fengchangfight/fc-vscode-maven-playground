package com.fcvscodemvn.io;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

    public static void main(String[] args) {
        String addr = "iloveyou";
        // 注意这里allocate得到的是一个HeapByteBuffer(ByteBuffer(抽象类)的一种实现)
        ByteBuffer buffer = ByteBuffer.allocate(16);// 分配内存大小
        buffer.putShort((short) 18);// 存入Short类型，一个Short两个字节
        buffer.put(addr.getBytes());
        buffer.put((byte) 0x00);// put一个byte
        buffer.put((byte) 0x04);
        buffer.putShort((short) 1);
        buffer.putShort((short) 10);
        byte[] re = (byte[]) buffer.flip().array();

        System.out.println(new String(re));
    }
}