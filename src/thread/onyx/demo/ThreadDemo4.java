package thread.onyx.demo;

/**
 * @author zk
 * @Description:
 * 一个计数器，计数到100，在每个数字之间暂停1秒，每隔10个数字输出一个字符串
 * @date 2018-05-25 13:58
 */
public class ThreadDemo4  implements Runnable{

    @Override
    public void run() {
        for (int j = 1; j < 100; j++) {
            if(j%10==0){
                System.out.println("这是输出的一个字符串");
            }
            System.out.println(j);
            try {
                Thread.sleep(1000);
                System.out.println("刚睡眠了1000ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadDemo4()).start();
    }

}
