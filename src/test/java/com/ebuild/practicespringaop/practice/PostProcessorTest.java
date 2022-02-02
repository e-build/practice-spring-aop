package com.ebuild.practicespringaop.practice;

import com.ebuild.designpattern.post_processor.AutoProxyCreatorConfig;
import com.ebuild.designpattern.post_processor.NormalBeanA;
import com.ebuild.designpattern.post_processor.NormalBeanB;
import com.ebuild.designpattern.post_processor.NormalBeanConfig;
import com.ebuild.designpattern.post_processor.PostProcessorBeanConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
public class PostProcessorTest {

  @Test
  void normalBeanConfigTest(){
      // given
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(NormalBeanConfig.class);

      // when
    NormalBeanA normalBeanA = applicationContext.getBean("normalBeanA", NormalBeanA.class);
    normalBeanA.hello();

    // then
    Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()-> applicationContext.getBean("normalBeanB", NormalBeanB.class));

  }

  @Test
  void postProcessorBeanConfigTest(){
    // given
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PostProcessorBeanConfig.class);

    // when
    NormalBeanB normalBeanB = applicationContext.getBean("normalBeanA", NormalBeanB.class);
    normalBeanB.hello();
  }

  @Test
  void autoProxyCreatorConfigTest(){
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoProxyCreatorConfig.class, AnnotationAwareAspectJAutoProxyCreator.class);
    NormalBeanA normalBeanA = applicationContext.getBean("normalBeanA", NormalBeanA.class);
    NormalBeanB normalBeanB = new NormalBeanB();

    normalBeanA.hello();
    normalBeanA.exceptMethod();

    normalBeanB.hello();
  }

}
