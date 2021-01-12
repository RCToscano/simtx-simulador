package br.gov.caixa.simtx.simulador.util.token;

public class TokenServico {

	private TokenServicoHeader header;

	private TokenServicoBody body;
	
	public TokenServico(TokenServicoHeader header, TokenServicoBody body) {
		super();
		this.header = header;
		this.body = body;
	}
	
	public TokenServicoHeader getHeader() {
		return header;
	}

	public TokenServicoBody getBody() {
		return body;
	}


}
