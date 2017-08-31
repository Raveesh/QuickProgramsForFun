package com.sample.javaValidators;

public class User{
  public final String name;
  public final int age;
  public final String email;

  public User(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public boolean isValid() {
    return nameIsNotEmpty() && eMailContainsAtSign();
  }

  private boolean nameIsNotEmpty() {
    return !name.trim().isEmpty();
  }

  private boolean eMailContainsAtSign() {
    return email.contains("@");
  }
}
