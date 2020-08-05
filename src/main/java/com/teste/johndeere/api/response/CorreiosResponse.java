package com.teste.johndeere.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CorreiosResponse {

  @JsonProperty("maxDateDelivery")
  private String maxDateDelivery;
}
