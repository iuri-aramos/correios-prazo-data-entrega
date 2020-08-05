package com.teste.johndeere.config;

import com.teste.johndeere.api.error.ErrorMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Dictionary {

  private final MessageSource messageSource;

  public ErrorMessage getMessage(@NonNull final String key, @NonNull final Object... args) {
    final String message = messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    return new ErrorMessage(key, message);
  }

}
