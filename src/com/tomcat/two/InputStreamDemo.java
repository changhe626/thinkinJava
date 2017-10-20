package com.tomcat.two;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zk on 2017/9/28.
 * 作用: com.tomcat.two.
 */
public class InputStreamDemo {

    /**
     * 服务端
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] buffer=new byte[1024];
        is.read(buffer);
        socket.close();
    }


    /**
     * 客户端
     */    
    @Test
    public void test2() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        byte[] buffer={1,1,1,1,1,1,1};
        os.write(buffer);
        socket.close();
    }
}
