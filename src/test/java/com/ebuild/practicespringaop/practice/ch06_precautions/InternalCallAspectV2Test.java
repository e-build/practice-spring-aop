package com.ebuild.practicespringaop.practice.ch06_precautions;

import static org.assertj.core.api.Assertions.assertThat;

import com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall.InternalCallServiceV2;
import com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall.InternalCallAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = {
    InternalCallAspect.class
    , InternalCallServiceV2.class
    , AnnotationAwareAspectJAutoProxyCreator.class
})
public class InternalCallAspectV2Test {

  @Autowired
  private InternalCallServiceV2 internalCallService;

  @Test
  void check_proxy() {
    assertThat(AopUtils.isAopProxy(internalCallService)).isTrue();
  }

  @Test
  void internal_call_not_working_with_proxy() {
    internalCallService.executionByExternal();
  }

  @Test
  void internal_call_working_with_proxy() {
    internalCallService.executionByInternal();
  }


}
