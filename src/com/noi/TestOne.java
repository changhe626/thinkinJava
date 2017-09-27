package com.noi;

import org.junit.Test;
import sun.awt.CharsetString;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/*
 * 一、缓冲区（Buffer）：在java NIO 中负者数据的存储。缓冲区就是数组。用于存储不同类型的数据。
 *
 * 根据数据类型的不同(boolean 除外)，有以下 Buffer 常用子类：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put():存入数据到缓冲区中
 *       put(byte b)：将给定单个字节写入缓冲区的当前位置
 *       put(byte[] src)：将 src 中的字节写入缓冲区的当前位置
 *       put(int index, byte b)：将指定字节写入缓冲区的索引位置(不会移动 position)
 * get():获取缓存区中的数据
 *       get() ：读取单个字节
 *       get(byte[] dst)：批量读取多个字节到 dst 中
 *       get(int index)：读取指定索引位置的字节(不会移动 position)
 *
 * 三、缓冲区中的四个核心属性：
 * capacity：容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit：界限，表示缓冲区中可以操作数据的大小。(limit后数据不能进行读写)
 * position：位置，表示缓冲区中正在操作数据的位置。
 * mark:标记，表示记录当前position位置。可以通过reset()恢复到mark的位置。
 *
 * 0<=mark<=position<=limit<=capacity
 *
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中。
 *
 * 直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 *          此方法返回的 缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区 。
 *          直接缓冲区的内容可以驻留在常规的垃圾回收堆之外.
 *          将直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。
 *          最好仅在直接缓冲区能在程序性能方面带来明显好处时分配它们。
 *          直接字节缓冲区还可以过 通过FileChannel 的 map() 方法 将文件区域直接映射到内存中来创建 。该方法返回MappedByteBuffe
 */
public class TestOne {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("~~~~~~~~~~~~~~");
        buffer.put("hello".getBytes());

        buffer.clear();
        buffer.flip();
        System.out.println((char)buffer.get());

        /*System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("~~~~~~~~~~~~~~");

        buffer.flip();
        System.out.println((char)buffer.get());
        buffer.mark();
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.reset();
        System.out.println(buffer.capacity());
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        ByteBuffer direct = ByteBuffer.allocateDirect(100);
        System.out.println(direct.isDirect());*/


    }

    //利用通道完成文件的复制(非直接缓冲区)
    @Test
    public  void test2() throws  Exception{
        long start=System.currentTimeMillis();
        //1.创建输入和输出流
        FileInputStream fis = new FileInputStream("d:/1.log");
        FileOutputStream fos = new FileOutputStream("d:/2.log");
        //2.根据流获取通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        //3.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4.将通道中的数据存入缓冲区中
        while(fisChannel.read(buffer)!=-1){
            buffer.flip();//切换到读模式
            //将缓冲区中的数据写到通道中去
            fosChannel.write(buffer);
            buffer.clear();//清空缓冲区
        }
        //关流,正常是用try catch的,不要这个throw
        fisChannel.close();
        fosChannel.close();
        fis.close();
        fos.close();
        long end=System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start)); //548
    }

    //下面的两个要jdk1.7才支持的
    //使用直接缓冲区完成文件的复制(内存映射文件)
    /*@Test
    public void test3() throws  Exception{
        long start=System.currentTimeMillis();
        //两个文件的关联通道
        FileChannel inChannel= FileChannel.open(Paths.get("d:/1.log"), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("d:/2.avi"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMappedBuf=inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf=outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
        //直接对缓冲区进行数据的读写操作
        byte[] dst=new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        inChannel.close();
        outChannel.close();
        long end=System.currentTimeMillis();
        System.out.println("耗费的时间为："+(end-start));

    }

    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test4() throws  Exception{
        long start=System.currentTimeMillis();
        FileChannel inChannel=FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("d:/2.avi"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
        long end=System.currentTimeMillis();
        System.out.println("耗费的时间为："+(end-start));
    }*/


    //分散读取,聚集写入
    @Test
    public void test5() throws  Exception{
        RandomAccessFile rw = new RandomAccessFile("d:/1.log", "rw");
        //1.获取通道
        FileChannel channel = rw.getChannel();
        //2.分配指定大小的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        //3.分散读取
        ByteBuffer[] buffs={buffer1,buffer2};
        channel.read(buffs);
        for(ByteBuffer byteBuffer : buffs){
            byteBuffer.flip();
        }
        System.out.println(new String(buffs[0].array(),0,buffs[0].limit()));
        System.out.println("--------------------");
        System.out.println(new String(buffs[1].array(),0,buffs[1].limit()));


        //聚集写出
        RandomAccessFile rw2 = new RandomAccessFile("d:2.txt", "rw");
        FileChannel rw2Channel = rw2.getChannel();
        rw2Channel.write(buffs);
        rw2.close();
        rw2Channel.close();
        rw.close();
        channel.close();
    }

    //Charset 编码,解码
    @Test
    public void test6() throws  Exception{
        Charset gbk = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce1 = gbk.newEncoder();
        //获取解码器
        CharsetDecoder cd1 = gbk.newDecoder();
        String s="昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒";
        CharBuffer buffer = CharBuffer.allocate(100);
        buffer.put(s);

        buffer.flip();
        ByteBuffer encode = ce1.encode(buffer);
        for (int i = 0; i < 30; i++) {
            System.out.println(encode.get());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        //解码
        encode.flip();
        CharBuffer decode = cd1.decode(encode);
        System.out.println(decode.toString());

        //使用utf-8就会产品乱码了
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        encode.flip();
        Charset u8 = Charset.forName("UTF-8");
        CharBuffer decode1 = u8.decode(encode);//直接进行解码
        System.out.println(decode1.toString());
    }



}
