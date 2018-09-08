package thread.book2.char0_3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomIntegerDemo {


    private  static   AtomicInteger tmp=new AtomicInteger();

    public static void main(String[] args) {

        Runnable task=()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(tmp.getAndIncrement());
            }
        };


        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task);
        thread.start();
        thread2.start();


    }


}
