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
        String s = "Instance of ";
        Class<?> type = this.obj.getClass();
        s += type.getCanonicalName() + ":\n";
        for (Field field: type.getDeclaredFields()) {
    		field.setAccessible(true);
        	if (field.isAnnotationPresent(RenderMe.class)) {
        		RenderMe re = field.getAnnotation(RenderMe.class);
        		String reWith = re.with();
        		if ("".equals(reWith)) {        // "" steht vorne, da sonst Checkstyle meckert, dass ein String links von equals stehen soll
                    s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + field.get(obj) + "\n";
        		} else {
        			Class<?> cl = Class.forName(reWith);
                    Constructor constr = cl.getConstructor(int[].class);
        			Object inst = constr.newInstance(field.get(obj));
        			Method renMeth = cl.getMethod("render");
                    s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + renMeth.invoke(inst) + "\n";
        		}
        	}
        }
        return s;
    }

}
