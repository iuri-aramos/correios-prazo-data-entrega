package com.teste.johndeere.api.error;

public class MessageCodes {

  // Internal Server Errors
  public static final String INTERNAL_SERVER_ERROR = "500.001";

  // Unprocessable Requests
  public static final String ERROR_INTEGRATION_CORREIOS = "422.001";

  // Avoid instantiation
  private MessageCodes() {
  }
}
