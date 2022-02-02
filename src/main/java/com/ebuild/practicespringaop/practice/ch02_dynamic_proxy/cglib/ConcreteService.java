package com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.cglib;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {
    public void call() {
        log.info("ConcreteService 호출");
    }
}
