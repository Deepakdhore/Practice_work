package com.gradleProjet.Learn_spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.gradleProjet.Learn_spring_aop.bussiness.*.*(..))")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        logger.info("Before Aspect: Method called - {}", joinPoint.getSignature());
    }

    //pointcut =execution(* com.gradleProjet.Learn_spring_aop.bussiness.*.*(..))
    @After("execution(* com.gradleProjet.Learn_spring_aop.bussiness.*.*(..))")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        logger.info("After Aspect: Method called - {}", joinPoint.getSignature());
    }
    @Around("execution(* com.gradleProjet.Learn_spring_aop.bussiness.*.*(..))")
    public Object aroundTimerAop(ProceedingJoinPoint proceedingJoinPoint)
    {
    //startTimer
    long startTime = System.currentTimeMillis();
    //Exceute the invoked method

    Object returnValue= null;
        try {
        returnValue = proceedingJoinPoint.proceed();
    } catch (Throwable e) {
        throw new RuntimeException(e);
    }
    //stoptimer
    long stopTime= System.currentTimeMillis();
    long duration=startTime-stopTime;
        logger.info("the time taken by the method is - {} - {}",proceedingJoinPoint,duration);
        return returnValue;

    }

    

}
