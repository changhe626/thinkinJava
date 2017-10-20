package com.iee754;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zk on 2017/10/19.
 * 32位浮点数IEEE754格式： 1位符号位 + 8位指数位 + 23位尾数
 转换思路：
 1、计算整数部分的二进制格式；
 2、计算小数部分的二进制格式；
 3、位移并计算指数
 4、合并

 */
public class IEEE754 {
    public static void main(String[] args) {
        Float f = 100.2f;
        IEEE754 ieee = new IEEE754();

        String ieee754 = ieee.floatToIEEE754(f);
        System.out.println(ieee754);
    }

    /**
     * 获取float的IEEE754存储格式
     * @param value
     * @return
     */
    public String floatToIEEE754(float value) {
        //符号位
        String sflag = value > 0 ? "0" : "1";

        //整数部分
        int fz = (int) Math.floor(value);
        //整数部分二进制
        String fzb = Integer.toBinaryString(fz);
        //小数部分，格式： 0.02
        String valueStr = String.valueOf(value);
        String fxStr = "0" + valueStr.substring(valueStr.indexOf("."));
        float fx = Float.parseFloat(fxStr);
        //小数部分二进制
        String fxb = toBin(fx);

        //指数位
        String e = Integer.toBinaryString(127 + fzb.length() - 1);
        //尾数位
        String m = fzb.substring(1) + fxb;

        String result = sflag + e + m;

        while (result.length() < 32) {
            result += "0";
        }
        if (result.length() > 32) {
            result = result.substring(0, 32);
        }
        return result;
    }

    private String toBin(float f) {
        List<Integer> list = new ArrayList<Integer>();
        Set<Float> set = new HashSet<Float>();
        int MAX = 24; // 最多8位

        int bits = 0;
        while (true) {
            f = calc(f, set, list);
            bits++;
            if (f == -1 || bits >= MAX)
                break;
        }
        String result = "";
        for (Integer i : list) {
            result += i;
        }
        return result;
    }

    private float calc(float f, Set<Float> set, List<Integer> list) {
        if (f == 0 || set.contains(f))
            return -1;
        float t = f * 2;
        if (t >= 1) {
            list.add(1);
            return t - 1;
        } else {
            list.add(0);
            return t;
        }
    }
}


/**
 *
 * NaN 用于处理计算中出现的错误情况，比如 0.0 除以 0.0 或者求负数的平方根。由上面的表中可以看出，对于单精度浮点数，
 * NaN 表示为指数为 emax + 1 = 128（指数域全为 1），且尾数域不等于零的浮点数。IEEE 标准没有要求具体的尾数域，
 * 所以 NaN 实际上不是一个，而是一族。不同的实现可以自由选择尾数域的值来表达 NaN，
 * 比如 Java 中的常量 Float.NaN 的浮点数可能表达为 01111111110000000000000000000000，其中尾数域的第一位为 1，
 * 其余均为 0（不计隐藏的一位），但这取决系统的硬件架构。Java 中甚至允许程序员自己构造具有特定位模式的 NaN 值
 * （通过 Float.intBitsToFloat() 方法）。比如，程序员可以利用这种定制的 NaN 值中的特定位模式来表达某些诊断信息。
 *
   定制的 NaN 值，可以通过 Float.isNaN() 方法判定其为 NaN，但是它和 Float.NaN 常量却不相等。实际上，
 所有的 NaN 值都是无序的。数值比较操作符 <，<=，> 和 >= 在任一操作数为 NaN 时均返回 false。
 等于操作符 == 在任一操作数为 NaN 时均返回 false，即使是两个具有相同位模式的 NaN 也一样。
 而操作符 != 则当任一操作数为 NaN 时返回 true。这个规则的一个有趣的结果是 x!=x 当 x 为 NaN 时竟然为真。
 *
 *
 *
 * 此外，任何有 NaN 作为操作数的操作也将产生 NaN。用特殊的 NaN 来表达上述运算错误的意义在于避免了因这些错误而导致运算的不必要的终止。
 * 比如，如果一个被循环调用的浮点运算方法，可能由于输入的参数问题而导致发生这些错误，
 * NaN 使得 即使某次循环发生了这样的错误，也可以简单地继续执行循环以进行那些没有错误的运算。
 * 你可能想到，既然 Java 有异常处理机制，也许可以通过捕获并忽略异常达到相同的效果。但是，要知道，
 * IEEE 标准不是仅仅为 Java 而制定的，各种语言处理异常的机制不尽相同，这将使得代码的迁移变得更加困难。
 * 何况，不是所有语言都有类似的异常或者信号（Signal）处理机制。
 注意: Java 中，不同于浮点数的处理，整数的 0 除以 0 将抛出 java.lang.ArithmeticException 异常。
 */