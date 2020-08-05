package com.teste.johndeere.service;

import com.teste.johndeere.api.request.CorreiosRequest;
import com.teste.johndeere.api.response.CorreiosResponse;
import com.teste.johndeere.exceptions.IntegrationException;
import com.teste.johndeere.integrations.correios.CorreiosIntegration;
import com.teste.johndeere.integrations.correios.paylods.response.ResultadoXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorreiosService {

  @Autowired
  private CorreiosIntegration correiosIntegration;

  public CorreiosResponse findDateMax(CorreiosRequest correiosRequest) throws IntegrationException {

    ResultadoXML responseCorreios = correiosIntegration.findDateMax(correiosRequest);

    return CorreiosResponse.builder().maxDateDelivery(responseCorreios.getServicos().getcServico().get(0).getDataMaxEntrega()).build();

  }

}
