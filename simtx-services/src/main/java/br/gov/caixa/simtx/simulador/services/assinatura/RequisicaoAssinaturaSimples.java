package br.gov.caixa.simtx.simulador.services.assinatura;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.util.vo.ContaSIBAR;

public class RequisicaoAssinaturaSimples {

	@NotNull(message = "cpf nao informado")
	@Min(value = 1, message= "cpf deve ser informado e ter 11 caracteres")
	@Max(value = 99999999999l, message= "cpf deve ser informado e ter 11 caracteres")
	private Long cpf;

	@NotNull(message = "conta nao informada")
	@Valid
	private ContaSIBAR conta;

	@NotNull(message = "assinatura nao informada")
	@Valid
	private Assinatura assinatura;

	@Max(value = 999999999999999l, message= "nsu_origem deve ter no maximo 15 caracteres")
	@JsonProperty("nsu_origem")
	@SerializedName("nsu_origem")
	private Long nsuOrigem;

	@NotNull(message = "data_prevista_efetivacao nao informada")
	@Size(min = 10, max = 10, message= "data_prevista_efetivacao deve ser informada e ter o seguinte formato aaaa-mm-dd")
	@JsonProperty("data_prevista_efetivacao")
	@SerializedName("data_prevista_efetivacao")
	private String dataPrevistaEfetivacao;

	@NotNull(message = "servico nao informado")
	@Min(value = 1, message= "servico nao informado")
	@Max(value = 999l, message= "servico deve ser informado e ter no maximo 3 caracteres")
	private Integer servico;

	@Size(max = 200, message= "descricao_transacao deve ter no maximo 200 caracteres")
	@JsonProperty("descricao_transacao")
	@SerializedName("descricao_transacao")
	private String descricaoTransacao;

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

	@NotNull(message = "data_transacao nao informada")
	@Size(min = 10, max = 10, message= "data_transacao deve ser informada e ter o seguinte formato aaaa-mm-dd")
	@JsonProperty("data_transacao")
	@SerializedName("data_transacao")
	private String dataTransacao;

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



	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public ContaSIBAR getConta() {
		return conta;
	}

	public void setConta(ContaSIBAR conta) {
		this.conta = conta;
	}

	public Assinatura getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Assinatura assinatura) {
		this.assinatura = assinatura;
	}

	public Long getNsuOrigem() {
		return nsuOrigem;
	}

	public void setNsuOrigem(Long nsuOrigem) {
		this.nsuOrigem = nsuOrigem;
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

	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}

	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
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

	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
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
