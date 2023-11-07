package com.example.jwt.core.exception;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class ResponseError implements Serializable {

  private LocalDate timeStamp;
  private Map<String, Object> errors;

  public ResponseError() {
  }

  public LocalDate getTimeStamp() {
    return timeStamp;
  }

  public ResponseError setTimeStamp(LocalDate timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

  public Map<String, Object> getErrors() {
    return errors;
  }

  public ResponseError setErrors(Map<String, Object> errors) {
    this.errors = errors;
    return this;
  }

  public ResponseError build() {
    return this;
  }
}
