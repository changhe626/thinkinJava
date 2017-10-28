package com.innerclass;

public interface ClassInInterface {

    void howdy();

    class Test implements ClassInInterface{

        @Override
        public void howdy() {
            System.out.println("这是接口中嵌套的类实现了本接口");
        }

        /**
         * 这样就可以直接运行了
         * @param args
         */
        public static void main(String[] args) {
            new Test().howdy();

            new Test2().howdy();
        }
    }

}


class Test2 implements ClassInInterface{

    @Override
    public void howdy() {
        System.out.println("这是第二个实现的方法");
    }
}
