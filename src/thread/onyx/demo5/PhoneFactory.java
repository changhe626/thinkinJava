package thread.onyx.demo5;

public class PhoneFactory {
    private  String name;
    private  double price;
    private int i=0;
    private boolean  hasPhone=false;


    public synchronized void  producePhone() throws InterruptedException {
        if(hasPhone){
            this.wait();
        }else{
            if(i%2==0){
                this.name="xiaomi";
                this.price=32.4D;
            }else{
                name="huawei";
                price=43.5D;
            }
            hasPhone=true;
            i++;
            notify();
        }
    }


    // 对外提供消费手机的功能
    public synchronized void consume() throws InterruptedException{
        // 判断是否有手机
        if(!hasPhone){
            // 没有手机，则等待
            this.wait();
        }							//也可以用else把代码包起来的.后面到了while就不能用else了
        // 消费手机
        System.out.println("消费了手机：" + name + " ... " + price);
        // 修改标记，代表没有手机
        this.hasPhone = false;
        // 消费之后，唤醒生产者
        this.notify();
    }



}
