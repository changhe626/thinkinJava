package Redis.demo;

import redis.clients.jedis.Jedis;

public class MainCorpy {

    public static void main(String[] args) {
        Jedis jedisMaster = new Jedis("127.0.01", 6379);
        Jedis jedisSlave = new Jedis("127.0.01", 6380);
        jedisSlave.slaveof("127.0.01",6379);
        jedisMaster.set("1","2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = jedisSlave.get("1");
        System.out.println(s);
    }

}

/**
 * 主79写,从80读


 一般很少在java代码中设置主从,一般是
 后台设置主从的.
 从设置
 jedis.slaveof("127.0.0.1",6379);

 主机设置
 jedis1.set("1","2");

 jedis.get("1");


 内存数据库太快,有时候获取不到





 jedis_pool

 尽量少new 用连接池


 人生不就是个吃苦的过程嘛,能吃苦的吃苦半辈子
 不能吃苦的吃苦一辈子

 */
