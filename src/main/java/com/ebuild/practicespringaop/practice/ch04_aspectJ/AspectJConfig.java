package com.ebuild.practicespringaop.practice.ch04_aspectJ;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectJConfig {

  @Bean
  public BusinessApp businessApp(){
    return new BusinessApp();
  }

  @Bean
  public TimeAspect timeAspect(){
    return new TimeAspect();
  }

  @Bean
  public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator(){
    return new AnnotationAwareAspectJAutoProxyCreator();
  }
}
