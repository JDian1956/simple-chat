package com.hobby.core.annotation;

import java.lang.annotation.*;

/**
 * @author Harris
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String title() default "";

    String businessType() default "";

    String operatorType() default "";

    boolean saveRequest() default false;
}
