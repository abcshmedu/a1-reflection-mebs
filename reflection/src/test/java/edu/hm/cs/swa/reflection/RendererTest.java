package edu.hm.cs.swa.reflection;

import edu.hm.cs.swa.reflection.someclasses.SomeClass;
import edu.hm.cs.swa.reflection.someclasses.SomeClassA;
import edu.hm.cs.swa.reflection.someclasses.SomeClassB;
import edu.hm.cs.swa.reflection.someclasses.SomeClassC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RendererTest {

    private SomeClass toRender;
    private Renderer renderer;
    private SomeClassA toRenderA;
    private SomeClassB toRenderB;
    private SomeClassC toRenderC;

    public RendererTest() {
    }

    @Before
    public void setUp() throws Exception {
        toRender = new SomeClass(5);
        toRenderA = new SomeClassA();
        toRenderB = new SomeClassB();
        toRenderC = new SomeClassC(7);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void renderTest() throws Exception {
        renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.cs.swa.reflection.someclasses.SomeClass:\n"
                + "foo (Type int): 5\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noneIntArray_renderTest() throws Exception {
        renderer = new Renderer(toRenderB);
        renderer.render();
    }

    @Test
    public void nullRenderTest() throws Exception {
        renderer = new Renderer(toRenderA);
        assertEquals("Instance of edu.hm.cs.swa.reflection.someclasses.SomeClassA:\n"
                + "sfoo (Type java.lang.String): null\nifoo (Type java.lang.Integer): 0\ntfoo (Type edu.hm.cs.swa.reflection.someclasses.TestObject): null\n", renderer.render());
    }

    @Test
    public void noneAnnotRenderTest() throws Exception {
        renderer = new Renderer(toRenderC);
        assertEquals("Instance of edu.hm.cs.swa.reflection.someclasses.SomeClassC:\n", renderer.render());
    }

    /*TODO : Tests mit Ohnen Annotations
             Tests mit anderen Arraytypen als int

     */

}