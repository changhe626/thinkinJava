package com.noi;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
 * 一、使用NIO 完成网络通信的三个核心：
 *
 * 1、通道(Channel):负责连接
 *      java.nio.channels.Channel 接口：
 *           |--SelectableChannel
 *               |--SocketChannel
 *               |--ServerSocketChannel
 *               |--DatagramChannel
 *
 *               |--Pipe.SinkChannel
 *               |--Pipe.SourceChannel
 *
 * 2.缓冲区(Buffer):负责数据的存取
 *
 * 3.选择器(Selector):是 SelectableChannel 的多路复用器。用于监控SelectableChannel的IO状况
 */
public class TestTwo {

    //客户端
    @Test
    public void test() throws Exception{
       /* SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8880));
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(inChannel.read(buffer)!=-1){
            buffer.flip();
            schannel.write(buffer);
            buffer.clear();
        }
        schannel.shutdownOutput();//关闭发送通道，表明发送完毕

        //接收服务端的反馈
        int len=0;
        while((len=schannel.read(buffer))!=-1){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }
        inChannel.close();
        schannel.close();*/
    }



    //服务端的
    @Test
    public  void test2() throws Exception{
        /*ServerSocketChannel channel = ServerSocketChannel.open();
        FileChannel outChannel=FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        channel.bind(new InetSocketAddress(8880));
        SocketChannel sChannel = channel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(sChannel.read(buffer)!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        //发送反馈给客户端
        buffer.put("服务端接收数据成功".getBytes());
        buffer.flip();//给为读模式
        sChannel.write(buffer);

        sChannel.close();
        outChannel.close();
        channel.close();*/

    }
}
