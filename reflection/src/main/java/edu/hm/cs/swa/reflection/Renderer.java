package edu.hm.cs.swa.reflection;

/**
 * This is the class Renderer for an easy reflection.
 * @author Sebastian Baumann & Ehsan Moslehi
 */

public class Renderer {

    //TODO set object-variables
	@RenderMe
    private int firstVariable = 0;

    Renderer(int var) {
        //TODO find out what this constructor does with the object as parameter. Which type of object is given as parameter?
        this.firstVariable = var;
    }

    /* @RenderMe */
    /**
     * First implementation of public String render() method.
     * @return message as String
     */
    public String render() {
        //TODO return comfortable string representation like toString()-method
        return String.valueOf(firstVariable);
    }

}
