package br.gov.caixa.simtx.simulador.services.sitax.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEAgenciaDestTev",
    "wsvclEProdutoDestTev",
    "wsvclEContaDestTev",
    "wsvclEDvContaDestTev"
})
public class WsvclEDestinoTev {

	@XmlElement(name = "wsvcl_e_agencia_dest_tev")
    protected int wsvclEAgenciaDestTev;
    @XmlElement(name = "wsvcl_e_produto_dest_tev")
    protected int wsvclEProdutoDestTev;
    @XmlElement(name = "wsvcl_e_conta_dest_tev")
    protected long wsvclEContaDestTev;
    @XmlElement(name = "wsvcl_e_dv_conta_dest_tev")
    protected int wsvclEDvContaDestTev;
	public int getWsvclEAgenciaDestTev() {
		return wsvclEAgenciaDestTev;
	}
	public void setWsvclEAgenciaDestTev(int wsvclEAgenciaDestTev) {
		this.wsvclEAgenciaDestTev = wsvclEAgenciaDestTev;
	}
	public int getWsvclEProdutoDestTev() {
		return wsvclEProdutoDestTev;
	}
	public void setWsvclEProdutoDestTev(int wsvclEProdutoDestTev) {
		this.wsvclEProdutoDestTev = wsvclEProdutoDestTev;
	}
	public long getWsvclEContaDestTev() {
		return wsvclEContaDestTev;
	}
	public void setWsvclEContaDestTev(long wsvclEContaDestTev) {
		this.wsvclEContaDestTev = wsvclEContaDestTev;
	}
	public int getWsvclEDvContaDestTev() {
		return wsvclEDvContaDestTev;
	}
	public void setWsvclEDvContaDestTev(int wsvclEDvContaDestTev) {
		this.wsvclEDvContaDestTev = wsvclEDvContaDestTev;
	}
    
    
}
