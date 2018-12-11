package com.spring.challenge.infra;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Sniff {

    @Pointcut("@target(com.spring.challenge.infra.Track)")
    public void track(){}

    @Around("track() && execution(* com.spring.challenge.business.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(String.format("Time Taken by %s is %d", joinPoint, timeTaken));
        return result;
    }
}
