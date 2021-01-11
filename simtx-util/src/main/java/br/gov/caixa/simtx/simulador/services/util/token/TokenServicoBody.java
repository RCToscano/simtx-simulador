package br.gov.caixa.simtx.simulador.services.util.token;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TokenServicoBody {
	
	private String iss;

	private Date exp;

	private String aud;
	
	@JsonProperty("preferred_username")
	private String preferredUsername;
	
	private String deviceid;

	private String email;
	
	private String sub;

	private String name;
	
	private String clientAddress;
	
	@JsonProperty("service_username")
	private String serviceUsername;
	
	private String typ;
	
	private String nonce;
	
	private String azp;
	
	private String jti;
	
	private Date nbf;
	
	private Date iat;


	public String getJti() {
		return jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public Date getNbf() {
		return nbf;
	}

	public void setNbf(Date nbf) {
		this.nbf = nbf;
	}

	public Date getIat() {
		return iat;
	}

	public void setIat(Date iat) {
		this.iat = iat;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getAud() {
		return aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getAzp() {
		return azp;
	}

	public void setAzp(String azp) {
		this.azp = azp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getPreferredUsername() {
		return preferredUsername;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public String getServiceUsername() {
		return serviceUsername;
	}

	public void setPreferredUsername(String preferredUsername) {
		this.preferredUsername = preferredUsername;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public void setServiceUsername(String serviceUsername) {
		this.serviceUsername = serviceUsername;
	}

	public TokenServicoSsoBody getBodySSO(){
		if(this instanceof TokenServicoSsoBody) {
			return (TokenServicoSsoBody) this;
		}
		return null;
	}
	
	public TokenServicoB2cBody getBodyB2C(){
		if(this instanceof TokenServicoB2cBody) {
			return (TokenServicoB2cBody) this;
		}
		return null;
	}

}
