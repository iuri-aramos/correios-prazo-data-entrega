package com.teste.johndeere.exceptions;

public class IntegrationException extends Exception {

  private static final long serialVersionUID = -6385574931527506755L;

  public IntegrationException() {
    super();
  }

  public IntegrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public IntegrationException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntegrationException(String message) {
    super(message);
  }

  public IntegrationException(Throwable cause) {
    super(cause);
  }
}
