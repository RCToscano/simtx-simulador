package br.gov.caixa.simtx.simulador.services.assinatura.simples.v2;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.services.assinatura.multipla.Dispositivo;
import br.gov.caixa.simtx.simulador.services.assinatura.simples.Transacao;
import br.gov.caixa.simtx.simulador.util.vo.ContaAgencia;

public class RequisicaoAssinaturaSimplesV2 {

	@Size(min = 1, max = 11, message= "cpf deve ser informado e ter 11 caracteres")
	private String cpf;

	@NotNull(message = "conta nao informada")
	@Valid
	private ContaAgencia conta;

	@NotNull(message = "assinatura nao informada")
	@Size(min = 1, max = 16, message= "assinatura deve ser informada e ter no maximo 16 caracteres")
	private String assinatura;

	@NotNull(message = "data_prevista_efetivacao nao informada")
	@Size(min = 10, max = 10, message= "data_prevista_efetivacao deve ser informada e ter o seguinte formato aaaa-mm-dd")
	@JsonProperty("data_prevista_efetivacao")
	@SerializedName("data_prevista_efetivacao")
	private String dataPrevistaEfetivacao;

	@NotNull(message = "servico nao informado")
	@Min(value = 1, message= "servico nao informado")
	@Max(value = 999l, message= "servico deve ser informado e ter no maximo 3 caracteres")
	private Integer servico;

	@Size(max = 20, message= "apelido deve ter no maximo 20 caracteres")
	private String apelido;

	@NotNull(message = "endereco_ip nao informado")
	@Size(min = 1, max = 15, message= "endereco_ip deve ser informado e ter no maximo 15 caracteres")
	@JsonProperty("endereco_ip")
	@SerializedName("endereco_ip")
	private String enderecoIp;

	@Max(value = 999999999l, message= "nsu_siper deve ter no maximo 9 caracteres")
	@JsonProperty("nsu_siper")
	@SerializedName("nsu_siper")
	private Long nsuSiper;
	
	@NotNull(message = "nsu nao informado")
	@Min(value = 1, message = "nsu nao informado corretamente")
	@Max(value = 999999999999999l, message= "nsu deve ter no maximo 15 caracteres")
	private Long nsu;

	@Valid
	private Transacao transacao;

	@NotNull(message = "token nao informado")
	@Size(min = 1, max = 80, message= "token deve ser informado e ter no maximo 80 caracteres")
	private String token;

	@NotNull(message = "session_id nao informado")
	@Size(min = 1, max = 32, message= "session_id deve ser informado e ter no maximo 32 caracteres")
	@JsonProperty("session_id")
	@SerializedName("session_id")
	private String sessionId;

	@NotNull(message = "dispositivo nao informado")
	@Valid
	private Dispositivo dispositivo;



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ContaAgencia getConta() {
		return conta;
	}

	public void setConta(ContaAgencia conta) {
		this.conta = conta;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public String getDataPrevistaEfetivacao() {
		return dataPrevistaEfetivacao;
	}

	public void setDataPrevistaEfetivacao(String dataPrevistaEfetivacao) {
		this.dataPrevistaEfetivacao = dataPrevistaEfetivacao;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEnderecoIp() {
		return enderecoIp;
	}

	public void setEnderecoIp(String enderecoIp) {
		this.enderecoIp = enderecoIp;
	}

	public Long getNsuSiper() {
		return nsuSiper;
	}

	public void setNsuSiper(Long nsuSiper) {
		this.nsuSiper = nsuSiper;
	}
	
	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

}
