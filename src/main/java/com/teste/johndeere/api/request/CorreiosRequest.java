package com.teste.johndeere.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CorreiosRequest {

  @JsonProperty("cdServico")
  private String cdServico;

  @JsonProperty("sCepOrigem")
  private String sCepOrigem;

  @JsonProperty("sCepDestino")
  private String sCepDestino;
}
