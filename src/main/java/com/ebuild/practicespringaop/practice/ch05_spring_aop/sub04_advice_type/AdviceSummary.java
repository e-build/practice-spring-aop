package com.ebuild.practicespringaop.practice.ch05_spring_aop.sub04_advice_type;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AdviceSummary {

  @Pointcut("execution(* com.ebuild.practicespringaop.practice.ch05_spring_aop.business..*(..))")
  public void allBusiness(){}

  @Pointcut("execution(* *..*Service.*(..))")
  public void allService(){}

  @Pointcut("allBusiness() &&  allService()")
  public void businessAndTransaction(){}

  @Around("businessAndTransaction()")
  public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      //@Before
      log.info("[around][트랜잭션 시작] {}", joinPoint.getSignature());
      Object result = joinPoint.proceed();
      //@AfterReturning
      log.info("[around][트랜잭션 커밋] {}", joinPoint.getSignature());
      return result;
    } catch (Exception e) {
      //@AfterThrowing
      log.info("[around][트랜잭션 롤백] {}", joinPoint.getSignature());
      throw e;
    } finally {
      //@After
      log.info("[around][리소스 릴리즈] {}", joinPoint.getSignature());
    }
  }

  @Before("businessAndTransaction()")
  public void doBefore(JoinPoint joinPoint) {
    log.info("[before] {}", joinPoint.getSignature());
  }

  @AfterReturning(value = "businessAndTransaction()",
      returning = "result")
  public void doReturn(JoinPoint joinPoint, Object result) {
    log.info("[return] {} return={}", joinPoint.getSignature(), result);
  }

  @AfterThrowing(value = "businessAndTransaction()",
      throwing = "ex")
  public void doThrowing(JoinPoint joinPoint, Exception ex) {
    log.info("[ex] {} message={}", joinPoint.getSignature(),
        ex.getMessage());
  }

  @After(value = "businessAndTransaction()")
  public void doAfter(JoinPoint joinPoint) {
    log.info("[after] {}", joinPoint.getSignature());
  }

}
