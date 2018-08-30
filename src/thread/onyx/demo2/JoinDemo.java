package thread.onyx.demo2;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        JoinTask task = new JoinTask();
        Thread thread = new Thread(task, "孙权");
        Thread thread2 = new Thread(task, "孙策");
        Thread thread3 = new Thread(task, "孙坚");
        thread.start();

        thread.join();
        thread2.start();
        thread3.start();
        /**
         * 没有使用thread.join(),产生的结果是三个线程的相互混合,
         * 使用之后,全部的执行完成thread的任务之后,再次执行其他的两个县城的任务....
         */



    }
}


class JoinTask implements Runnable{

    @Override
    public void run() {
        for( int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " .. " + i);
        }
    }
}