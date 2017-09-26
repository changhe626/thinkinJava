package com.tomcat.one;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by zk on 2017/9/26.
 * 组广播可以在公网内传播
 * 接收信息的一段
 */
public class Node2 {
    private static int port=8000;
    private static String address="228.0.0.4";

    public static void main(String[] args) throws Exception {
        InetAddress group = InetAddress.getByName(address);
        MulticastSocket msr= new MulticastSocket(port);
        msr.joinGroup(group);
        byte[] buffer = new byte[1024];
        while(true){
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            msr.receive(dp);
            String s = new String(dp.getData(), 0, dp.getLength());
            System.out.println("接收到了信息"+s);
        }
    }
}
