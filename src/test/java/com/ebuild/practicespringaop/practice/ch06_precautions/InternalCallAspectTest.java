package com.ebuild.practicespringaop.practice.ch06_precautions;

import static org.assertj.core.api.Assertions.assertThat;

import com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall.InternalCallService;
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
    , InternalCallService.class
    , AnnotationAwareAspectJAutoProxyCreator.class
})
public class InternalCallAspectTest {

  @Autowired
  private InternalCallService internalCallService;

  @Test
  void check_proxy() {
    assertThat(AopUtils.isAopProxy(internalCallService)).isTrue();
  }

  @Test
  void internal_call_not_working_with_proxy() {
    //  executionByExternal() 메서드 내부에서 호출되는 executionByInternal()는 프록시 적용 X
    internalCallService.executionByExternal();
  }

  @Test
  void internal_call_working_with_proxy() {
    // 외부에서 직접 호출될 때는 포륵시 적용 O
    internalCallService.executionByInternal();
  }


}
