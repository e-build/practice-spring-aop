package com.ebuild.practicespringaop.practice.ch03_spring_proxy.proxy_factory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class SampleAdvice implements MethodInterceptor {

  @Nullable
  @Override
  public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
    log.info("sample advice 실행시작");
    Object targetMethodReturnValue = invocation.proceed();
    log.info("sample advice 실행종료");
    return targetMethodReturnValue;
  }
}
