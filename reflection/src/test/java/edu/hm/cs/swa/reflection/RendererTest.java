package edu.hm.cs.swa.reflection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class RendererTest {

    private SomeClass toRender;
    private Renderer renderer;

    @Before
    public void setUp() throws Exception {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void render() throws Exception {
        assertEquals("Instance of edu.hm.cs.swa.reflection.SomeClass:\n" + "foo (Type int): 5\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }

}