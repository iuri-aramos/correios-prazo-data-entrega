package com.teste.johndeere.integrations.correios.paylods.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "cResultado")
public class ResultadoXML {

  private ServicosXML servicos;

  public ServicosXML getServicos() {
    return servicos;
  }

  @XmlElement(name = "Servicos")
  public void setServicos(ServicosXML servicos) {
    this.servicos = servicos;
  }
}
