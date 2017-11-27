package Redis.demo;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.List;
import java.util.Set;

/**
 * 2017.11.5.18:47
 */
public class RedisOperate {

    private Jedis jedis;

    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String set = jedis.set("k1", "v1");
        System.out.println(set);  // OK
        jedis.set("k2","v2");
        jedis.set("k3","v3");


        String k1 = jedis.get("k1");
        System.out.println(k1);
        String k5 = jedis.get("k5");  //null
        System.out.println(null==k5); //true
        System.out.println(k5);

        System.out.println("~~~~~~~");
        Set<String> sets=  jedis.keys("*");
        System.out.println(sets);

        System.out.println(sets.size());
    }



    @Before
    public void before(){
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @Test
    public void testKey(){
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        for (String key : keys) {
            System.out.println(key);
        }

        Boolean k5 = jedis.exists("k5");
        System.out.println("k5"+k5); //false
        Long k1 = jedis.ttl("k1");
        System.out.println("k1"+k1);  //-1
        Long k8 = jedis.ttl("k8");
        System.out.println("k8"+k8);  //-2

    }

    @Test
    public void testString(){
        String s = jedis.flushDB();
        System.out.println("s:"+s); //OK
        String k1 = jedis.set("k1", "11");
        System.out.println(k1);//OK
        String mset = jedis.mset("k1","111","k2","222","k3","333");
        System.out.println(mset); //OK
        Set<String> keys = jedis.keys("*");
        System.out.println(keys); //[k3, k1, k2]
        List<String> k1_k2_k5 = jedis.mget("k1","k2","k5");
        System.out.println(k1_k2_k5);//[111, 222, null]

        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget); //[111, 222]

    }

    @Test
    public void testList(){
        jedis.flushAll();
        String select = jedis.select(1);
        System.out.println(select); //OK
        Long list1 = jedis.lpush("list1", "1", "2", "3", "4");

        List<String> list11 = jedis.lrange("list1", 0L, -1L);
        System.out.println(list11);  // [4, 3, 2, 1]
        Long list12 = jedis.llen("list1");
        System.out.println(list12);   //8
        String list13 = jedis.lpop("list1");  //4
        String list14=jedis.lpop("list1");   //3
        System.out.println(list13+"~~"+list14);
    }


    @Test
    public void testSet(){
        jedis.flushAll();
        jedis.sadd("k1","v1","v2","v3");
        Long sadd = jedis.sadd("k2", "a", "b", "c", "d");
        System.out.println(sadd);   //4


        Set<String> k1 = jedis.smembers("k1");
        System.out.println(k1);  //[v1, v2, v3]
        Long srem = jedis.srem("k1", "v1", "v2", "v3");
        System.out.println(srem); //3
        System.out.println(jedis.smembers("k1"));// []
        System.out.println( jedis.smembers("k2").size() );  //4

    }


    @Test
    public void testHash(){
        jedis.flushAll();
        Long hset = jedis.hset("user", "id", "1");
        jedis.hset("user","age","23");
        System.out.println(hset);//1
        String s = jedis.hget("user", "id");
        System.out.println(jedis.hget("users", "id"));//null
        System.out.println(jedis.hget("user","id2"));//null
        Set<String> hkeys = jedis.hkeys("user");
        System.out.println("keys:"+hkeys); //[age, id]
        List<String> user = jedis.hvals("user");
        System.out.println("user:"+user);//[1, 23]

    }


    @Test
    public void testZset(){
        jedis.flushAll();
        Long zset1 = jedis.zadd("zset1", 1D, "11");
        System.out.println(zset1);  //1
        jedis.zadd("zset1",2D,"22");
        jedis.zadd("zset1",3D,"33");
        jedis.zadd("zset1",4D,"44");
        jedis.zadd("zset1",5D,"55");

        Long zset2 = jedis.zadd("zset2", 2D, "22");

        Long zset11 = jedis.zcard("zset1");
        System.out.println(zset11);  //5
        Set<String> zset111 = jedis.zrange("zset1", 0L, -1L);
        System.out.println(zset111);  //[11, 22, 33, 44, 55]
        //if not exits is []

    }





}
