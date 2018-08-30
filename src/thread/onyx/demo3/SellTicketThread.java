package thread.onyx.demo3;

/**
 * 错误2
 */
public class SellTicketThread extends Thread {

    private int num=100;


    @Override
    public void run() {
        while(num>0){
            System.out.println(Thread.currentThread().getName() + " 出票：" + num);
            num--;
        }

    }

    public static void main(String[] args) {
        SellTicketThread thread = new SellTicketThread();
        Thread thread1 = new Thread(thread,"window1");
        Thread thread2 = new Thread(thread,"windoes22");
        Thread thread3 = new Thread(thread,"windows333");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
