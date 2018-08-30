package thread.onyx.demo2;

import java.util.Date;

public class SleepDemo {

   // new Thread()

    public static void main(String[] args) {
        SleepTask task = new SleepTask();
        Thread thread = new Thread(task,"曹操");
        Thread thread2 = new Thread(task,"刘备");
        thread.start();
        thread2.start();


    }
}


class SleepTask implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-----"+i+"~~~"+new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
