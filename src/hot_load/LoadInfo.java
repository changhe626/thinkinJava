package hot_load;

/**
 * Created by zk on 2017/12/23.
 * 作用: classload.
 * 要封装加载类的信息
 */
public class LoadInfo {

    //自定义的类加载器
    private MyClassLoader myClassLoader;

    //记录要加载的类的时间戳 --加载的时间
    private long loadTime;

    private BaseManager baseManager;

    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }
}
