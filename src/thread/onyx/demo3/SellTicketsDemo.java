package thread.onyx.demo3;

/**
 * 错误1
 */
public class SellTicketsDemo {

    public static void main(String[] args) {
        SellTicketTask task = new SellTicketTask();
        Thread thread = new Thread(task, "张辽");
        Thread thread2 = new Thread(task, "许褚");
        thread.start();
        thread2.start();


    }

}


class SellTicketTask  implements Runnable{

    private int num=100;

    @Override
    public void run() {
        while (true){
            Object o = new Object();
            synchronized (o){
                if(num>0){
                    System.out.println(num+"~~~~"+Thread.currentThread().getName());
                    num--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}