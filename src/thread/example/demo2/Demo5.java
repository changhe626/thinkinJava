package thread.example.demo2;

public class Demo5 extends Thread {
    public Demo5() {
        System.out.println("构造方法"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        /*new Demo5().start();
        //主线程调用的Demo5的构造方法.
        System.out.println(Thread.currentThread().getName());*/

        Demo5 demo5 = new Demo5();
        System.out.println("isLiv---"+demo5.isAlive());
        demo5.start();

        //加入了sleep之后,这次就是false了.这是假象了....
        Thread.sleep(1000);

        System.out.println("1"+demo5.isAlive());
        System.out.println("2"+demo5.isAlive());


    }
}
