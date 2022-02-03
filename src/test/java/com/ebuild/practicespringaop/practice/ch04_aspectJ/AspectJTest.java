package com.ebuild.practicespringaop.practice.ch04_aspectJ;

import com.ebuild.practicespringaop.practice.ch04_aspectJ.AspectJConfig;
import com.ebuild.practicespringaop.practice.ch04_aspectJ.BusinessApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = {AspectJConfig.class})
public class AspectJTest {

  @Autowired
  private BusinessApp businessApp;

  @Test
  void spring_aspectj(){
    businessApp.hello();
  }

}
