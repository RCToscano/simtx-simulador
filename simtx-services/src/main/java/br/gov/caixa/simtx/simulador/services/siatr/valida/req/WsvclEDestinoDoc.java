package br.gov.caixa.simtx.simulador.services.siatr.valida.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEBancoDestino",
    "wsvclEAgenciaDestino",
    "wsvclEContaDestino",
    "wsvclEDvContaDestino",
    "wsvclETpPessoaDoc",
    "wsvclECpfCnpjDoc"
})
public class WsvclEDestinoDoc {

	@XmlElement(name = "wsvcl_e_banco_destino")
    protected int wsvclEBancoDestino;
    @XmlElement(name = "wsvcl_e_agencia_destino")
    protected int wsvclEAgenciaDestino;
    @XmlElement(name = "wsvcl_e_conta_destino")
    protected long wsvclEContaDestino;
    @XmlElement(name = "wsvcl_e_dv_conta_destino", required = true)
    protected String wsvclEDvContaDestino;
    @XmlElement(name = "wsvcl_e_tp_pessoa_doc")
    protected int wsvclETpPessoaDoc;
    @XmlElement(name = "wsvcl_e_cpf_cnpj_doc")
    protected long wsvclECpfCnpjDoc;
    
	public int getWsvclEBancoDestino() {
		return wsvclEBancoDestino;
	}
	public void setWsvclEBancoDestino(int wsvclEBancoDestino) {
		this.wsvclEBancoDestino = wsvclEBancoDestino;
	}
	public int getWsvclEAgenciaDestino() {
		return wsvclEAgenciaDestino;
	}
	public void setWsvclEAgenciaDestino(int wsvclEAgenciaDestino) {
		this.wsvclEAgenciaDestino = wsvclEAgenciaDestino;
	}
	public long getWsvclEContaDestino() {
		return wsvclEContaDestino;
	}
	public void setWsvclEContaDestino(long wsvclEContaDestino) {
		this.wsvclEContaDestino = wsvclEContaDestino;
	}
	public String getWsvclEDvContaDestino() {
		return wsvclEDvContaDestino;
	}
	public void setWsvclEDvContaDestino(String wsvclEDvContaDestino) {
		this.wsvclEDvContaDestino = wsvclEDvContaDestino;
	}
	public int getWsvclETpPessoaDoc() {
		return wsvclETpPessoaDoc;
	}
	public void setWsvclETpPessoaDoc(int wsvclETpPessoaDoc) {
		this.wsvclETpPessoaDoc = wsvclETpPessoaDoc;
	}
	public long getWsvclECpfCnpjDoc() {
		return wsvclECpfCnpjDoc;
	}
	public void setWsvclECpfCnpjDoc(long wsvclECpfCnpjDoc) {
		this.wsvclECpfCnpjDoc = wsvclECpfCnpjDoc;
	}
    
}
