package com.myTransient;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/**
 * 程序运行后将输出如下结果：
 哈哈~我将会被序列化，不管我是是否被transient关键字修饰

 这是为什么呢，不是说类的变量被transient关键字修饰以后将不能序列化了吗？
 我们知道在Java中，对象的序列化可以通过实现两种接口来实现，若操作的是一个Serializable对象，则所有的序列化将会自动进行，
 若操作的是 一个Externalizable对象，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，
 这与是否被transient修饰无关。因此第二个例子输出的是变量content初始化的内容，而不是null。
 */

public class ExternalizableTest implements Externalizable {

    private transient String content = "哈哈~我将会被序列化，不管我是是否被transient关键字修饰";
    private transient String age="12";
    private transient String money="100";
    private String name="曹操";
    private String city="许昌";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {
        ExternalizableTest et = new ExternalizableTest();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("ext0000")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "ext0000")));
        ExternalizableTest et1 = (ExternalizableTest) in.readObject();
        System.out.println(et1.content);

        out.close();
        in.close();
    }
}
