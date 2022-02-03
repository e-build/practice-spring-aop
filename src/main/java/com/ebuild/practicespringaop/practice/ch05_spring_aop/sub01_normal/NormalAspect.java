package com.ebuild.practicespringaop.practice.ch05_spring_aop.sub01_normal;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class NormalAspect {

  @Around("execution(* com.ebuild.practicespringaop.practice.ch05_spring_aop.business..*(..))")
  public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("[Log] Do logging for method execution : [{}]", joinPoint.getSignature());
    return joinPoint.proceed();
  }

}
