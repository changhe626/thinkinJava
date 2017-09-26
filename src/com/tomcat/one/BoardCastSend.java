package com.tomcat.one;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by zk on 2017/9/26.
 * 作用: 发送组广播的功能类
 */
public class BoardCastSend {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("192.168.0.1");
            DatagramSocket ds = new DatagramSocket();
            String str="hello";
            DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length,ip,8888);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
