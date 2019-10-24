package com.curefun.vspmanagernursedata.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zk
 * @Description:
 * @date 2019-03-11 10:38
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        //StrongReference (强引用)
        //o就是一个强引用, 强引用不会被JVM GC, 即使内存不够抛出OutOfMemoryError也不会被回收
        Object o = new Object();

        //SoftReference(软应用)
        //软引用是Java中一个类, 它的Referent只有在内存不够的时候在抛出OutOfMemoryError前会被 JVM GC,
        // 软引用一般用来实现内存敏感缓存(memory-sensitive caches)软引用可以和一个ReferenceQueue一起使用,
        // 当SoftReference的Referent被回收以后,这个SoftReference会被自动enqueue到这个queue中,如下:
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        SoftReference<Object> reference = new SoftReference<>(o, queue);//只能使用构造方法
        Object o1 = reference.get();//获取缓存内容
        System.out.println(o1);
        reference.clear();//清楚

        //WeakReference (弱引用)
        //弱引用相较于软引用生命周期更弱, 当一个对象仅有一个弱引用时它的Referent会在JVM GC执行以后被回收, 但是由于GC线程(如 System.gc())是一个低优先级线程,
        // 手动调用System.gc()未必会立即执行GC, 因此弱引用的Referent不一定会马上被回收.同样, 弱引用也可以和一个ReferenceQueue共同使用
        ReferenceQueue<Integer> integerReferenceQueue = new ReferenceQueue<>();
        Integer integer = new Integer(1);
        WeakReference<Integer> integerWeakReference = new WeakReference<>(integer, integerReferenceQueue);
        integer=0;
        System.out.println(integerWeakReference.get());
        System.gc();
        System.out.println(integerWeakReference.get());


        //PhantomReference (虚引用)
        //虚引用不会影响对象的生命周期, 他仅仅是一个对象生命周期的一个标记, 他必须与ReferenceQueue一起使用, 构造方法必须传入ReferenceQueue, 因为它的作用就是在对象被JVM决定需要GC后, 将自己enqueue到RQ中. 他通常用来在一个对象被GC前作为一个GC的标志,以此来做一些finalize操作
        //另外,PhantomReference.get()方法永远返回null
        ReferenceQueue<Integer> referenceQueue = new ReferenceQueue<>();
        Integer integer1 = new Integer(2);
        PhantomReference<Integer> phanRef = new PhantomReference<Integer>(integer1, referenceQueue);
        System.out.println("虚引用"+phanRef.get());
        //调用phanRef.get()不管在什么情况下会一直返回null
        // 如果obj被置为null，当GC发现了虚引用，GC会将phanRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phanRef所引用的obj对象，并没有被GC回收，在我们显式地调用refQueue.poll返回phanRef之后
        // 当GC第二次发现虚引用，而此时JVM将phanRef插入到refQueue会插入失败，此时GC才会对obj进行回收
        Reference<? extends Object> phanRefP = referenceQueue.poll();
        System.out.println("虚引用"+phanRefP);



        //ReferenceQueue (引用队列)
        //如果Reference在构造方法加入ReferenceQueue参数, Reference在它的Referent被GC的时,会将这个Reference加入ReferenceQueue

        //WeakHashMap
        //WeakHashMap是HashMap的WeakReference实现, 他使用WeakReference封装了Entry的Key,
        // 如果这个WeakHashMap的key仅有这个Map持有弱引用,则当JVM GC执行时,它的key和value会被GC. 如果这个key还有别的引用则不会被GC.
        WeakHashMap<String, String> map = new WeakHashMap<>();
        map.put("1","1");
        System.out.println("map"+map);
        System.gc();
        System.out.println("map"+map);


    }

    /**
     * 弱引用与虚引用的用处
     　 软引用很明显可以用来制作caching和pooling，而弱引用与虚引用呢？其实用处也很大，首先我们来看看弱引用，举个例子：
     class Registry {
     private Set registeredObjects = new HashSet();

     public void register(Object object) {
     registeredObjects.add( object );
     }
     }

     所有我添加进 registeredObjects 中的object永远不会被GC回收，因为这里有个强引用保存在registeredObjects里，另一方面如果我把代码改为如下：
     class Registry {
     private Set registeredObjects = new HashSet();

     public void register(Object object) {
     registeredObjects.add( new WeakReference(object) );
     }
     }

     现在如果GC想要回收registeredObjects中的object，便能够实现了，
     同样在使用HashMap如果想实现如上的效果，一种更好的实现是使用WeakHashMap

     */


}
