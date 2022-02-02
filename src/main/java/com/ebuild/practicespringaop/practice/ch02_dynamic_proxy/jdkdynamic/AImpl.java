package com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {
    @Override
    public String call() {
        log.info("A 호출");
        return "a";
    }
}
