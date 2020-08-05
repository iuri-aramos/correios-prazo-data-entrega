package com.teste.johndeere.exceptions;

import com.teste.johndeere.api.error.ErrorMessage;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
public class UnprocessableException extends CorreiosException {

  private static final long serialVersionUID = 9120207967176554221L;

  private HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

  @Override
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(final HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public UnprocessableException(Throwable e) {
    super(e);
  }
  
  public UnprocessableException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  public UnprocessableException(ErrorMessage errorMessage, HttpStatus httpStatus) {
    super(errorMessage);
    this.httpStatus = httpStatus;
  }

  public UnprocessableException(ErrorMessage message, Throwable e) {
    super(message, e);
  }
}
