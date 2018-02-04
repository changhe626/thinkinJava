package xyz.single;

import java.io.Serializable;

/**
 * 单例,实现了序列化的接口
 */
public class Singleton  implements Serializable {
    private volatile static Singleton instance;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }

    //如何防止序列化/反序列化破坏单例模式。
    //只要在Singleton类中定义readResolve就可以解决该问题

    //ObjectInputStream的readObject返回的对象.isInstantiable：
    // 如果一个serializable/externalizable的类可以在运行时被实例化，那么该方法就返回true。
    //desc.newInstance：该方法通过反射的方式调用无参构造方法新建一个对象。
    //所以。到目前为止，也就可以解释，为什么序列化可以破坏单例了？
    //答：序列化会通过反射调用无参数的构造方法创建一个新的对象。

    private Object readResolve(){
        return instance;
    }

}
