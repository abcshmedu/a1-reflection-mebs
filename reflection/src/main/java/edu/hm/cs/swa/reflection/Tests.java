package edu.hm.cs.swa.reflection;

import edu.hm.cs.swa.reflection.someclasses.SomeClass;
import edu.hm.cs.swa.reflection.someclasses.SomeClassA;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by sebas on 02.04.2017.
 */
public class Tests {

    /**
     *
     * @param args for bla bla
     * @throws NoSuchFieldException
     * @throws ClassNotFoundException 
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
    	SomeClass s = new SomeClass(3);
        SomeClassA a = new SomeClassA();
        Renderer r = new Renderer(s);
        //System.out.println(r.render());
        System.out.println(r.renderMethod());
    }

}
