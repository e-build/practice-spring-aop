package com.ebuild.practicespringaop.practice.ch02_dynamic_proxy;

import com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic.AImpl;
import com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic.AInterface;
import com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic.BImpl;
import com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic.BInterface;
import com.ebuild.practicespringaop.practice.ch02_dynamic_proxy.jdkdynamic.TimeInvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdkDynamicProxyTest {

  @Test
  void dynamicA() {
    AInterface target = new AImpl();
    TimeInvocationHandler handler = new TimeInvocationHandler(target);

    AInterface proxy =
        (AInterface) Proxy.newProxyInstance(
            AInterface.class.getClassLoader()
            , new Class[]{AInterface.class}
            , handler
        );

    proxy.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxyClass={}", proxy.getClass());
  }

  @Test
  void dynamicB() {
    BInterface target = new BImpl();
    TimeInvocationHandler handler = new TimeInvocationHandler(target);

    BInterface proxy =
        (BInterface) Proxy.newProxyInstance(
            BInterface.class.getClassLoader()
            , new Class[]{BInterface.class}
            , handler
        );

    proxy.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxyClass={}", proxy.getClass());
  }
}
