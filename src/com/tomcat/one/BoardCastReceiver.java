package com.tomcat.one;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by zk on 2017/9/26.
 * 广播通信,局域网内进行
 */
public class BoardCastReceiver {

    public static void main(String[] args){
        try {
            DatagramSocket ds = new DatagramSocket(8888);
            byte[] buf = new byte[5];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            System.out.print(new String(buf));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
