package com.myTransient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


/**
 * 1、transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
 2、被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 3、一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 也可以认为在将持久化的对象反序列化后，被transient修饰的变量将按照普通类成员变量一样被初始化(进行默认的初始化)。
 */
public class Main implements Serializable {

    private static final long serialVersionUID = -5836283489677344417L;
    private transient int classValue = 10;
    private transient Date date = new Date();
    private transient static int staticValue = 10;
    private int age;
    private static int sex;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.classValue = 11;
        Main.staticValue = 11;
        m.age=10;
        m.sex=1;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                new File("0xjh000")));
        out.writeObject(m);

        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                new File("0xjh000")));
        Main m1 = (Main) in.readObject();
        in.close();

        System.out.println(m1);
    }

    @Override
    public String toString() {
        return "Main{" +
                "classValue=" + classValue +
                ", date=" + date +
                ", age=" + age +",sex:"+sex+
                '}';
    }
}