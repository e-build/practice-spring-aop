package com.ebuild.practicespringaop.practice.ch03_spring_proxy.post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PostProcessorBeanConfig {

  @Bean
  public NormalBeanAA normalBeanAA(){
    return new NormalBeanAA();
  }

  @Bean
  public AToBPostProcessor aToBPostProcessor(){
    return new AToBPostProcessor();
  }

  static class AToBPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      if (beanName.equals("normalBeanAA"))
        return new NormalBeanB();

      return bean;
    }

  }

}
