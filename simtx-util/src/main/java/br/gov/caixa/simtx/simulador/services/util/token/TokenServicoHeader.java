package br.gov.caixa.simtx.simulador.services.util.token;

public class TokenServicoHeader {
	
	private String kid;
	
	private String typ;
	
	private String alg;


	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}
	
}
