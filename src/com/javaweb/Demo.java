package com.javaweb;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by zk on 2017/10/31.
 * 作用: com.javaweb.
 */
public class Demo {

    /**
     * 文件读取从字节变成字符的示例
     */
    @Test
    public void test(){
        StringBuffer sb = new StringBuffer();
        char[] buf=new char[1024];
        try {
            FileReader f = new FileReader("");
            while(f.read(buf)>0){
                sb.append(buf);
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

        }

    }
}
