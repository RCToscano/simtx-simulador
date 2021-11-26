package br.gov.caixa.simtx.simulador.services.siatr.valida.req;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "WsvclEntrada")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEVersao",
    "wsvclETipoSolicitacao",
    "wsvclESiglaServ",
    "wsvclESgCanalOrigem",
    "wsvclENuNsuMtx",
    "wsvclEAgencia",
    "wsvclEProduto",
    "wsvclEConta",
    "wsvclEDvConta",
    "wsvclEVrTransacao",
    "wsvclEVrTarifa",
    "wsvclEDtTransacao",
    "wsvclEDtMovimento",
    "wsvclETpAutenticacao",
    "wsvclETitularTrans",
    "wsvclECpfCnpjTitTran",
    "wsvclEIcAgendamento",
    "wsvclEDadosDestino"
})
public class WsvclEntrada {

	@XmlElement(name = "wsvcl_e_versao")
    protected int wsvclEVersao;
    @XmlElement(name = "wsvcl_e_tipo_solicitacao")
    protected int wsvclETipoSolicitacao;
    @XmlElement(name = "wsvcl_e_sigla_serv", required = true)
    protected String wsvclESiglaServ;
    @XmlElement(name = "wsvcl_e_sg_canal_origem", required = true)
    protected String wsvclESgCanalOrigem;
    @XmlElement(name = "wsvcl_e_nu_nsu_mtx")
    protected long wsvclENuNsuMtx;
    @XmlElement(name = "wsvcl_e_agencia")
    protected int wsvclEAgencia;
    @XmlElement(name = "wsvcl_e_produto")
    protected int wsvclEProduto;
    @XmlElement(name = "wsvcl_e_conta")
    protected long wsvclEConta;
    @XmlElement(name = "wsvcl_e_dv_conta")
    protected int wsvclEDvConta;
    @XmlElement(name = "wsvcl_e_vr_transacao", required = true)
    protected BigDecimal wsvclEVrTransacao;
    @XmlElement(name = "wsvcl_e_vr_tarifa", required = true)
    protected BigDecimal wsvclEVrTarifa;
    @XmlElement(name = "wsvcl_e_dt_transacao")
    protected long wsvclEDtTransacao;
    @XmlElement(name = "wsvcl_e_dt_movimento")
    protected long wsvclEDtMovimento;
    @XmlElement(name = "wsvcl_e_tp_autenticacao")
    protected int wsvclETpAutenticacao;
    @XmlElement(name = "wsvcl_e_titular_trans")
    protected int wsvclETitularTrans;
    @XmlElement(name = "wsvcl_e_cpf_cnpj_tit_tran")
    protected Long wsvclECpfCnpjTitTran;
    @XmlElement(name = "wsvcl_e_ic_agendamento")
    protected int wsvclEIcAgendamento;
    @XmlElement(name = "wsvcl_e_dados_destino", required = true)
    protected WsvclEDadosDestino wsvclEDadosDestino;
	public int getWsvclEVersao() {
		return wsvclEVersao;
	}
	public void setWsvclEVersao(int wsvclEVersao) {
		this.wsvclEVersao = wsvclEVersao;
	}
	public int getWsvclETipoSolicitacao() {
		return wsvclETipoSolicitacao;
	}
	public void setWsvclETipoSolicitacao(int wsvclETipoSolicitacao) {
		this.wsvclETipoSolicitacao = wsvclETipoSolicitacao;
	}
	public String getWsvclESiglaServ() {
		return wsvclESiglaServ;
	}
	public void setWsvclESiglaServ(String wsvclESiglaServ) {
		this.wsvclESiglaServ = wsvclESiglaServ;
	}
	public String getWsvclESgCanalOrigem() {
		return wsvclESgCanalOrigem;
	}
	public void setWsvclESgCanalOrigem(String wsvclESgCanalOrigem) {
		this.wsvclESgCanalOrigem = wsvclESgCanalOrigem;
	}
	public long getWsvclENuNsuMtx() {
		return wsvclENuNsuMtx;
	}
	public void setWsvclENuNsuMtx(long wsvclENuNsuMtx) {
		this.wsvclENuNsuMtx = wsvclENuNsuMtx;
	}
	public int getWsvclEAgencia() {
		return wsvclEAgencia;
	}
	public void setWsvclEAgencia(int wsvclEAgencia) {
		this.wsvclEAgencia = wsvclEAgencia;
	}
	public int getWsvclEProduto() {
		return wsvclEProduto;
	}
	public void setWsvclEProduto(int wsvclEProduto) {
		this.wsvclEProduto = wsvclEProduto;
	}
	public long getWsvclEConta() {
		return wsvclEConta;
	}
	public void setWsvclEConta(long wsvclEConta) {
		this.wsvclEConta = wsvclEConta;
	}
	public int getWsvclEDvConta() {
		return wsvclEDvConta;
	}
	public void setWsvclEDvConta(int wsvclEDvConta) {
		this.wsvclEDvConta = wsvclEDvConta;
	}
	public BigDecimal getWsvclEVrTransacao() {
		return wsvclEVrTransacao;
	}
	public void setWsvclEVrTransacao(BigDecimal wsvclEVrTransacao) {
		this.wsvclEVrTransacao = wsvclEVrTransacao;
	}
	public BigDecimal getWsvclEVrTarifa() {
		return wsvclEVrTarifa;
	}
	public void setWsvclEVrTarifa(BigDecimal wsvclEVrTarifa) {
		this.wsvclEVrTarifa = wsvclEVrTarifa;
	}
	public long getWsvclEDtTransacao() {
		return wsvclEDtTransacao;
	}
	public void setWsvclEDtTransacao(long wsvclEDtTransacao) {
		this.wsvclEDtTransacao = wsvclEDtTransacao;
	}
	public long getWsvclEDtMovimento() {
		return wsvclEDtMovimento;
	}
	public void setWsvclEDtMovimento(long wsvclEDtMovimento) {
		this.wsvclEDtMovimento = wsvclEDtMovimento;
	}
	public int getWsvclETpAutenticacao() {
		return wsvclETpAutenticacao;
	}
	public void setWsvclETpAutenticacao(int wsvclETpAutenticacao) {
		this.wsvclETpAutenticacao = wsvclETpAutenticacao;
	}
	public int getWsvclETitularTrans() {
		return wsvclETitularTrans;
	}
	public void setWsvclETitularTrans(int wsvclETitularTrans) {
		this.wsvclETitularTrans = wsvclETitularTrans;
	}
	public Long getWsvclECpfCnpjTitTran() {
		return wsvclECpfCnpjTitTran;
	}
	public void setWsvclECpfCnpjTitTran(Long wsvclECpfCnpjTitTran) {
		this.wsvclECpfCnpjTitTran = wsvclECpfCnpjTitTran;
	}
	public int getWsvclEIcAgendamento() {
		return wsvclEIcAgendamento;
	}
	public void setWsvclEIcAgendamento(int wsvclEIcAgendamento) {
		this.wsvclEIcAgendamento = wsvclEIcAgendamento;
	}
	public WsvclEDadosDestino getWsvclEDadosDestino() {
		return wsvclEDadosDestino;
	}
	public void setWsvclEDadosDestino(WsvclEDadosDestino wsvclEDadosDestino) {
		this.wsvclEDadosDestino = wsvclEDadosDestino;
	}
}
