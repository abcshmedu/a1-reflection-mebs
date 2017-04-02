package edu.hm.cs.swa.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This is an annotation-class named RenderMe
 * @author: Sebastian Baumann & Ehsan Moslehi
 */

@Retention(RetentionPolicy.SOURCE)  // sets retention of this annotation to source code like comments
public @interface RenderMe {

    String message() default "Annotation \"message\" is called successfully"; // this is a test-annotation. It will be removed in final version.

}
