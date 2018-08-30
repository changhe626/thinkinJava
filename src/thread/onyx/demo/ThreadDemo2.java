package thread.onyx.demo;

/**
 * @author zk
 * @Description:
 * @date 2018-05-25 13:49
 */
public class ThreadDemo2  implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("实现接口的多线程"+i+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        ThreadDemo2 threadDemo3 = new ThreadDemo2();
        Thread thread = new Thread(threadDemo2);
        Thread thread2 = new Thread(threadDemo3);
        thread.start();
        //Thread.sleep(1000);
        thread2.start();
    }


}
