package thread.onyx.demo3;

/**
 * 错误3
 */
public class SellTicketThread2{

    public static void main(String[] args) {

        SellTicketThread2Task task1 = new SellTicketThread2Task();
        SellTicketThread2Task task2= new SellTicketThread2Task();
        task1.setName("陆逊");
        task2.setName("孙悟空");

        task1.start();
        task2.start();


    }


}

class SellTicketThread2Task extends Thread{

    private  static int num=100;

    @Override
    public void run() {
        Object o = new Object();
        while(true){
            synchronized (o){
                if(num>0){
                    System.out.println(num+"..."+Thread.currentThread().getName());
                    num--;
                }else {
                    break;
                }
            }
        }

    }


}


class De2 implements Runnable {
    private int t = 100;
    private Object ob = new Object();

    @Override
    public void run() {
        while (t > 0) {
            //这样写还会出现第0张票的问题!!!! 外面用true控制循环就行了
            //while 如果再下面,就是一个窗口把票全部售完
            //因为,当t/t1=1,到这里停住了,切换了线程,假设先执行了t,执行完毕后t=0了,
            // 这时候停在这里的t1就是0 了,但是t1不用判断了,所以也是可以进去的,
            // 所以就有了0张票的这种情况的出现,所以要把所有的东西包起来的
            synchronized (ob) {
                System.out.println("sell ticket" + t + Thread.currentThread().getName());
                t--;
            }
        }
    }
}

