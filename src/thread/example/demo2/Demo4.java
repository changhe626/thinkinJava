package thread.example.demo2;

public class Demo4 extends Thread {
    private int i=10;

    @Override
    public  synchronized void run() {
        System.out.println("i="+(i--)+"threadName ="+Thread.currentThread().getName());
        /**
         * println()  是线程安全的,但是i--却不是线程安全的...
         *
         public void println(String x) {
         synchronized (this) {
         print(x);
         newLine();
         }
         }
         应该是用同步方法
         */
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        Thread t1 = new Thread(demo4);
        Thread t2 = new Thread(demo4);
        Thread t3 = new Thread(demo4);
        Thread t4 = new Thread(demo4);
        Thread t5 = new Thread(demo4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


}
