package hot_load;

/**
 * Created by zk on 2017/12/23.
 * 作用: classload.
 * 后台启动一条线程,刷新重新加载实现了热加载的类
 */
public class MsgHandle implements  Runnable {
    @Override
    public void run() {

        while (true){
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
