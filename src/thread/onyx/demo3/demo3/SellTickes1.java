package thread.onyx.demo3.demo3;

public class SellTickes1 {
    public static void main(String[] args) {
        Sell1 sell1 = new Sell1();
        Thread thread = new Thread(sell1, "张飞");
        Thread thread2 = new Thread(sell1, "赵云");
        Thread thread3 = new Thread(sell1, "张翼德");
        thread.start();
        thread2.start();
        thread3.start();


    }

}


class Sell1 implements Runnable{

    private Object o=new Object();

    private int  num=100;

    @Override
    public void run() {

        while (true){
            synchronized (o){
                if(num>0){
                    System.out.println(num+"~~"+Thread.currentThread().getName());
                    num--;
                }else{
                    break;
                }
            }
        }
    }
}
