package thread.onyx.demo;

/**
 * @author zk
 * @Description:
 * @date 2018-05-25 13:44
 */
public class ThreadDemo1  extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("重写run方法"+i+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        new ThreadDemo1().start();
        new ThreadDemo1().start();


    }

}
