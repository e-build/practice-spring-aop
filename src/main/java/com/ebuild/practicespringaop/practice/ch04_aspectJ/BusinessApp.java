package com.ebuild.practicespringaop.practice.ch04_aspectJ;

import com.ebuild.practicespringaop.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class BusinessApp {

  public void hello(){
    ThreadUtils.sleep(1000);
    log.info("business logic execution");
  }

}
