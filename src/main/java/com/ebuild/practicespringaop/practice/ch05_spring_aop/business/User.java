package com.ebuild.practicespringaop.practice.ch05_spring_aop.business;

import lombok.Getter;

@Getter
public class User {

  private final String username;
  private final String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
