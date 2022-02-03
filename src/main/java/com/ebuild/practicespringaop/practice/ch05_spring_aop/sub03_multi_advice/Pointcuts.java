package com.ebuild.practicespringaop.practice.ch05_spring_aop.sub03_multi_advice;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

  @Pointcut("execution(* com.ebuild.practicespringaop.practice.ch05_spring_aop.business..*(..))")
  public void allBusiness(){}

  @Pointcut("execution(* *..*Service.*(..))")
  public void allService(){}

  @Pointcut("allBusiness() &&  allService()")
  public void businessAndTransaction(){}

}
