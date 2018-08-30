package thread.onyx.demo2;

/**
 * 	public static void yield() 暂停当前线程，执行其它线程/执行到的几率变少了,
 * 	更多的去执行其他的线程了
 但是不能保证两个线程的均匀性,
 只能说两者分到的CPU时间片相对来说大概平均
 */
public class YieldDemo {

    public static void main(String[] args) {

        YieldTask task = new YieldTask();
        Thread first = new Thread(task, "first");
        Thread second = new Thread(task, "second");
        first.start();
        second.start();
    }



}

class  YieldTask implements Runnable{

    @Override
    public void run() {
        /*
        这里的循环次数是10的时候,能够均匀的打印出来
        这里的循环次数换成100,打印出来就不是均匀的了
         */
        for( int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " .. " + i);
            // 礼让
            Thread.yield();
        }
    }
}
