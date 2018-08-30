package thread.onyx.demo;

/**
 * @author zk
 * @Description:
 * @date 2018-05-25 13:54
 */
public class ThreadDemo3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {


        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                long millis = System.currentTimeMillis();
                Thread.sleep(3000);
                long timeMillis = System.currentTimeMillis();
                System.out.println(timeMillis-millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i"+i);

        }
    }


}
