package com.ebuild.practicespringaop.practice.ch05_spring_aop.sub03_multi_advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Slf4j
public class TransactionFirstAspect {

  @Order(2)
  @Aspect
  public static class DoLog{
    @Around("com.ebuild.practicespringaop.practice.ch05_spring_aop.sub03_multi_advice.Pointcuts.allBusiness()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
      log.info("[Log] Do logging for method execution : [{}]", joinPoint.getSignature());
      return joinPoint.proceed();
    }
  }

  @Order(1)
  @Aspect
  public static class DoTransaction{
    @Around("com.ebuild.practicespringaop.practice.ch05_spring_aop.sub03_multi_advice.Pointcuts.businessAndTransaction()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
      try {
        log.info("[Transaction] 트랜잭션 시작");
        Object proceed = joinPoint.proceed();
        log.info("[Transaction] 트랜잭션 커밋");
        return proceed;
      } catch(Throwable e){
        log.info("[Transaction] 트랜잭션 롤백");
        throw e;
      } finally {
        log.info("[Transaction] 트랜잭션 종료");
      }
    }

  }



}
