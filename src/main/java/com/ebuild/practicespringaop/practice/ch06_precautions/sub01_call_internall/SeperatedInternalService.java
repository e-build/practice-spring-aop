package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SeperatedInternalService {

  public void executionByInternal(){
    log.info("executionByInternal() !");
  }

}
