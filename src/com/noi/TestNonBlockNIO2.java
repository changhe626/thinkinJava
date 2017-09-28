package com.noi;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by zk on 2017/9/28.
 * 作用: com.noi.
 * DatagramChannel
   Java NIO中的DatagramChannel是一个能收发UDP包的通道。
 */
public class TestNonBlockNIO2 {


    //客户端
    @Test
    public void test() throws  Exception {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            buffer.put((new Date().toString()+"\n"+s).getBytes());
            buffer.flip();
            dc.send(buffer, new InetSocketAddress("127.0.0.1", 9898));
            buffer.clear();
        }

    }

    //服务端
    @Test
    public void test2() throws Exception{
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
//        dc.bind(new InetSocketAddress("127.0.0.1",9898));
        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);
        while(selector.select()>0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while(it.hasNext()){
                SelectionKey key = it.next();
                if(key.isReadable()){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                }
            }
            it.remove();
        }



    }

}
