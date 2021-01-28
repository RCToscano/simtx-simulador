package br.gov.caixa.simtx.simulador.services.assinatura;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.util.vo.ContaAgencia;

public class RequisicaoValidaAssinatura {

	@NotNull(message = "conta nao informada")
	@Valid
	private ContaAgencia conta;

	@NotNull(message = "assinatura nao informada")
	@Size(min = 1, max = 16, message= "assinatura deve ser informada e ter no maximo 16 caracteres")
	private String assinatura;

	@NotNull(message = "token nao informado")
	@Size(min = 1, max = 80, message= "token deve ser informado e ter no maximo 80 caracteres")
	private String token;

	@NotNull(message = "session_id nao informado")
	@Size(min = 1, max = 32, message= "session_id deve ser informado e ter no maximo 32 caracteres")
	@JsonProperty("session_id")
	@SerializedName("session_id")
	private String sessionId;

	@NotNull(message = "apelido nao informado")
	@Size(min = 1, max = 20, message= "apelido deve ser informado e ter no maximo 20 caracteres")
	private String apelido;

	@NotNull(message = "endereco_ip nao informado")
	@Size(min = 1, max = 15, message= "endereco_ip deve ser informado e ter no maximo 15 caracteres")
	@JsonProperty("endereco_ip")
	@SerializedName("endereco_ip")
	private String enderecoIp;

	@NotNull(message = "classificacao nao informada")
	@Valid
	private ClassificacaoAssinaturaEnum classificacao;

	private Integer servico;

	@NotNull(message = "nsu nao informado")
	@Min(value = 1, message= "nsu nao informado")
	@Max(value = 999999999999999l, message= "nsu deve ser informado e ter no maximo 15 caracteres")
	private Long nsu;

	private TransacaoAssinaturaMultipla transacao;

	@NotNull(message = "data_prevista_efetivacao nao informada")
	@Size(min = 10, max = 10, message= "data_prevista_efetivacao deve ser informada e ter o seguinte formato aaaa-mm-dd")
	@JsonProperty("data_prevista_efetivacao")
	@SerializedName("data_prevista_efetivacao")
	private String dataPrevistaEfetivacao;

	@NotNull(message = "nsu_siper nao informado")
	@Min(value = 1, message= "nsu_siper nao informado")
	@Max(value = 999999999l, message= "nsu_siper deve ser informado e ter no maximo 9 caracteres")
	@JsonProperty("nsu_siper")
	@SerializedName("nsu_siper")
	private Long nsuSiper;

	@NotNull(message = "dispositivo nao informado")
	@Valid
	private Dispositivo dispositivo;



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

	public ClassificacaoAssinaturaEnum getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoAssinaturaEnum classificacao) {
		this.classificacao = classificacao;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public TransacaoAssinaturaMultipla getTransacao() {
		return transacao;
	}

	public void setTransacao(TransacaoAssinaturaMultipla transacao) {
		this.transacao = transacao;
	}

	public String getDataPrevistaEfetivacao() {
		return dataPrevistaEfetivacao;
	}

	public void setDataPrevistaEfetivacao(String dataPrevistaEfetivacao) {
		this.dataPrevistaEfetivacao = dataPrevistaEfetivacao;
	}

	public Long getNsuSiper() {
		return nsuSiper;
	}

	public void setNsuSiper(Long nsuSiper) {
		this.nsuSiper = nsuSiper;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	class TransacaoAssinaturaMultipla {

		private String resumo;

		private String data;

		public String getResumo() {
			return resumo;
		}

		public String getData() {
			return data;
		}

		public void setResumo(String resumo) {
			this.resumo = resumo;
		}

		public void setData(String data) {
			this.data = data;
		}
	}

}
