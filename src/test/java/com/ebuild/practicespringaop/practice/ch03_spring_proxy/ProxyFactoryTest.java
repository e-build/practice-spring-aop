package com.ebuild.practicespringaop.practice.ch03_spring_proxy;

import com.ebuild.practicespringaop.practice.ch03_spring_proxy.proxy_factory.ProxyFactoryConfig;
import com.ebuild.practicespringaop.practice.ch03_spring_proxy.proxy_factory.TargetClass;
import com.ebuild.practicespringaop.practice.ch03_spring_proxy.proxy_factory.TargetInterface;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = {ProxyFactoryConfig.class})
public class ProxyFactoryTest {

  @Autowired
  private TargetInterface targetInterfaceProxy;

  @Autowired
  private TargetInterface targetInterfaceProxyWithAdvisor;

  @Autowired
  private TargetClass targetClassProxy;

  @Autowired
  private TargetClass targetClassProxyExceptMethod;

  @Test
  @DisplayName("인터페이스 기반 프록시 - JDK 동적 프록시")
  void interface_proxy(){
    String proxyMethodResult = targetInterfaceProxy.targetMethod();
    log.info("proxyMethodResult : {}", proxyMethodResult);
    Assertions.assertThat(AopUtils.isJdkDynamicProxy(targetInterfaceProxy)).isTrue();
  }

  @Test
  @DisplayName("클래스 기반 프록시 - CGLIB")
  void class_proxy(){
    String proxyMethodResult = targetClassProxy.targetMethod();
    Assertions.assertThat(AopUtils.isCglibProxy(targetClassProxy)).isTrue();
  }

  @Test
  @DisplayName("인터페이스 기반 프록시 - JDK 동적 프록시 - 어드바이저 사용")
  void interface_proxy_with_advisor(){
    String proxyMethodResult = targetInterfaceProxyWithAdvisor.targetMethod();
    log.info("proxyMethodResult : {}", proxyMethodResult);
    Assertions.assertThat(AopUtils.isJdkDynamicProxy(targetInterfaceProxy)).isTrue();
  }

  @Test
  @DisplayName("직접 구현한 포인트컷으로 필터링")
  void class_proxy_with_pointcut(){
    String proxyMethodResult = targetClassProxyExceptMethod.targetMethod();
    String exceptMethodResult = targetClassProxyExceptMethod.exceptMethod();
    log.info("proxyMethodResult : {}", proxyMethodResult);
    log.info("exceptMethodResult : {}", exceptMethodResult);
    Assertions.assertThat(AopUtils.isJdkDynamicProxy(targetInterfaceProxy)).isTrue();
  }

}
