package br.gov.caixa.simtx.simulador.util.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenServicoSaida {

	@JsonProperty(value = "access_token")
	private String accessToken;

	@JsonProperty(value = "expires_in")
	private Integer expiresIn;

	@JsonProperty(value = "refresh_expires_in")
	private Integer refreshExpiresIn;

	@JsonProperty(value = "refresh_token")
	private String refreshToken;

	@JsonProperty(value = "token_type")
	private String tokenType;

	@JsonProperty(value = "not-before-policy")
	private String notBeforePolicy;

	@JsonProperty(value = "session_state")
	private String sessionState;

	private String scope;

	public String getAccessToken() {
		return accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public Integer getRefreshExpiresIn() {
		return refreshExpiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public String getNotBeforePolicy() {
		return notBeforePolicy;
	}

	public String getSessionState() {
		return sessionState;
	}

	public String getScope() {
		return scope;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setRefreshExpiresIn(Integer refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public void setNotBeforePolicy(String notBeforePolicy) {
		this.notBeforePolicy = notBeforePolicy;
	}

	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
