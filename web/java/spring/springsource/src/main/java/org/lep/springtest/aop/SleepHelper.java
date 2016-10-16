package org.lep.springtest.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lack on 16-10-16.
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("睡完觉起床");
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("睡觉前先脱衣服");
    }
}

