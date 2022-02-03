package com.ebuild.practicespringaop.practice.ch04_aspectJ;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class TimeAspect {

  @Around("execution(* com.ebuild.practicespringaop.practice.ch04_aspectJ..*(..))")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

    log.info("target={}", joinPoint.getTarget());
    log.info("args={}", joinPoint.getArgs());
    log.info("signature={}", joinPoint.getSignature());
    try {
      StopWatch stopWatch = StopWatch.createStarted();
      Object result = joinPoint.proceed();
      stopWatch.stop();

      log.info("Business Logic Execution Time : {}", stopWatch.toString());
      return result;
    } catch (Throwable e) {
      log.error(e.getMessage());
      throw e;
    }
  }

}
