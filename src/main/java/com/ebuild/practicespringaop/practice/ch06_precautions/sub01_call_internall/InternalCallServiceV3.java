package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalCallServiceV3 {

  /**
   * 기존의 내부에서 호출되던 메서드를 외부 클래스로 분리하여 주입받아 사용.
   * 자기호출이 아닌 설계로 클래스 구조 자체를 변경
   */

  private SeperatedInternalService seperatedInternalService;

  public InternalCallServiceV3(SeperatedInternalService seperatedInternalService) {
    this.seperatedInternalService = seperatedInternalService;
  }

  public void executionByExternal(){
    log.info("executionByExternal() !");
    seperatedInternalService.executionByInternal();
  }



}
