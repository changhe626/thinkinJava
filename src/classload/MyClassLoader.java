package classload;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by zk on 2017/12/23.
 * 作用: classload.
 * 自定义java类加载器,来实现java的类的热加载
 */
public class MyClassLoader  extends  ClassLoader{

    //要加载的java类的classpath路径
    private String classPath;

    public MyClassLoader( String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data=this.loadClassData(name);


        return this.defineClass(name,data,0,data.length);
    }

    /**
     * 加载class文件中的内容
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            name = name.replace(".", "/");
            FileInputStream is = new FileInputStream(new File(classPath + name + ".class"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b=0;
            while((b=is.read())!=-1){
                bos.write(b);
            }
            is.close();
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
