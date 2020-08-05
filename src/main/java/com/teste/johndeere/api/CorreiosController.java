package com.teste.johndeere.api;


import com.teste.johndeere.api.request.CorreiosRequest;
import com.teste.johndeere.api.response.CorreiosResponse;
import com.teste.johndeere.exceptions.IntegrationException;
import com.teste.johndeere.service.CorreiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/correios")
public class CorreiosController {

  @Autowired
  private CorreiosService correiosService;

  @PostMapping("/max-date-delivery")
  public ResponseEntity<CorreiosResponse> findMaxData(@RequestBody CorreiosRequest correiosRequest) throws IntegrationException {

    CorreiosResponse dateMax = correiosService.findDateMax(correiosRequest);

    return ResponseEntity.ok(dateMax);
  }
}
