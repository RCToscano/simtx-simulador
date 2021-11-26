package br.gov.caixa.simtx.simulador.services.sitax.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "wsvclEntrada")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEntrada"
})
public class WsAtrwsvcl {

	@XmlElement(name = "wsvcl_entrada", required = true)
    protected WsvclEntrada wsvclEntrada;

	public WsvclEntrada getWsvclEntrada() {
		return wsvclEntrada;
	}

	public void setWsvclEntrada(WsvclEntrada wsvclEntrada) {
		this.wsvclEntrada = wsvclEntrada;
	}
}
