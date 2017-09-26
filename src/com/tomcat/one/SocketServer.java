package com.tomcat.one;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zk on 2017/9/25.
 * 作用: com.tomcat.one.
 */
public class SocketServer {
    public static void main(String[] args){
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println("服务器接收到客户端的链接请求:"+dis.readUTF());
            dos.writeUTF("连接成功了");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
