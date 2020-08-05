package com.teste.johndeere.api.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ErrorMessage implements Serializable {

  private static final long serialVersionUID = -6022392294310317325L;

  @JsonProperty("date")
  private LocalDateTime date;

  @JsonProperty("errorCode")
  private String code;

  @JsonProperty("errorMessage")
  private String message;

  public ErrorMessage(String code, String message) {
    this.date = LocalDateTime.now();
    this.code = code;
    this.message = message;
  }
}
