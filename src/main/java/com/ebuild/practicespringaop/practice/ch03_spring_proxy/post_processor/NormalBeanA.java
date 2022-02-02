package com.ebuild.practicespringaop.practice.ch03_spring_proxy.post_processor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalBeanA {

  public void hello(){
    log.info("helloA");
  }

  public void exceptMethod() {
    log.info("exceptMethod");
  }

}
