package com.sample.javaValidators;

import static com.sample.javaValidators.ValidationResult.invalid;
import static com.sample.javaValidators.ValidationResult.valid;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface UserValidation extends Function<User, ValidationResult> {

  static UserValidation nameisNotEmpty(){
    return holds(user -> !user.name.trim().isEmpty(), "Name is empty.");
  }
  
  static UserValidation holds(Predicate<User> p, String message){
    return user -> p.test(user) ? valid() : invalid(message);
}
  
  static UserValidation emailisValid(){
    return holds(user -> user.email.contains("@"), "Missing @-sign.");
  }
  
  default UserValidation and(UserValidation other){
    return user -> {
      final ValidationResult result = this.apply(user);
      return result.isValid() ? other.apply(user) : result;
  };
  }
  
  default UserValidation or(UserValidation other){
    return user -> {
      final ValidationResult result = this.apply(user);
      return result.isValid() ? other.apply(user) : result;
  };
  }
  
  static UserValidation all(UserValidation... validations){
    return user -> {
        String reasons = Arrays.stream(validations)
              .map(v -> v.apply(user))
              .filter(r -> !r.isValid())
              .map(r -> r.getReason().get())
              .collect(Collectors.joining("\n"));
        return reasons.isEmpty()?valid():invalid(reasons);
    };
}
}
