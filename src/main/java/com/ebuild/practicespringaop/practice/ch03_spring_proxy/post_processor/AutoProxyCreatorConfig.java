package com.ebuild.practicespringaop.practice.ch03_spring_proxy.post_processor;

import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = {NormalBeanConfig.class})
@Configuration
public class AutoProxyCreatorConfig {

  @Bean
  public Advisor normalBeanA$Proxy(){
    NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
    pointcut.setMappedNames("hello*");
    return new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
  }

}
