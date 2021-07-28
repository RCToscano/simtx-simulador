package br.gov.caixa.simtx.simulador.services.limite.efetivar;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.services.limite.validar.ContaDestino;
import br.gov.caixa.simtx.simulador.services.limite.validar.ServicoEnum;
import br.gov.caixa.simtx.simulador.services.spi.pagamento.TipoAutenticacaoEnum;

public class RequisicaoEfetivaLimite {

	@NotNull(message = "servico nao informado")
	@Valid
	private ServicoEnum servico;

	@NotNull(message = "valor nao informado")
	@Digits(integer = 12, fraction = 2, message = "valor invalido. espera-se <12 digitos>.<2 digitos>")
	private BigDecimal valor;

	@NotNull(message = "data_efetivacao nao informada")
	@Size(min = 10, max = 10, message = "data_efetivacao deve ser informada e ter o seguinte formato yyyy-MM-dd")
	@JsonProperty("data_efetivacao")
	@SerializedName("data_efetivacao")
	private String dataEfetivacao;

	@NotNull(message = "autenticacao nao informada")
	@Valid
	private TipoAutenticacaoEnum autenticacao;

	@Valid
	@JsonProperty("conta_destino")
	@SerializedName("conta_destino")
	private ContaDestino contaDestino;

	public ServicoEnum getServico() {
		return servico;
	}

	public void setServico(ServicoEnum servico) {
		this.servico = servico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(String dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public TipoAutenticacaoEnum getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(TipoAutenticacaoEnum autenticacao) {
		this.autenticacao = autenticacao;
	}

	public ContaDestino getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaDestino contaDestino) {
		this.contaDestino = contaDestino;
	}

}
