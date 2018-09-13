package com.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zk on 2017/10/8.
 * 作用: com.annotation.
 */
public class UseCaseTracker {

    public static void main(String[] args) {

        Class<PasswordUtils> aClass = PasswordUtils.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if(useCase!=null){
                System.out.println(useCase.id()+"~~"+useCase.description());
            }
        }
    }


    /*public static void main(String[] args){
        ArrayList<Integer> useCase = new ArrayList<Integer>();
        Collections.addAll(useCase,47,48,49,50);
        trackUseCase(useCase,PasswordUtils.class);
    }

    private static void trackUseCase(ArrayList<Integer> useCase, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc!=null){
                System.out.println(uc.description());
                useCase.remove(Integer.valueOf(uc.id()));
            }
        }
        for (Integer integer : useCase) {
            System.out.println(integer);
        }


    }*/
}
