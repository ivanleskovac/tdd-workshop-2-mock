package com.vdarko.workshop.tdd.mock.car.model.service;

public class CarServiceException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CarServiceException(String message) {
    super(message);
  }

  public CarServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}
