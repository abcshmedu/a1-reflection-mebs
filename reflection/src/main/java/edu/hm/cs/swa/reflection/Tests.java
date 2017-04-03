package edu.hm.cs.swa.reflection;

import java.lang.reflect.Field;

/**
 * Created by sebas on 02.04.2017.
 */
public class Tests {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> type = (args[0]).getClass();
        for(Field field: type.getDeclaredFields()) {
            System.out.println(field.getType().getSimpleName());
        }
        //System.out.println("Die enthaltenen Variblen sind: " + type.getDeclaredField("firstVariable").toString());
    }

}