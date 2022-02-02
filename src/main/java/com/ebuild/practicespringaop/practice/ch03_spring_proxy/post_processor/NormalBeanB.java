package com.ebuild.practicespringaop.practice.ch03_spring_proxy.post_processor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalBeanB {

  public void hello(){
    log.info("helloB");
  }

}
