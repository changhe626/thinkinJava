package com.noi;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/*
一、通道（Channel）与缓冲区（Buffer）

若需要使用 NIO 系统，需要获取用于连接 IO 设备的通道以及用于容纳数据的缓冲区。然后操作缓冲区，对数据进行处理。
简而言之，Channel 负责传输， Buffer 负责存储。

1、缓冲区（Buffer）

缓冲区（Buffer） ：一个用于特定基本数据类型的容器。由 java.nio 包定义的，所有缓冲区都是 Buffer 抽象类的子类。
Java NIO 中的 Buffer 主要用于与 NIO 通道进行交互，数据是从通道读入缓冲区，从缓冲区写入通道中的。

2、通道（Channel）

通道：由java.nio.channels包定义。
Channel表示IO源与目标打开的连接。
Channel类似于传统的“流”。但其自身不能直接访问数据，Channel只能与Buffer进行交互。

操作系统中：通道是一种通过执行通道程序管理I/O操作的控制器，它使主机（CPU和内存）与I/O操作之间达到更高的并行程度。
需要进行I/O操作时，CPU只需启动通道，然后可以继续执行自身程序，通道则执行通道程序，管理与实现I/O操作。


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
 *          直接字节缓冲区还可以过 通过FileChannel 的 map() 方法 将文件区域直接映射到内存中来创建 。
 *          该方法返回MappedByteBuffe
 *
 *
 * 一、通道(Channel):用于源节点与目标节点的连接。在java NIO中负责缓冲区中数据的传输。Channel本身不存储数据，需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 *    java.nio.channels.Channel 接口：
 *        |--FileChannel：用于读取、写入、映射和操作文件的通道。
 *        |--SocketChannel：通过 TCP 读写网络中的数据。
 *        |--ServerSocketChannel：可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel。
 *        |--DatagramChannel：通过 UDP 读写网络中的数据通道。
 *
 * 三、获取通道
 * 1.java针对支持通道的类提供了getChannel()方法
 *      本地IO：
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络IO：
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 * 2.在JDK 1.7 中的NIO.2 针对各个通道提供了静态方法 open()
 * 3.在JDK 1.7 中的NIO.2 的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 */
public class TestOne {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
   /*     System.out.println("~~~~~~~~~~~~~~");
        buffer.put("hello".getBytes());

        buffer.clear();
        buffer.flip();
        System.out.println((char)buffer.get());*/

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
           /* buffer.flip();//切换到读模式
            //将缓冲区中的数据写到通道中去
            fosChannel.write(buffer);
            buffer.clear();//清空缓冲区*/
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






}
