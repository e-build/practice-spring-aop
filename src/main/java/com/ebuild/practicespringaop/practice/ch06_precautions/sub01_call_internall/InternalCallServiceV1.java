package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class InternalCallServiceV1 {

  /**
   * 수정자 주입으로 자기자신을 주입받아서 internal 메서드 호출 TODO: 작동 안함. 순환참조 발생
   */

  private InternalCallServiceV1 internalCallServiceV1;

//  @Autowired
  public void setInternalCallServiceV1(InternalCallServiceV1 internalCallServiceV1){
    this.internalCallServiceV1 = internalCallServiceV1;
  }

  public void executionByExternal(){
    log.info("executionByExternal() !");
    internalCallServiceV1.executionByInternal();    // this 참조로 내부에서 호출된 메서드에 프록시가 적용되지 않는 문제
  }

  public void executionByInternal(){
    log.info("executionByInternal() !");
  }

}
