package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalCallService {

  public void executionByExternal(){
    log.info("executionByExternal() !");
    executionByInternal();    // this 참조로 내부에서 호출된 메서드에 프록시가 적용되지 않는 문제
  }

  public void executionByInternal(){
    log.info("executionByInternal() !");
  }

}
