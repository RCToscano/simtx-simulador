package br.gov.caixa.simtx.simulador.services.siatr.valida.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEIspbDestino",
    "wsvclEAgenciaDestTed",
    "wsvclEContaDestTed",
    "wsvclEDvContaDestTed",
    "wsvclETipoContaTed",
    "wsvclEContaPagamento",
    "wsvclETpPessoaTed",
    "wsvclECpfCnpjTed",
    "wsvclETipoTed"
})
public class WsvclEDestinoTed {

	@XmlElement(name = "wsvcl_e_ispb_destino")
    protected long wsvclEIspbDestino;
    @XmlElement(name = "wsvcl_e_agencia_dest_ted")
    protected int wsvclEAgenciaDestTed;
    @XmlElement(name = "wsvcl_e_conta_dest_ted")
    protected long wsvclEContaDestTed;
    @XmlElement(name = "wsvcl_e_dv_conta_dest_ted", required = true)
    protected String wsvclEDvContaDestTed;
    @XmlElement(name = "wsvcl_e_tipo_conta_ted", required = true)
    protected String wsvclETipoContaTed;
    @XmlElement(name = "wsvcl_e_conta_pagamento", required = true)
    protected String wsvclEContaPagamento;
    @XmlElement(name = "wsvcl_e_tp_pessoa_ted")
    protected int wsvclETpPessoaTed;
    @XmlElement(name = "wsvcl_e_cpf_cnpj_ted")
    protected long wsvclECpfCnpjTed;
    @XmlElement(name = "wsvcl_e_tipo_ted", required = true)
    protected String wsvclETipoTed;
	public long getWsvclEIspbDestino() {
		return wsvclEIspbDestino;
	}
	public void setWsvclEIspbDestino(long wsvclEIspbDestino) {
		this.wsvclEIspbDestino = wsvclEIspbDestino;
	}
	public int getWsvclEAgenciaDestTed() {
		return wsvclEAgenciaDestTed;
	}
	public void setWsvclEAgenciaDestTed(int wsvclEAgenciaDestTed) {
		this.wsvclEAgenciaDestTed = wsvclEAgenciaDestTed;
	}
	public long getWsvclEContaDestTed() {
		return wsvclEContaDestTed;
	}
	public void setWsvclEContaDestTed(long wsvclEContaDestTed) {
		this.wsvclEContaDestTed = wsvclEContaDestTed;
	}
	public String getWsvclEDvContaDestTed() {
		return wsvclEDvContaDestTed;
	}
	public void setWsvclEDvContaDestTed(String wsvclEDvContaDestTed) {
		this.wsvclEDvContaDestTed = wsvclEDvContaDestTed;
	}
	public String getWsvclETipoContaTed() {
		return wsvclETipoContaTed;
	}
	public void setWsvclETipoContaTed(String wsvclETipoContaTed) {
		this.wsvclETipoContaTed = wsvclETipoContaTed;
	}
	public String getWsvclEContaPagamento() {
		return wsvclEContaPagamento;
	}
	public void setWsvclEContaPagamento(String wsvclEContaPagamento) {
		this.wsvclEContaPagamento = wsvclEContaPagamento;
	}
	public int getWsvclETpPessoaTed() {
		return wsvclETpPessoaTed;
	}
	public void setWsvclETpPessoaTed(int wsvclETpPessoaTed) {
		this.wsvclETpPessoaTed = wsvclETpPessoaTed;
	}
	public long getWsvclECpfCnpjTed() {
		return wsvclECpfCnpjTed;
	}
	public void setWsvclECpfCnpjTed(long wsvclECpfCnpjTed) {
		this.wsvclECpfCnpjTed = wsvclECpfCnpjTed;
	}
	public String getWsvclETipoTed() {
		return wsvclETipoTed;
	}
	public void setWsvclETipoTed(String wsvclETipoTed) {
		this.wsvclETipoTed = wsvclETipoTed;
	}
    
    
}
