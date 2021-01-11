package br.gov.caixa.simtx.simulador.services.permissao;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.caixa.simtx.simulador.services.vo.ContaSIBAR;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequisicaoValidaPermissao {

	@NotNull(message = "sessionId nao informada")
	@Size(min = 1, message= "sessionId nao informada")
	@JsonProperty("session_id")
	private String sessionId;

	@NotNull(message = "enderecoIp nao informado")
	@Size(min = 1, max = 15, message= "enderecoIp deve ser informado e ter no maximo 15 caracteres")
	@JsonProperty("endereco_ip")
	private String enderecoIp;

	@NotNull(message = "token nao informado")
	@Size(min = 1, message= "token nao informado")
	private String token;

	@NotNull(message = "servico nao informado")
	@Min(value = 1, message= "servico nao informado")
	@Max(value = 999l, message= "servico nao informado")
	private Integer servico;

	@NotNull(message = "conta nao informada")
	@Valid
	private ContaSIBAR conta;

	private BigDecimal valor;



	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getEnderecoIp() {
		return enderecoIp;
	}

	public void setEnderecoIp(String enderecoIp) {
		this.enderecoIp = enderecoIp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public ContaSIBAR getConta() {
		return conta;
	}

	public void setConta(ContaSIBAR conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
