package edu.hm.cs.swa.reflection.someclasses;

import edu.hm.cs.swa.reflection.RenderMe;

/**
 * Created by ehsan on 07.04.17.
 */
//Fuer IllegalArgumentException
public class SomeClassB {
    @RenderMe(with = "edu.hm.cs.swa.reflection.ArrayRenderer")
    String[] array = {"Hello", "Reflection"};
}
