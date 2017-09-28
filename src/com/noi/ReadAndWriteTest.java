package com.noi;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by zk on 2017/9/28.
 * 作用: com.noi.
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串-》字符数组
 * 解码：字符数组-》字符串
 */
public class ReadAndWriteTest {

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
