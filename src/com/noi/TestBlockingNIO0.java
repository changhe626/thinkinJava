package com.noi;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
   传统的 IO 流都是阻塞式的。也就是说，当一个线程调用 read() 或 write()时，该线程被阻塞，
   直到有一些数据被读取或写入，该线程在此期间不能执行其他任务。因此，在完成网络通信进行 IO 操作时，
   由于线程会阻塞，所以服务器端必须为每个客户端都提供一个独立的线程进行处理，当服务器端需要处理大量客户端时，
   性能急剧下降。

Java NIO 是非阻塞模式的。当线程从某通道进行读写数据时，若没有数据可用时，该线程可以进行其他任务。
线程通常将非阻塞 IO 的空闲时间用于在其他通道上执行 IO 操作，所以单独的线程可以管理多个输入和输出通道。
因此，NIO 可以让服务器端使用一个或有限几个线程来同时处理连接到服务器端的所有客户端。

选择器（Selector）
选择器（Selector）是SelectableChannle对象的多路复用器,Selector可以同时监控多个SelectableChannel的IO状况，
也就是说，利用 Selector可使一个单独的线程管理多个 Channel。Selector 是非阻塞 IO 的核心。

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
public class TestBlockingNIO0  {

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
