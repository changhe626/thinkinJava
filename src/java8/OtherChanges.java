package java8;

/**
 * @author zk
 * @Description:
 * @date 2018-09-04 11:56
 */
public class OtherChanges {
    public static void main(String[] args) {

        String joined = String.join("#", "www", "zhaojun", "s");
        // www.cnblogs.com
        System.out.println(joined);

        /**
         * 数字包装类提供了BYTES静态方法，以byte为单位返回长度。

         所有八种包装类都提供了静态的hashCode方法。

         Short、Integer、Long、Float和Double这5种类型分别提供了了sum、max和min，用来在流操作中作为聚合函数使用。
         */
        int hashCode = Integer.hashCode(4);
        System.out.println(hashCode);

        int max = Integer.max(3, 5);
        System.out.println(max);

        System.out.println(Integer.min(5,-5));

        System.out.println(Integer.sum(5,7));


    }
}
