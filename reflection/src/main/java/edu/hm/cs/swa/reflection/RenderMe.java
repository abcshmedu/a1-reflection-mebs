package edu.hm.cs.swa.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This is an annotation-class named RenderMe.
 * @author Sebastian Baumann & Ehsan Moslehi
 */

@Retention(RetentionPolicy.RUNTIME)  // sets retention of this annotation to source code like comments
public @interface RenderMe {

    /**
     * First test-method.
     * @return message as String
     */
    String with() default "";
}
