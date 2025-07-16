package com.hobby.log.aspects;

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

    @Before("@annotation(com.hobby.log.annotation.Log)")
    public void before(JoinPoint joinPoint) {

    }

    @AfterReturning("@annotation(com.hobby.log.annotation.Log)")
    public void after(JoinPoint joinPoint) {

    }

}
