package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class InternalCallAspect {

  @Before("execution(* com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall..*(..))")
  public void doLog(JoinPoint joinPoint){
    log.info("[LogAspect] target={}", joinPoint.getSignature());
  }

}
