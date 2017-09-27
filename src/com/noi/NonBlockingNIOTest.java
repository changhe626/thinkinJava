package com.noi;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by zk on 2017/9/27.
 * 作用: com.noi.
 */
public class NonBlockingNIOTest {

    @Test
    public void test() throws Exception{
        //1.获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("", 8880));
        //2.切换到非阻塞
        channel.configureBlocking(false);
        //3.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4.发送数据给服务端
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

        }

    }
}
