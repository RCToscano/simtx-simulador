package br.gov.caixa.simtx.simulador.testes.pix.agendamento.vo;

import java.math.BigDecimal;

public class RespostaConsultaAgendamentoPixV1VO {

	private Long nsuTransacao;

	private String situacaoTransacao;
	
	private String canalOrigem;

	private Integer nsuCanal;

	private String dataHora;

	private String idFimAFim;

	private String dataEfetivacao;

	private String informacoesEntreUsuarios;

	private Object usuarioPagador;

	private Object usuarioRecebedor;

	private BigDecimal valor;

	private String participanteTarifado;

	private String metodoLiquidacao;

	private String transactionCurrency;

	private String formaIniciacaoPagamento;

	private String finalidadeTransacao;

	private BigDecimal valorCompra;

	private BigDecimal valorDinheiroEspecie;

	private String txId;

	private Object qrCode;

	private Object cpfAssinantes;



	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public String getSituacaoTransacao() {
		return situacaoTransacao;
	}

	public void setSituacaoTransacao(String situacaoTransacao) {
		this.situacaoTransacao = situacaoTransacao;
	}

	public String getCanalOrigem() {
		return canalOrigem;
	}

	public void setCanalOrigem(String canalOrigem) {
		this.canalOrigem = canalOrigem;
	}

	public Integer getNsuCanal() {
		return nsuCanal;
	}

	public void setNsuCanal(Integer nsuCanal) {
		this.nsuCanal = nsuCanal;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getIdFimAFim() {
		return idFimAFim;
	}

	public void setIdFimAFim(String idFimAFim) {
		this.idFimAFim = idFimAFim;
	}

	public String getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(String dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public String getInformacoesEntreUsuarios() {
		return informacoesEntreUsuarios;
	}

	public void setInformacoesEntreUsuarios(String informacoesEntreUsuarios) {
		this.informacoesEntreUsuarios = informacoesEntreUsuarios;
	}

	public Object getUsuarioPagador() {
		return usuarioPagador;
	}

	public void setUsuarioPagador(Object usuarioPagador) {
		this.usuarioPagador = usuarioPagador;
	}

	public Object getUsuarioRecebedor() {
		return usuarioRecebedor;
	}

	public void setUsuarioRecebedor(Object usuarioRecebedor) {
		this.usuarioRecebedor = usuarioRecebedor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getParticipanteTarifado() {
		return participanteTarifado;
	}

	public void setParticipanteTarifado(String participanteTarifado) {
		this.participanteTarifado = participanteTarifado;
	}

	public String getMetodoLiquidacao() {
		return metodoLiquidacao;
	}

	public void setMetodoLiquidacao(String metodoLiquidacao) {
		this.metodoLiquidacao = metodoLiquidacao;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getFormaIniciacaoPagamento() {
		return formaIniciacaoPagamento;
	}

	public void setFormaIniciacaoPagamento(String formaIniciacaoPagamento) {
		this.formaIniciacaoPagamento = formaIniciacaoPagamento;
	}

	public String getFinalidadeTransacao() {
		return finalidadeTransacao;
	}

	public void setFinalidadeTransacao(String finalidadeTransacao) {
		this.finalidadeTransacao = finalidadeTransacao;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public BigDecimal getValorDinheiroEspecie() {
		return valorDinheiroEspecie;
	}

	public void setValorDinheiroEspecie(BigDecimal valorDinheiroEspecie) {
		this.valorDinheiroEspecie = valorDinheiroEspecie;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public Object getQrCode() {
		return qrCode;
	}

	public void setQrCode(Object qrCode) {
		this.qrCode = qrCode;
	}

	public Object getCpfAssinantes() {
		return cpfAssinantes;
	}

	public void setCpfAssinantes(Object cpfAssinantes) {
		this.cpfAssinantes = cpfAssinantes;
	}

}
