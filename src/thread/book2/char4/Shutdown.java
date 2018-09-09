package thread.book2.char4;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread = new Thread(runner, "runner");
        thread.start();

        //睡眠1s,main线程对thread进行中断,使thread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        Runner runner1 = new Runner();
        thread = new Thread(runner1, "runner2");
        thread.start();

        //睡眠1s,main线程对Runner runner1 进行取消,使thread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        runner1.cancel();




    }

    static class Runner implements Runnable{

        private long i;
        private volatile boolean on=true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("count i="+i);
        }
        public void cancel(){
            on=false;
        }

    }


}
