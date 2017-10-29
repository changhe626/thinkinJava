package com.myEnum;


public enum Shrubbery {
    GROUND,CRAWLING,HANING;

}

/**
 * 枚举类型的遍历
 */
class EnumClass{
    public static void main(String[] args) {
        Shrubbery[] values = Shrubbery.values();
        for (Shrubbery value : values) {
            System.out.println(value);
        }


    }

}
