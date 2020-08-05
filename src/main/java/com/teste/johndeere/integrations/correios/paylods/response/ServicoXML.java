package com.teste.johndeere.integrations.correios.paylods.response;

import javax.xml.bind.annotation.XmlElement;

public class ServicoXML {

  private Integer codigo;

  private Integer prazoEntrega;

  private String entregaDomiciliar;

  private String entregaSabado;

  private Integer Erro;

  private String MsgErro;

  private String obsFim;

  private String dataMaxEntrega;

  public Integer getCodigo() {
    return codigo;
  }

  @XmlElement(name="Codigo")
  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public Integer getPrazoEntrega() {
    return prazoEntrega;
  }

  @XmlElement(name="PrazoEntrega")
  public void setPrazoEntrega(Integer prazoEntrega) {
    this.prazoEntrega = prazoEntrega;
  }

  public String getEntregaDomiciliar() {
    return entregaDomiciliar;
  }

  @XmlElement(name="EntregaDomiciliar")
  public void setEntregaDomiciliar(String entregaDomiciliar) {
    this.entregaDomiciliar = entregaDomiciliar;
  }

  public String getEntregaSabado() {
    return entregaSabado;
  }

  @XmlElement(name="EntregaSabado")
  public void setEntregaSabado(String entregaSabado) {
    this.entregaSabado = entregaSabado;
  }

  public Integer getErro() {
    return Erro;
  }

  @XmlElement(name="Erro")
  public void setErro(Integer erro) {
    Erro = erro;
  }

  public String getMsgErro() {
    return MsgErro;
  }

  @XmlElement(name="MsgErro")
  public void setMsgErro(String msgErro) {
    MsgErro = msgErro;
  }

  public String getObsFim() {
    return obsFim;
  }

  @XmlElement(name="obsFim")
  public void setObsFim(String obsFim) {
    this.obsFim = obsFim;
  }

  public String getDataMaxEntrega() {
    return dataMaxEntrega;
  }

  @XmlElement(name="DataMaxEntrega")
  public void setDataMaxEntrega(String dataMaxEntrega) {
    this.dataMaxEntrega = dataMaxEntrega;
  }
}
