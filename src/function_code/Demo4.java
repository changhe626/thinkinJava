package function_code;

import java.util.Optional;

public class Demo4 {
    public static void main(String[] args) {


        new Parent() {
            @Override
            public void say(String name) {
            }
            @Override
            public void say2() {
            }
        }.welcome("sa");


        Optional<String> a = Optional.of("a");
        System.out.println(a);

        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        System.out.println(empty.orElse("d"));
        //Exception in thread "main" java.util.NoSuchElementException: No value present
        //System.out.println(empty.get());




    }
}

interface Parent{
    void say(String name);

    //默认方法,必须加上default....
    default  String welcome(String id){
        System.out.println("这是默认方法的id:"+id);
        return id;
    }

    void say2();

}
