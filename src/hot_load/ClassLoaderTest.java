package hot_load;

/**
 * Created by zk on 2017/12/23.
 * 作用: classload.
 * 测试java类的热加载
 *
 *
 * 注意IDEA不是实时编译的,请在eclipse上debug试验
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
    }
}
