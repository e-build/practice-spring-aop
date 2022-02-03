package com.ebuild.practicespringaop.practice.ch06_precautions;

import static org.assertj.core.api.Assertions.assertThat;

import com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall.InternalCallServiceV3;
import com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall.InternalCallAspect;
import com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall.SeperatedInternalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = {
    InternalCallAspect.class
    , InternalCallServiceV3.class
    , SeperatedInternalService.class // 메서드 분리된 클래스 빈등록
    , AnnotationAwareAspectJAutoProxyCreator.class
})
public class InternalCallAspectV3Test {

  @Autowired
  private InternalCallServiceV3 internalCallService;

  @Test
  void check_proxy() {
    assertThat(AopUtils.isAopProxy(internalCallService)).isTrue();
  }

  @Test
  void internal_call_not_working_with_proxy() {
    internalCallService.executionByExternal();
  }

//  @Test
//  void internal_call_working_with_proxy() {
//    internalCallService.executionByInternal();
//  }


}
