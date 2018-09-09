package java8;

/**
 * @author zk
 * @Description:
 * Java 8 新增了接口的默认方法。
    简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
    我们只需在方法名前面加个default关键字即可实现默认方法。
    为什么要有这个特性？
    首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，
    目前的java 8之前的集合框架没有foreach方法，通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。然而，对于已经发布的版本，
    是没法在给接口添加新方法的同时不影响已有的实现。所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现不兼容的问题。


显然默认接口的出现打破了之前的一些基本规则，使用时要注意几个问题。

考虑如果接口中定义了一个默认方法，而另外一个父类或者接口中又定义了一个同名的方法，该选择哪个？

1. 选择父类中的接口。如果一个父类提供了具体的实现方法，那么接口中具有相同名称和参数的默认方法会被忽略。

2. 接口冲突。如果一个父接口提供了一个默认方法，而另一个接口也提供了具有相同名称和参数类型的方法（不管该方法是否是默认方法），那么必须通过覆盖方法来解决。

记住一个原则，就是“类优先”，即当类和接口都有一个同名方法时，只有父类中的方法会起作用。

“类优先”原则可以保证与Java 7的兼容性。如果你再接口中添加了一个默认方法，它对Java 8以前编写的代码不会产生任何影响。

下面来说说静态方法。

静态方法就像一个普通Java静态方法，但方法的权限修饰只能是public或者不写。

默认方法和静态方法使Java的功能更加丰富。
 * @date 2018-09-04 11:22
 */
public class DefaultMethod {


    public static void main(String[] args) {
        new Animal() {
            @Override
            public int eat() {
                return 0;
            }
        }.say();

        //直接调用静态方法
        //Java 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法
        Animal.print2();


        //第一个解决方案是创建自己的默认方法，来覆盖重写接口的默认方法：
        /*public class Car implements Vehicle, FourWheeler {
            default void print(){
                System.out.println("我是一辆四轮汽车!");
            }
        }*/


        /*第二种解决方案可以使用 super 来调用指定接口的默认方法：
        public class Car implements Vehicle, FourWheeler {
            public void print(){
                Vehicle.super.print();
            }
        }*/
    }

}

interface Animal{

    default void say(){
        System.out.println("叫声");
    }

    int eat();

    //静态方法
    static void print2(){
        System.out.println("这是static方法");
    }
}


interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}
