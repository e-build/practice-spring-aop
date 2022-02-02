package com.ebuild.practicespringaop.practice.ch01_proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteSubject implements Subject{

  @Override
  public String operation() {
    log.info("실제 객체 실행");
    sleep(1000);
    return "ok";
  }

  private void sleep(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
