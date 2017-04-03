package edu.hm.cs.swa.reflection;

import java.lang.reflect.Field;

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
     */
    public String render(Object obj) throws IllegalAccessException {
        String s = "";
        Class<?> type = obj.getClass();
        for (Field field: type.getDeclaredFields()) {
            field.setAccessible(true);
            s += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + field.get(obj) + "\\n";
        }
        return s;
    }

}
