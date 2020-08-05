package com.teste.johndeere.integrations.correios;

import static com.teste.johndeere.api.error.MessageCodes.ERROR_INTEGRATION_CORREIOS;

import com.teste.johndeere.api.request.CorreiosRequest;
import com.teste.johndeere.config.Dictionary;
import com.teste.johndeere.exceptions.IntegrationException;
import com.teste.johndeere.exceptions.UnprocessableException;
import com.teste.johndeere.integrations.correios.paylods.response.ResultadoXML;
import com.teste.johndeere.integrations.correios.paylods.response.ServicoXML;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class CorreiosIntegration {

  private static final String URL_CORREIOS_CALC_PRAZO_ENDPOINT = "integrations.correios.calc-prazo-data";

  private final String correiosCalcPrazoDataEndpoint;

  private RestTemplate restTemplate;
  private Dictionary dictionary;
  @Autowired
  public CorreiosIntegration(final RestTemplate restTemplate,
                             final Environment env,
                             final Dictionary dictionary) {

    this.restTemplate = restTemplate;
    this.correiosCalcPrazoDataEndpoint = env.getRequiredProperty(URL_CORREIOS_CALC_PRAZO_ENDPOINT);
    this.dictionary = dictionary;
  }

  public ResultadoXML findDateMax(CorreiosRequest correiosRequest) throws IntegrationException {

    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_XML_VALUE);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(correiosCalcPrazoDataEndpoint)
        .queryParam("nCdServico", correiosRequest.getCdServico())
        .queryParam("sCepOrigem", correiosRequest.getSCepOrigem())
        .queryParam("sCepDestino", correiosRequest.getSCepDestino());

    HttpEntity<?> entity = new HttpEntity<>(headers);

    try{

      ResponseEntity<ResultadoXML> exchange = restTemplate.exchange(
          builder.toUriString(),
          HttpMethod.GET,
          entity,
          ResultadoXML.class);

      ServicoXML responseCorreios = exchange.getBody().getServicos().getcServico().get(0);

      if(exchange.getStatusCode().equals(HttpStatus.OK) && !responseCorreios.getErro().equals(0)) {

        throw new UnprocessableException(this.dictionary.getMessage(ERROR_INTEGRATION_CORREIOS, responseCorreios.getErro(), responseCorreios.getMsgErro()));
      }

      return exchange.getBody();

    } catch (final RestClientResponseException e) {
      log.error("[Correios Integration] - Error making request to Correios: {}", correiosCalcPrazoDataEndpoint, e);
      log.error("[Correios Integration] - Status Message: {}", e.getStatusText());
      log.error("[Correios Integration] - Response Body: {}", e.getResponseBodyAsString());
      throw new IntegrationException(e);
    } catch (final Exception e) {
      log.error("[Correios Integration] Unknown error consuming Correios API", e);
      throw new IntegrationException(e);
    }
  }

}
