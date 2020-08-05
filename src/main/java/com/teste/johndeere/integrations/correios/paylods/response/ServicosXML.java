package com.teste.johndeere.integrations.correios.paylods.response;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class ServicosXML {

  private List<ServicoXML> cServico;

  public List<ServicoXML> getcServico() {
    return cServico;
  }

  @XmlElement(name= "cServico")
  public void setcServico(List<ServicoXML> cServico) {
    this.cServico = cServico;
  }
}
