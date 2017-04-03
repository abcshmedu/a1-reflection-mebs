package edu.hm.cs.swa.reflection;

/**
 * Created by sebas on 02.04.2017.
 */
public class Tests {

    /**
     *
     * @param args for bla bla
     * @throws NoSuchFieldException
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    	SomeClass s = new SomeClass(3);
        Renderer r = new Renderer(s);
        System.out.println(r.render(s));
    }

}
