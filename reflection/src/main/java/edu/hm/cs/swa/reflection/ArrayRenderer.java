package edu.hm.cs.swa.reflection;

/**
 * Created by sebas on 03.04.2017.
 */
public class ArrayRenderer {

    String s = "[";
    int[] array;
    public ArrayRenderer(){}

    public ArrayRenderer(int[] array) {
        this.array = array;
    }

    /*
    Soll einfaches Int-Array rendern! Nicht komplizierter machen!
     */
    public String render() throws IllegalAccessException {

        for (int i = 0; i < this.array.length; i++) {
            s += this.array[i] + ", ";
        }
        return s += "]";
    }
}
