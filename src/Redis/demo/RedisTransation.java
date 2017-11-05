package Redis.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class RedisTransation {

    @Test
    public void test(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushAll();
        Transaction transaction = jedis.multi();
        Response<String> set = transaction.set("k1", "v1");
        System.out.println(set); //Response string
        transaction.set("k2","v2");
        Response<String> set1 = transaction.set("k3", "v3");
        System.out.println(set1);  //Response string

       // transaction.exec();

        transaction.discard();

    }


    public void test2(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);


//监控key，如果该动了事务就被放弃
/*3
     jedis.watch("serialNum");
     jedis.set("serialNum","s#####################");
     jedis.unwatch();*/
/*
     
     Transaction transaction = jedis.multi();//被当作一个命令进行执行
     Response<String> response = transaction.get("serialNum");
     transaction.set("serialNum","s002");
     response = transaction.get("serialNum");
     transaction.lpush("list3","a");
     transaction.lpush("list3","b");
     transaction.lpush("list3","c");
     
     transaction.exec();
     //2 transaction.discard();
     System.out.println("serialNum***********"+response.get());


    **/

    }


    public void test3(){
/*
        public boolean transMethod() {
     Jedis jedis = new Jedis("127.0.0.1", 6379);
     int balance;// 可用余额
     int debt;// 欠额
     int amtToSubtract = 10;// 实刷额度


     jedis.watch("balance");
     //jedis.set("balance","5");//此句不该出现，讲课方便。模拟其他程序已经修改了该条目
     balance = Integer.parseInt(jedis.get("balance"));
     if (balance < amtToSubtract) {
       jedis.unwatch();
       System.out.println("modify");
       return false;
     } else {
       System.out.println("***********transaction");
       Transaction transaction = jedis.multi();
       transaction.decrBy("balance", amtToSubtract);
       transaction.incrBy("debt", amtToSubtract);
       transaction.exec();
       balance = Integer.parseInt(jedis.get("balance"));
       debt = Integer.parseInt(jedis.get("debt"));

       System.out.println("*******" + balance);
       System.out.println("*******" + debt);
       return true;
     }
  }

*/


/**
    * 通俗点讲，watch命令就是标记一个键，如果标记了一个键，
        在提交事务前如果该键被别人修改过，那事务就会失败，这种情况通常可以在程序中
    * 重新再尝试一次。
    * 首先标记了键balance，然后检查余额是否足够，不足就取消标记，并不做扣减；
        足够的话，就启动事务进行更新操作，
    * 如果在此期间键balance被其它人修改， 那在提交事务（执行exec）时就会报错，
        程序中通常可以捕获这类错误再重新执行一次，直到成功。
/*
  public static void main(String[] args) {
     TestTransaction test = new TestTransaction();
     boolean retValue = test.transMethod();
     System.out.println("main retValue-------: " + retValue);
  }

   */

    }

}
