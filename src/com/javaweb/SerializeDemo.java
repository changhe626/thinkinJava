package com.javaweb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by zk on 2017/10/31.
 * 作用: 对象的序列化
 */
public class SerializeDemo  implements Serializable{
    private static final long serialVersionID=1;
    public int num=100;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("d:/1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            SerializeDemo demo = new SerializeDemo();
            oos.writeObject(demo);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
