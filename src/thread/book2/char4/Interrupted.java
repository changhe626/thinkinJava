package thread.book2.char4;

import java.util.concurrent.TimeUnit;

/**
 * 中断线程....状态
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        //不停的睡眠
        Thread sleep = new Thread(new SleepRunner(), "sleep");
        //不停地运行
        Thread busy = new Thread(new BusyRunner(), "busy");
        sleep.setDaemon(true);
        busy.setDaemon(true);
        sleep.start();
        busy.start();

        TimeUnit.SECONDS.sleep(5);

        sleep.interrupt();
        busy.interrupt();
        System.out.println("sleep--"+sleep.isInterrupted());
        System.out.println("busy--"+busy.isInterrupted());

        TimeUnit.SECONDS.sleep(2);


    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                //System.out.println("正在运行");
            }
        }
    }
}



