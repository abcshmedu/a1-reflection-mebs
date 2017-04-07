package edu.hm.cs.swa.reflection.someclasses;

/**
 * Created by ehsan on 07.04.17.
 */
public class TestObject {
    private int ifoo;
    private String sfoo;

    public TestObject(int ifoo, String sfoo) {
        this.ifoo = ifoo;
        this.sfoo = sfoo;
    }

    public int getIfoo() {
        return ifoo;
    }

    public void setIfoo(int ifoo) {
        this.ifoo = ifoo;
    }

    public String getSfoo() {
        return sfoo;
    }

    public void setSfoo(String sfoo) {
        this.sfoo = sfoo;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "ifoo=" + ifoo +
                ", sfoo='" + sfoo + '\'' +
                '}';
    }
}
