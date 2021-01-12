package br.gov.caixa.simtx.simulador.util.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenServicoB2cBody extends TokenServicoBody {

	private String origem;
	
	private String so;
	
	private String app;
	
	private Integer qualificacao;
	
	private String nivel;
	
	private String tid;
	
	@JsonProperty("b2c_jwks")
	private String b2cJwks;
	
	private String scp;
	
	private String ver;

	public String getOrigem() {
		return origem;
	}

	public String getSo() {
		return so;
	}

	public String getApp() {
		return app;
	}

	public Integer getQualificacao() {
		return qualificacao;
	}

	public String getNivel() {
		return nivel;
	}

	public String getTid() {
		return tid;
	}

	public String getB2cJwks() {
		return b2cJwks;
	}

	public String getScp() {
		return scp;
	}

	public String getVer() {
		return ver;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public void setQualificacao(Integer qualificacao) {
		this.qualificacao = qualificacao;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setB2cJwks(String b2cJwks) {
		this.b2cJwks = b2cJwks;
	}

	public void setScp(String scp) {
		this.scp = scp;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	
}
