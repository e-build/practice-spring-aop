package com.ebuild.practicespringaop.practice.ch03_spring_proxy.post_processor;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.StopWatch;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

  @Nullable
  @Override
  public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
    StopWatch started = StopWatch.createStarted();
    Object returnValue = invocation.proceed();
    started.stop();
    log.info("PROCEED TIME : {}", started.getTime(TimeUnit.SECONDS));
    return returnValue;
  }

}
