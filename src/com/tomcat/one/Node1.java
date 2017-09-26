package com.tomcat.one;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by zk on 2017/9/25.
 * 作用: 发送信息的一端
 */
public class Node1 {
    private static int port=8000;
    private static String address="228.0.0.4";

    public static void main(String[] args) throws Exception {
        InetAddress group=InetAddress.getByName(address);
        MulticastSocket mss=null;
        mss=new MulticastSocket(port);
        mss.joinGroup(group);
        while(true){
            String message="hello world";
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), group, port);
            mss.send(dp);
            Thread.sleep(1000);
        }
    }
}
