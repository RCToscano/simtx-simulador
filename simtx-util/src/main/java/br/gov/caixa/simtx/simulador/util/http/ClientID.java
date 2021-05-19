package br.gov.caixa.simtx.simulador.util.http;

public enum ClientID {

	SINBC("cli-ser-nbc", "6733b222-d7f0-456d-99c7-fbdc80b8cf15"),
	SINBM("cli-mob-nbm", "fef967ab-e8c7-4f20-bea7-df454c97e0cb"),
	SIMAI("cli-ser-mai", "02af15f9-b93b-4153-ac2a-b17487388dfe"),
	SIMTX("cli-ser-mtx", "0cb712cc-0ae0-4534-83b3-34d8b982bf55"),
	;
	
	private String id;
	
	private String secret;
	
	private ClientID(String id, String secret) {
		this.id = id;
		this.secret = secret;
	}

	public String getId() {
		return id;
	}

	public String getSecret() {
		return secret;
	}
	
}
