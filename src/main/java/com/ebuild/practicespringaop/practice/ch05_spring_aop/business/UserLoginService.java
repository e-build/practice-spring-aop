package com.ebuild.practicespringaop.practice.ch05_spring_aop.business;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j

@RequiredArgsConstructor
public class UserLoginService {

  private final UserRepository userRepository;

  public void login(String username, String password){
   log.info("[UserLoginService] 사용자 로그인 실행");

    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    if(!user.getPassword().equals(password))
      throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

    log.info("[UserLoginService] 사용자 로그인 성공");
  }

}
