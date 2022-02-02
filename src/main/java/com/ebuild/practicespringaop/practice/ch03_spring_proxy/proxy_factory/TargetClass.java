package com.ebuild.practicespringaop.practice.ch03_spring_proxy.proxy_factory;

public class TargetClass {

  public String targetMethod(){
    return "target [class] return value";
  }

  public String exceptMethod(){
    return "excluding that method";
  }

}
