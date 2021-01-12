package br.gov.caixa.simtx.simulador.util.token;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenServicoSsoBody extends TokenServicoBody{

	@JsonProperty("auth_time")
	private Date authTime;
	
	@JsonProperty("session_state")
	private String sessionState;
	
	private String acr;
	
	@JsonProperty("allowed-origins")
	private List<Object> allowedOrigins;
	
	@JsonProperty("realm_access")
	private Object realmAccess;
	
	@JsonProperty("resource_access")
	private Object resourceAccess;
	
	private String scope;
	
	@JsonProperty("email_verified")
	private boolean emailVerified;
	
	private String clientId;
	
	private String clientHost;
	
	private String locale;
	
	@JsonProperty("given_name")
	private String givenName;
	
	private String dataNascimento;
	
	@JsonProperty("family_name")
	private String familyName;
	
	private String tipocred;
	
	private String ip;
	
	private String valor;
	
	private Object parametros;

	public Date getAuthTime() {
		return authTime;
	}

	public String getSessionState() {
		return sessionState;
	}

	public String getAcr() {
		return acr;
	}

	public List<Object> getAllowedOrigins() {
		return allowedOrigins;
	}

	public Object getRealmAccess() {
		return realmAccess;
	}

	public Object getResourceAccess() {
		return resourceAccess;
	}

	public String getScope() {
		return scope;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientHost() {
		return clientHost;
	}

	public String getLocale() {
		return locale;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getTipocred() {
		return tipocred;
	}

	public String getIp() {
		return ip;
	}

	public String getValor() {
		return valor;
	}

	public Object getParametros() {
		return parametros;
	}

	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}

	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}

	public void setAcr(String acr) {
		this.acr = acr;
	}

	public void setAllowedOrigins(List<Object> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

	public void setRealmAccess(Object realmAccess) {
		this.realmAccess = realmAccess;
	}

	public void setResourceAccess(Object resourceAccess) {
		this.resourceAccess = resourceAccess;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setTipocred(String tipocred) {
		this.tipocred = tipocred;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setParametros(Object parametros) {
		this.parametros = parametros;
	}
	
	
}
