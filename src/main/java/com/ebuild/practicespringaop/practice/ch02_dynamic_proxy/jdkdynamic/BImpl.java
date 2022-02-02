package com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface {
    @Override
    public String call() {
        log.info("B 호출");
        return "b";
    }
}
