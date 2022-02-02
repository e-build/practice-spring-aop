package com.ebuild.practicespringaop.practice.ch03_spring_proxy.proxy_factory;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfig {

  @Bean
  public TargetInterface targetInterfaceProxy(){
    TargetInterface target = new TargetInterfaceImpl();
    ProxyFactory proxyFactory = new ProxyFactory(target);
    proxyFactory.addAdvice(new SampleAdvice());
//    proxyFactory.setProxyTargetClass(true);
    return (TargetInterface)proxyFactory.getProxy();
  }

  @Bean
  public TargetInterface targetInterfaceProxyWithAdvisor(){
    TargetInterface target = new TargetInterfaceImpl();
    ProxyFactory proxyFactory = new ProxyFactory(target);
    proxyFactory.addAdvisor(new DefaultPointcutAdvisor(Pointcut.TRUE, new SampleAdvice()));
    return (TargetInterface)proxyFactory.getProxy();
  }

  @Bean
  public TargetClass targetClassProxy(){
    TargetClass target = new TargetClass();
    ProxyFactory proxyFactory = new ProxyFactory(target);
    proxyFactory.addAdvice(new SampleAdvice());
    return (TargetClass)proxyFactory.getProxy();
  }

  @Bean
  public TargetClass targetClassProxyExceptMethod(){
    TargetClass target = new TargetClass();
    ProxyFactory proxyFactory = new ProxyFactory(target);
    proxyFactory.addAdvisor(
        new DefaultPointcutAdvisor(
            new SamplePointcut(), new SampleAdvice()
        )
    );
    return (TargetClass)proxyFactory.getProxy();
  }

  static class SamplePointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
      return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
      return new SampleMethodMather();
    }
  }

  static class SampleMethodMather implements MethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
      return method.getName().equals("targetMethod");
    }

    @Override
    public boolean isRuntime() {
      return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
      throw new UnsupportedOperationException();
    }
  }

  @Bean
  public TargetClass exceptMethodWithSpringPointcut(){
    TargetClass target = new TargetClass();
    ProxyFactory proxyFactory = new ProxyFactory(target);
    NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
    pointcut.setMappedName("targetMethod");
    proxyFactory.addAdvisor(
        new DefaultPointcutAdvisor(
            pointcut, new SampleAdvice()
        )
    );
    return (TargetClass)proxyFactory.getProxy();
  }





}
