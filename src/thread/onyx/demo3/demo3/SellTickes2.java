package thread.onyx.demo3.demo3;

public class SellTickes2 {

    public static void main(String[] args) {

        Sell2 sell2 = new Sell2();
        Thread thread1 = new Thread(sell2);
        Thread thread2 = new Thread(sell2);
        Thread thread3 = new Thread(sell2);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Sell2 implements Runnable{

    private int num=100;
    @Override
    public  synchronized  void run() {
        while(num>0){
            System.out.println(num);
            num--;
        }
    }
}
