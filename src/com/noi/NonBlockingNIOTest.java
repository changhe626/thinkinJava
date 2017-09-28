package com.noi;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by zk on 2017/9/27.
 * 作用: com.noi.
 * 当调用 register(Selector sel, int ops) 将通道注册选择器时，选择器对通道的监听事件，需要通过第二个参数 ops 指定。
 可以监听的事件类型（用 可使用 SelectionKey 的四个常量 表示）：
  读 : SelectionKey.OP_READ （1）
  写 : SelectionKey.OP_WRITE （4）
  连接 : SelectionKey.OP_CONNECT （8）
  接收 : SelectionKey.OP_ACCEPT （16）
 若注册时不止监听一个事件，则可以使用“位或”操作符连接。

 SelectionKey：表示 SelectableChannel 和 Selector 之间的注册关系。每次向选择器注册通道时就会选择一个事件(选择键)。
 选择键包含两个表示为整数值的操作集。操作集的每一位都表示该键的通道所支持的一类可选择操作。
 */
public class NonBlockingNIOTest {

    //客户端
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
            String str=scanner.next();
            buffer.put((new Date()+""+str).getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        //关闭通道
        channel.close();
    }

    //服务端
    @Test
    public void test2() throws Exception{
        //1.获取通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        //2.切换非阻塞式模式
        channel.configureBlocking(false);
        //3.绑定连接
  //      channel.bind(new InetSocketAddress(8880));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并且指定“监听接收事件”
        channel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮询式的获取选择器上已经“准备就绪”的事件
        while(selector.select()>0){
            //7.获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                //8.获取准备“就绪”的事件
                SelectionKey key = iterator.next();
                //9.判断具体是什么时间准备就绪
                if(key.isAcceptable()){
                    //10.若“接收就绪”，获取客户端连接
                    SocketChannel accept = channel.accept();
                    //11.切换非阻塞模式
                    accept.configureBlocking(false);
                    //12.将该通道注册到选择器上
                    accept.register(selector,SelectionKey.OP_READ);
                    //13.获取当前选择器上“读就绪”状态的通道
                    SocketChannel sChannel=(SocketChannel)key.channel();
                    //14.读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len=0;
                    while((len=sChannel.read(buffer))!=-1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //15.取消选择键SelectionKey
                iterator.remove();
            }
        }


    }

}
