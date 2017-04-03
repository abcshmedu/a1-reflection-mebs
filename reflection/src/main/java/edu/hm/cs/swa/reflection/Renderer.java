package edu.hm.cs.swa.reflection;

import java.lang.annotation.Annotation;
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
    public String render(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        String s = "";
        Class<?> type = obj.getClass();
        for (Field field: type.getDeclaredFields()) {
    		field.setAccessible(true);
        	if (field.isAnnotationPresent(RenderMe.class)){
        		RenderMe re = field.getAnnotation(RenderMe.class);
        		String reWith = re.with();
        		if (reWith.equals("")) {
                    s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + field.get(obj) + "\\n";
        		} else {
        			Class<?> cl = Class.forName(reWith);
        			Object inst = cl.newInstance();
        			Method renMeth = cl.getMethod("render", int[].class);
                    s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + renMeth.invoke(inst, field.get(obj)) + "\\n";
        		}
        	}
        }
        return s;
    }

}
