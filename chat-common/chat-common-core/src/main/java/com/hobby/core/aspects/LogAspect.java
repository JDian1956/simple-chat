package com.hobby.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 */
@Aspect
@Component
public class LogAspect {

    @Before("@annotation(com.hobby.core.annotation.Log)")
    public void before(JoinPoint joinPoint) {

    }

    @AfterReturning("@annotation(com.hobby.core.annotation.Log)")
    public void after(JoinPoint joinPoint) {

    }

}
