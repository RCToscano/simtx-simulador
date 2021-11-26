package br.gov.caixa.simtx.simulador.services.sitax.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ProgramInterface")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramInterface", propOrder = {
    "wsAtrwsvcl"
})
public class ProgramInterface {

	@XmlElement(name = "ws_atrwsvcl", required = true)
    protected WsAtrwsvcl wsAtrwsvcl;

	public WsAtrwsvcl getWsAtrwsvcl() {
		return wsAtrwsvcl;
	}

	public void setWsAtrwsvcl(WsAtrwsvcl wsAtrwsvcl) {
		this.wsAtrwsvcl = wsAtrwsvcl;
	}
}
