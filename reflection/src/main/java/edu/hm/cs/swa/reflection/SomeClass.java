package edu.hm.cs.swa.reflection;

import java.util.Date;

/**
 * Created by sebas on 03.04.2017.
 */
public class SomeClass {

    @RenderMe private int foo;
    @RenderMe(with = "edu.hm.cs.swa.reflection.ArrayRenderer") int[] array = {1, 2, 3, };
    @RenderMe private Date date = new Date(123456789);

    public SomeClass(int foo) {
        this.foo = foo;
    }

}
