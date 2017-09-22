package com.datastruct.queue;

/**
 * Created by zk on 2017/9/22.
 * 作用: com.datastruct.queue.
 * 加密的示例
 */
public class Code {

    public static void main(String[] args){
        int[] key={5,12,-3,8,-9,4,10};
        int keyValue;
        String encoded="";
        String decoded="";
        String message="昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒";
        LinkedQueue queue1 = new LinkedQueue();
        LinkedQueue queue2 = new LinkedQueue();
        for (int i = 0; i < key.length; i++) {
            queue1.enqueue(new Integer(key[i]));
            queue2.enqueue(new Integer(key[i]));
        }

        //encode message
        for (int i = 0; i < message.length(); i++) {
            keyValue = ((Integer) queue1.dequeue()).intValue();
            encoded+=(char)(message.charAt(i)+keyValue);
            queue1.enqueue(new Integer(keyValue));
        }
        System.out.println("encoded message"+encoded+"\n");
        //decode message
        for (int i = 0; i < encoded.length(); i++) {
            keyValue = ((Integer) queue2.dequeue()).intValue();
            decoded+=(char)(encoded.charAt(i)-keyValue);
            queue2.enqueue(new Integer(keyValue));
        }
        System.out.println("encoded message"+decoded+"\n");
    }

}
