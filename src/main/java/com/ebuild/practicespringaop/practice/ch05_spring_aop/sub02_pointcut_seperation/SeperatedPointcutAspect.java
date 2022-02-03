package com.ebuild.practicespringaop.practice.ch05_spring_aop.sub02_pointcut_seperation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class SeperatedPointcutAspect {

  @Pointcut("execution(* com.ebuild.practicespringaop.practice.ch05_spring_aop.business..*(..))")
  private void allBusiness(){}

  @Around("allBusiness()")
  public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("[Log] Do logging for method execution : [{}]", joinPoint.getSignature());
    return joinPoint.proceed();
  }

}
