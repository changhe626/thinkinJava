package com.noi;



import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Created by zk on 2017/9/28.
 * 作用: com.noi.
 * 管道 (Pipe)
 Java NIO 管道是2个线程之间的单向数据连接。
 Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。
 */
public class TestPipe {


    @Test
    public void test1() throws IOException {
        //1.获取管道
        Pipe pipe = Pipe.open();
        //2.将缓冲区中的数据写入管道
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sink = pipe.sink();
        buffer.put("半儒半佛亦半仙".getBytes());
        buffer.flip();
        sink.write(buffer);
        //3.读取缓冲区中的数据
        Pipe.SourceChannel source = pipe.source();
        buffer.flip();
        int len=source.read(buffer);
        System.out.println(new String(buffer.array(),0,len));
        source.close();
        sink.close();
    }
}
