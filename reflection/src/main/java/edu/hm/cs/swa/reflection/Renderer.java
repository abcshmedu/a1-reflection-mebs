package edu.hm.cs.swa.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is the class Renderer for an easy reflection.
 * @author Sebastian Baumann & Ehsan Moslehi
 */

public class Renderer {

    private Object obj;

    Renderer(Object obj) {
        this.obj = obj;
    }

    /**
     * First implementation of public String render() method.
     * @return message as String
     * @throws IllegalAccessException if field.get(obj) fails to access a value
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
    public String render() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        // variable s stores our output-string-message
        String s = "Instance of ";
        // type creates and stores an object of the given class stored in object variable obj
        Class<?> type = this.obj.getClass();
        // type.getCanonicalName() gets the name of the class-file we have to analyze
        s += type.getCanonicalName() + ":\n";
        // foreach-loop searches and gets all variables of the class-file we have to analyze
        for (Field field: type.getDeclaredFields()) {
            // this command makes all variables accessible, whatever accessible type it has (public, package-private or private)
    		field.setAccessible(true);
            // we analyze, if the found variable is annotated with @RenderMe or not
        	if (field.isAnnotationPresent(RenderMe.class)) {
                // stores the the annotation as an RenderMe-object
        		RenderMe re = field.getAnnotation(RenderMe.class);
                // gets the with-value of the found annotations
                String reWith = re.with();
                // we analyze wether the with-value of the found annotation is an empty string or not
        		if ("".equals(reWith)) {        // "" is the first operand, because otherwise Checkstyle marks that the string has to be the first operand
                    // if the with-value is an empty string we can build our string directly with the methods below
                    s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + field.get(obj) + "\n";
        		} else {
                    // otherwise, if the with-value is not empty, we have to use the class ArrayRenderer to build our string
                    // cl creates and stores an object of the class given via the with-value of the found variable (in our case: ArrayRenderer-class)
        			Class<?> cl = Class.forName(reWith);
                    // constr saves the constructor in ArrayRenderer-class as an contructor-object. int[].class searches for the constructor, with an int[]-array as parameter
                    Constructor constr = cl.getConstructor(int[].class);
                    // inst creates a new instance of the class ArrayRenderer, calls its constructor and handles over the value (int[]-array) of the found variable
        			Object inst = constr.newInstance(field.get(obj));
                    // now we can call the render-method of the class ArrayRenderer that creates us our needed string-representation of the int[]-array stored in our found variable
        			Method renMeth = cl.getMethod("render");
                    s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + renMeth.invoke(inst) + "\n";
        		}
        	}
        }
        return s;
    }

}
