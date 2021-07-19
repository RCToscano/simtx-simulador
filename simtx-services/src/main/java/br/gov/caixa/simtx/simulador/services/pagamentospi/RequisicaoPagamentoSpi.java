package br.gov.caixa.simtx.simulador.services.pagamentospi;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.gov.caixa.simtx.simulador.services.validation.NotEqual;

public class RequisicaoPagamentoSpi {
	
	@NotNull(message = "clientIdCanal nao informado")
	@Size(min = 11, max = 11, message = "clientIdCanal nao informado corretamente. espera cli-ser-xxx")
	@NotEqual(secondValue = "cli-ser-mtx", message = "clientIdCanal nao pode ser do simtx")
	private String clientIdCanal;

	@NotNull(message = "idFimAFim nao informado")
	@Size(min = 10, message = "idFimAFim nao informado corretamente")
	private String idFimAFim;

	@NotNull(message = "valor nao informado")
	@Digits(integer = 12, fraction = 2, message = "valor invalido. espera-se <12 digitos>.<2 digitos>")
	private BigDecimal valor;

	@NotNull(message = "usuarioPagador nao informado")
	@Valid
	private UsuarioPagador usuarioPagador;

	@NotNull(message = "usuarioRecebedor nao informado")
	@Valid
	private UsuarioRecebedor usuarioRecebedor;

	@NotNull(message = "dataHoraRecebimentoPagador nao informada")
	@Size(min = 19, max = 19, message = "dataHoraRecebimentoPagador deve ser informada e ter o seguinte formato dd/MM/yyyy HH:mm:ss")
	private String dataHoraRecebimentoPagador;

	@Size(max = 140, message = "informacoesEntreUsuarios deve ter no maximo 140 caracteres")
	private String informacoesEntreUsuarios;

	@NotNull(message = "tipoAutenticacao nao informado")
	@Valid
	private TipoAutenticacaoEnum tipoAutenticacao;

	@NotNull(message = "nsu nao informado")
	@Min(value = 1, message = "nsu deve ser informado e ter no maximo 15 caracteres")
	@Max(value = 999999999999999l, message = "nsu deve ser informado e ter no maximo 15 caracteres")
	private Long nsu;

	@Valid
	private ParticipanteTarifadoEnum participanteTarifado;

	@NotNull(message = "prioridadePagamento nao informado")
	@Valid
	private PrioridadePagamentoEnum prioridadePagamento;

	@NotNull(message = "canal nao informado")
	@Size(min = 3, message = "canal nao informado corretamente")
	private String canal;

	@NotNull(message = "pagamentoSiaafDto nao informado")
	private Object pagamentoSiaafDto;

	@Valid
	private MetodoLiquidacaoEnum metodoLiquidacao;

	@Valid
	private TransactionCurrencyEnum transactionCurrency;

	@NotNull(message = "formaIniciacaoPagamento nao informado")
	@Valid
	private FormaIniciacaoPagamentoEnum formaIniciacaoPagamento;

	private String txId;



	public String getClientIdCanal() {
		return clientIdCanal;
	}

	public void setClientIdCanal(String clientIdCanal) {
		this.clientIdCanal = clientIdCanal;
	}

	public String getIdFimAFim() {
		return idFimAFim;
	}

	public void setIdFimAFim(String idFimAFim) {
		this.idFimAFim = idFimAFim;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public UsuarioPagador getUsuarioPagador() {
		return usuarioPagador;
	}

	public void setUsuarioPagador(UsuarioPagador usuarioPagador) {
		this.usuarioPagador = usuarioPagador;
	}

	public UsuarioRecebedor getUsuarioRecebedor() {
		return usuarioRecebedor;
	}

	public void setUsuarioRecebedor(UsuarioRecebedor usuarioRecebedor) {
		this.usuarioRecebedor = usuarioRecebedor;
	}

	public String getDataHoraRecebimentoPagador() {
		return dataHoraRecebimentoPagador;
	}

	public void setDataHoraRecebimentoPagador(String dataHoraRecebimentoPagador) {
		this.dataHoraRecebimentoPagador = dataHoraRecebimentoPagador;
	}

	public String getInformacoesEntreUsuarios() {
		return informacoesEntreUsuarios;
	}

	public void setInformacoesEntreUsuarios(String informacoesEntreUsuarios) {
		this.informacoesEntreUsuarios = informacoesEntreUsuarios;
	}

	public TipoAutenticacaoEnum getTipoAutenticacao() {
		return tipoAutenticacao;
	}

	public void setTipoAutenticacao(TipoAutenticacaoEnum tipoAutenticacao) {
		this.tipoAutenticacao = tipoAutenticacao;
	}

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public ParticipanteTarifadoEnum getParticipanteTarifado() {
		return participanteTarifado;
	}

	public void setParticipanteTarifado(ParticipanteTarifadoEnum participanteTarifado) {
		this.participanteTarifado = participanteTarifado;
	}

	public PrioridadePagamentoEnum getPrioridadePagamento() {
		return prioridadePagamento;
	}

	public void setPrioridadePagamento(PrioridadePagamentoEnum prioridadePagamento) {
		this.prioridadePagamento = prioridadePagamento;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public Object getPagamentoSiaafDto() {
		return pagamentoSiaafDto;
	}

	public void setPagamentoSiaafDto(Object pagamentoSiaafDto) {
		this.pagamentoSiaafDto = pagamentoSiaafDto;
	}

	public MetodoLiquidacaoEnum getMetodoLiquidacao() {
		return metodoLiquidacao;
	}

	public void setMetodoLiquidacao(MetodoLiquidacaoEnum metodoLiquidacao) {
		this.metodoLiquidacao = metodoLiquidacao;
	}

	public TransactionCurrencyEnum getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(TransactionCurrencyEnum transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public FormaIniciacaoPagamentoEnum getFormaIniciacaoPagamento() {
		return formaIniciacaoPagamento;
	}

	public void setFormaIniciacaoPagamento(FormaIniciacaoPagamentoEnum formaIniciacaoPagamento) {
		this.formaIniciacaoPagamento = formaIniciacaoPagamento;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

}
