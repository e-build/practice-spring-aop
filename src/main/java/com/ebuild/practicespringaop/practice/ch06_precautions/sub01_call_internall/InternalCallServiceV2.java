package com.ebuild.practicespringaop.practice.ch06_precautions.sub01_call_internall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalCallServiceV2 {

  private ObjectProvider<InternalCallServiceV2> objectProvider;

  public InternalCallServiceV2(ObjectProvider<InternalCallServiceV2> objectProvider) {
    this.objectProvider = objectProvider;
  }

  public void executionByExternal(){
    log.info("executionByExternal() !");
    InternalCallServiceV2 internalCallServiceV2 = objectProvider.getObject();
    internalCallServiceV2.executionByInternal(); // this 참조로 내부에서 호출된 메서드에 프록시가 적용되지 않는 문제
  }

  public void executionByInternal(){
    log.info("executionByInternal() !");
  }

}
