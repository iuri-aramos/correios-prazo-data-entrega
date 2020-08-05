package com.teste.johndeere.exceptions;

import com.google.common.collect.Lists;
import com.teste.johndeere.api.error.ErrorMessage;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class CorreiosException extends RuntimeException {

  private static final long serialVersionUID = 8317344993346430207L;

  private final transient List<ErrorMessage> errors = Lists.newArrayList();
  private final transient HttpHeaders httpHeaders = new HttpHeaders();

  public abstract HttpStatus getHttpStatus();

  public CorreiosException(@NonNull Throwable e) {
    super(e);
  }

  public CorreiosException(@NonNull ErrorMessage errorMessage) {
    this.addError(errorMessage);
  }

  public CorreiosException(@NonNull ErrorMessage message, @NonNull Throwable e) {
    super(e);
    this.addError(message);
  }

  public CorreiosException(){ super(); }

  public void addError(@NonNull ErrorMessage errorMessage) {
    this.errors.add(errorMessage);
  }

}
