package com.sample.javaValidators;

import java.util.Optional;

public interface ValidationResult {

  static ValidationResult valid() {
    return ValidationSupport.valid();
  }

  static ValidationResult invalid(String reason) {
    return new Invalid(reason);
  }

  boolean isValid();

  Optional<String> getReason();
}

final class Invalid implements ValidationResult {

  private final String reason;

  Invalid(String reason){
      this.reason = reason;
  }

  public boolean isValid(){
      return false;
  }

  public Optional<String> getReason(){
      return Optional.of(reason);
  }

  // equals and hashCode on field reason
}
final class ValidationSupport {
  private static final ValidationResult valid = new ValidationResult(){
      public boolean isValid(){ return true; }
      public Optional<String> getReason(){ return Optional.empty(); }
  };

  static ValidationResult valid(){
      return valid;
  }
}
