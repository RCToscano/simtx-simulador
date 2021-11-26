package br.gov.caixa.simtx.simulador.services.siatr.valida.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEDestinoPix",
    "wsvclEDestinoDoc",
    "wsvclEDestinoTed",
    "wsvclEDestinoTev",
    "wsvclEDestinoCsn"
})
public class WsvclEDadosDestino {

	@XmlElement(name = "wsvcl_e_destino_pix", required = true)
    protected WsvclEDestinoPix wsvclEDestinoPix;
    @XmlElement(name = "wsvcl_e_destino_doc", required = true)
    protected WsvclEDestinoDoc wsvclEDestinoDoc;
    @XmlElement(name = "wsvcl_e_destino_ted", required = true)
    protected WsvclEDestinoTed wsvclEDestinoTed;
    @XmlElement(name = "wsvcl_e_destino_tev", required = true)
    protected WsvclEDestinoTev wsvclEDestinoTev;
    @XmlElement(name = "wsvcl_e_destino_csn", required = true)
    protected WsvclEDestinoCsn wsvclEDestinoCsn;
	
    public WsvclEDestinoPix getWsvclEDestinoPix() {
		return wsvclEDestinoPix;
	}
	public void setWsvclEDestinoPix(
			WsvclEDestinoPix wsvclEDestinoPix) {
		this.wsvclEDestinoPix = wsvclEDestinoPix;
	}
	public WsvclEDestinoDoc getWsvclEDestinoDoc() {
		return wsvclEDestinoDoc;
	}
	public void setWsvclEDestinoDoc(
			WsvclEDestinoDoc wsvclEDestinoDoc) {
		this.wsvclEDestinoDoc = wsvclEDestinoDoc;
	}
	public WsvclEDestinoTed getWsvclEDestinoTed() {
		return wsvclEDestinoTed;
	}
	public void setWsvclEDestinoTed(
			WsvclEDestinoTed wsvclEDestinoTed) {
		this.wsvclEDestinoTed = wsvclEDestinoTed;
	}
	public WsvclEDestinoTev getWsvclEDestinoTev() {
		return wsvclEDestinoTev;
	}
	public void setWsvclEDestinoTev(
			WsvclEDestinoTev wsvclEDestinoTev) {
		this.wsvclEDestinoTev = wsvclEDestinoTev;
	}
	public WsvclEDestinoCsn getWsvclEDestinoCsn() {
		return wsvclEDestinoCsn;
	}
	public void setWsvclEDestinoCsn(
			WsvclEDestinoCsn wsvclEDestinoCsn) {
		this.wsvclEDestinoCsn = wsvclEDestinoCsn;
	}
    
    
}
