package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalCallServiceV3 {

  private SeperatedInternalService seperatedInternalService;

  public InternalCallServiceV3(SeperatedInternalService seperatedInternalService) {
    this.seperatedInternalService = seperatedInternalService;
  }

  public void executionByExternal(){
    log.info("executionByExternal() !");
    seperatedInternalService.executionByInternal();
  }



}
