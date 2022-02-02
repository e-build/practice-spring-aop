package com.ebuild.practicespringaop.practice.ch01_proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubjectCacheProxy implements Subject{

  private final Subject target;
  private String cacheValue;

  public SubjectCacheProxy(Subject target) {
    this.target = target;
  }

  @Override
  public String operation() {
    log.info("프록시 객체 실행");
    if (cacheValue == null)
      cacheValue = target.operation();
    return cacheValue;
  }
}
