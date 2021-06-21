package br.gov.caixa.simtx.simulador.services.atualizasituacaosssinaturamultipla;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequisicaoAtualizaSituacaoAssinatuaMultiplaApiV1 {

	@NotNull (message = "idConta Obrigatoria")
	private String idConta;
	
	@NotNull (message = "nsuSiper Obrigatoria")
	private Integer nsuSiper;
	
	@NotNull (message = "data_movimento_siper Obrigatoria")
	private String data_movimento_siper;

	@NotNull (message = "data_movimento Obrigatoria")
	private String data_movimento;

	@NotNull (message = "nsu Obrigatoria")
	private Long nsu;
	
	@NotNull (message = "situacao Obrigatoria")
	private String situacao;

	@NotNull (message = "codigo_resposta Obrigatoria")
	private String codigo_resposta;

	public String getData_movimento_siper() {
		return data_movimento_siper;
	}

	public void setData_movimento_siper(String data_movimento_siper) {
		this.data_movimento_siper = data_movimento_siper;
	}

	public String getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(String data_movimento) {
		this.data_movimento = data_movimento;
	}

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getCodigo_resposta() {
		return codigo_resposta;
	}

	public void setCodigo_resposta(String codigo_resposta) {
		this.codigo_resposta = codigo_resposta;
	}

	public String getIdConta() {
		return idConta;
	}

	public void setIdConta(String idConta) {
		this.idConta = idConta;
	}

	public Integer getNsuSiper() {
		return nsuSiper;
	}

	public void setNsuSiper(Integer nsuSiper) {
		this.nsuSiper = nsuSiper;
	}
}