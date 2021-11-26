package br.gov.caixa.simtx.simulador.services.siatr.valida.resp;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "wsvclSaida")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclSaida"
})
public class WsAtrwsvclResp {

	@XmlElement(name = "wsvcl_saida", required = true)
    protected WsvclSaida wsvclSaida;

	public WsvclSaida getWsvclSaida() {
		return wsvclSaida;
	}

	public void setWsvclSaida(WsvclSaida wsvclSaida) {
		this.wsvclSaida = wsvclSaida;
	}
	 
}
