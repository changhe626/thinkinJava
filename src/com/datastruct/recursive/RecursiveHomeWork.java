package com.datastruct.recursive;

/**
 * Created by zk on 2017/9/19.
 * 作用: com.datastruct.recursive.
 */
public class RecursiveHomeWork {

    public static void main(String[] args){
        System.out.println(xY(2,3));
        System.out.println(multiply(3,3));
        System.out.println(changeWords2("12345"));

    }


    /**
     * x的y次方的计算
     * @param x
     * @param y
     * @return
     */
    public static int xY(int x,int y){
        if(x<=0 || y<=0){
            throw new UnsupportedOperationException("参数错误");
        }
        if(y==1){
            return x;
        }
        return x*xY(x,y-1);
    }

    /**
     * x*y 的递归,加法的计算
     * @param x
     * @param y
     */
    public static int multiply(int x,int y){
        if(y==1){
            return x;
        }
        return x+multiply(x,y-1);
    }


    /**
     * 后两个数是前面两个数字的和,不是递归的做法
     * @return
     */
    public static int[] intArray(){
        int[] arr=new int[100];
        arr[0]=0;
        arr[1]=1;
        //很容易控制住范围的大小
        for (int i = 2; i < arr.length; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr;
    }

    /**
     * 递归的做法是,不是很容易控制范围
     */
    public static int intArray2(int index){
        if(index==1 || index==2) return  1;
        return intArray2(index-1)+intArray2(index-2);
    }


    /**
     * 阶乘
     */
    public static int jieCheng(int x){
        //递归的写法
        /*if(x==1){
            return  1;
        }else{
            return  x*jieCheng(x-1);
        }*/

        //不是用递归
        int num=1;
        for (int i = 1; i <=x; i++) {
             num=num*i;
        }
        return num;
    }


    /**
     * 改变字符串的顺序,非递归的方式
     * @param s
     * @return
     */
   public static String changeWords(String s){
       StringBuilder sb = new StringBuilder();
       for (int i = s.length(); i >=0; i--) {
            sb.append(s.charAt(i));
       }
       return sb.toString();
   }

    /**
     * 递归的方式
     * @param s
     * @return
     */
    public static String changeWords2(String s){
        if(s==null || s.length()<0){
            throw new UnsupportedOperationException("");
        }
        if(s.length()==1 || s.length()==0){
            return s;
        }
        //取出第一个和最后一个字符,进行拼接
        char start=s.charAt(0);
        char end=s.charAt(s.length()-1);
        if(s.length()==2){
            return end+""+start;
        }
        //不断的进行字符串的缩减
        return  end+changeWords2(s.substring(1,s.length()-1))+start;

    }


}
