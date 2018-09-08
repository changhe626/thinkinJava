package hot_load;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zk on 2017/12/23.
 * 作用: classload.
 * 工厂模式,加载manager 的工厂
 */
public class ManagerFactory {

    //加载热加载类的加载信心
    private static final Map<String,LoadInfo> loadTimeMap=new HashMap<String,LoadInfo>();

    //要加载的类的classpath
    public static final String CLASS_PATH="C:/workspace/idea/thinkinJava/out/production/thinkinJava/classload";

    //实现热加载的类的全名称,包名+类名
    public static final String MY_MANAGER="classload.MyManager";

    /**
     * 获取manager
     * @param className
     * @return
     */
    public static BaseManager getManager(String className){
        File loadFile = new File(CLASS_PATH + className.replace(".", "/" + ".class"));
        long lastModified=loadFile.lastModified();
        //不包含className为key的loadinfo信息,证明没有被加载,需要加载这么类到JVM,重新加载,
        if(loadTimeMap.get(className)==null){
            load(className,lastModified);
            //加载类的时间戳变化了,同样重新加载这个类到JVM
        }else if(loadTimeMap.get(className).getLoadTime()!=lastModified){
            load(className,lastModified);
        }
        return loadTimeMap.get(className).getBaseManager();
    }

    public static void load(String className,long lastModified){
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?>  loadClass=null;
        try {
            loadClass=myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager=newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
        loadInfo.setBaseManager(manager);
        loadTimeMap.put(className,loadInfo);

    }

    /**
     * 以反射的方式创建baseManager子类对象
     * @param loadClass
     * @return
     */
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


}
