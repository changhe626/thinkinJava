package thread.book2.char4;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 停止线程,过期的方法
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread runner = new Thread(new Runner(), "runner");
        runner.setDaemon(true);
        runner.start();
        TimeUnit.SECONDS.sleep(3);
        //讲runner暂停,输出内容工作停止
        runner.suspend();
        System.out.println("暂停了"+format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        //讲runner恢复,输出内容
        runner.resume();
        System.out.println("恢复了"+format.format(new Date()));

        TimeUnit.SECONDS.sleep(3);

        runner.stop();
        System.out.println("停止了"+format.format(new Date()));


    }

    static class Runner implements Runnable{


        @Override
        public void run() {

            String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(Thread.currentThread().getName()+"~~~"+format);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
