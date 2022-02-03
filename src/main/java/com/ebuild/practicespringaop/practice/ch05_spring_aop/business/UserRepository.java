package com.ebuild.practicespringaop.practice.ch05_spring_aop.business;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRepository {

  private final User persistUser = new User("ebuild", "1234qwer");

  public Optional<User> findByUsername(String username) {
    log.info("[UserRepository] 사용자 조회 ");
    return persistUser.getUsername().equals(username)
        ? Optional.of(persistUser)
        : Optional.empty();
  }

}
