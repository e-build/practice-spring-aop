package com.ebuild.practicespringaop.practice.ch05_spring_aop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ebuild.practicespringaop.practice.ch05_spring_aop.business.UserLoginService;
import com.ebuild.practicespringaop.practice.ch05_spring_aop.business.UserRepository;
import com.ebuild.practicespringaop.practice.ch05_spring_aop.sub03_multi_advice.TransactionSecondAspect;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
    TransactionSecondAspect.DoTransaction.class
    , TransactionSecondAspect.DoLog.class
    , UserLoginService.class
    , UserRepository.class
    , AnnotationAwareAspectJAutoProxyCreator.class
})
public class TransactionSecondAspectTest {

  @Autowired
  private UserLoginService userLoginService;
  @Autowired
  private UserRepository userRepository;

  @Test
  void check_proxy() {
    assertThat(AopUtils.isAopProxy(userLoginService)).isTrue();
    assertThat(AopUtils.isAopProxy(userRepository)).isTrue();
  }

  @Test
  void login_success() {
    userLoginService.login("ebuild", "1234qwer");
  }

  @Test
  void login_fail() {
    assertThatThrownBy(() -> userLoginService.login("ebuild", "xxx"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
