package com.teste.johndeere.api;

import com.teste.johndeere.api.error.MessageCodes;
import com.teste.johndeere.config.Dictionary;
import com.teste.johndeere.exceptions.CorreiosException;
import com.teste.johndeere.exceptions.IntegrationException;
import com.teste.johndeere.exceptions.UnprocessableException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
class PaymentControllerAdvice extends ResponseEntityExceptionHandler {

  private Dictionary dictionary;

  @Autowired
  public PaymentControllerAdvice(final Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  @ExceptionHandler({IntegrationException.class, UnprocessableException.class})
  public ResponseEntity<Object> handleException(final CorreiosException e) {
    final HttpHeaders responseHeaders = new HttpHeaders();
    return ResponseEntity.status(e.getHttpStatus()).headers(responseHeaders).body(e.getErrors());
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<Object> handleUnknownError(final Exception e) {
    this.logUncaughException(e);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dictionary.getMessage(MessageCodes.INTERNAL_SERVER_ERROR));
  }

  private void logUncaughException(@NonNull final Exception ex) {
    log.error("[Uncaught Exception] - Error caught stacktrace", ex);
  }
}
