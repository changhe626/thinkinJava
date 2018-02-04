package xyz.single;

import java.io.*;

/**
 * 测试序列化后的对象是否和从方法中获取的是同一个.
 */
public class SingleDemo {
    public static void main(String[] args) throws Exception {
        //首先写出
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temFile"));
        oos.writeObject(Singleton.getInstance());
        //开始读
        File file = new File("temFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton  s= (Singleton) ois.readObject();

        //判断是否是同一个对象
        System.out.println(s==Singleton.getInstance());
        ois.close();
        oos.close();
        file.delete();
    }
}
