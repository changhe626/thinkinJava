package thread.book2.char4;

import java.util.concurrent.TimeUnit;

public class Daemon {
    public static void main(String[] args) {

        Thread daemon = new Thread(new DaemonRunner(), "daemon");
        daemon.setDaemon(true);
        daemon.start();

    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("this is Daemon is  finally");
            }
        }
    }

}
