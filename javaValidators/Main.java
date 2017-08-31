package com.sample.javaValidators;

public class Main {

  public static void main(String[] args) {
    User u1 = new User("Raveesh", 31, "raveesh@gmail.com");
    User u2 = new User("Raveesh", 31, "raveeshgmail.com");
    User u3 = new User("", 31, "raveeshgmail.com");
    User u4 = new User("", 31, "raveesh@gmail.com");
    User u5 = new User("", 31, "raveesh@gmail.com");


    ValidationResult u1Result =
        UserValidation.nameisNotEmpty().and(UserValidation.emailisValid()).apply(u1);

    ValidationResult u2Result =
        UserValidation.nameisNotEmpty().and(UserValidation.emailisValid()).apply(u2);

    ValidationResult u3Result =
        UserValidation.nameisNotEmpty().and(UserValidation.emailisValid()).apply(u3);

    ValidationResult u4Result =
        UserValidation.nameisNotEmpty().or(UserValidation.emailisValid()).apply(u4);

    ValidationResult u5Result =
        UserValidation.nameisNotEmpty().or(UserValidation.emailisValid()).apply(u5);

    System.out.println(u1Result.isValid() + " :: " + u2Result.isValid() + " :: " + u3Result.isValid() + " :: "
        + u4Result.isValid() + " :: " + u5Result.isValid());
  }
}
