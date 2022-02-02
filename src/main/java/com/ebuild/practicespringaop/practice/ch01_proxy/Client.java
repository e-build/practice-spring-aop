package com.ebuild.practicespringaop.practice.ch01_proxy;

public class Client {

  private Subject subject;

  public Client(Subject subject) {
    this.subject = subject;
  }

  public void execute() {
    subject.operation();
  }

}
