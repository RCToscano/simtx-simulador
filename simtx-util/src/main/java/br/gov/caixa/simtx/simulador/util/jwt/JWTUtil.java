package br.gov.caixa.simtx.simulador.util.jwt;


import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.token.ChaveSSO;
import br.gov.caixa.simtx.simulador.util.token.TokenServico;
import br.gov.caixa.simtx.simulador.util.token.TokenServicoBody;
import br.gov.caixa.simtx.simulador.util.token.TokenServicoHeader;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTUtil {
	
	private static final Logger logger = Logger.getLogger(JWTUtil.class);

	private static String chave = "DFAS63456FGSD567DFH45699HG";

	public static final String TOKEN_HEADER = "Authorization";


	private JWTUtil() {}
	
	public static String geraToken(String usuario, String grupo) {
    	// 240 minutos = 4 horas - Padrao.
    	final Integer minutos = 10;
    	
        return geraToken(usuario, grupo, minutos);
    }

    public static String geraToken(String usuario, String grupo, Integer minutos) {
        final Calendar calendar = Calendar.getInstance(); 
    	calendar.add(Calendar.MINUTE, minutos);        
    	final Date expiryDate = calendar.getTime();
    	
        return Jwts.builder().setId(grupo)
                .setSubject(usuario)
                .signWith(SignatureAlgorithm.HS512, chave)
                .setExpiration(expiryDate)
                .compact();
    }
    
    public static TokenServico validarToken(String token) throws ControleException {
		try {
			logger.info("[SIMULADOR] Validando Token: "+token);
			TokenServico tokenServico = quebraToken(token);
//			recuperarValidarChave(token, tokenServico);
			return tokenServico;
		}
		catch (ExpiredJwtException e) {
			logger.error("[SIMULADOR] Token Expirado");
			throw new ControleException("TOKEN EXPIRADO", "SIMULADOR");
		}
//		catch (MalformedJwtException | SignatureException | UnsupportedJwtException
//				| NoSuchAlgorithmException | InvalidKeySpecException e) {
//			logger.error("[SIMULADOR] Token Invalido");
//			throw new ControleException("TOKEN INVALIDO", "SIMULADOR");
//		} 
	}

	private static TokenServico quebraToken(String tokenJwt) throws ControleException {
		try {
	    	String[] splitString = tokenJwt.split("\\.");
			String base64EncodedHeader = splitString[0];
			String base64EncodedBody = splitString[1];
			
			String header = new String(Base64.getDecoder().decode(base64EncodedHeader));
			String body = new String(Base64.getDecoder().decode(base64EncodedBody));
			
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TokenServicoHeader tokenServicoHeader = mapper.readValue(header, TokenServicoHeader.class);
			
			TokenServicoBody tokenServicoBody = mapper.readValue(body, TokenServicoBody.class);
			return new TokenServico(tokenServicoHeader, tokenServicoBody);
			
		} 
		catch (Exception e) {
			logger.error("Nao foi possivel quebrar o token", e);
			throw new ControleException("TOKEN INVALIDO. FALHA AO QUEBRAR", "SIMULADOR");
		}
    }
	
	private static void recuperarValidarChave(String token, TokenServico tokenServico)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		ChaveSSO chaveSSO = new ChaveSSO();
		chaveSSO.setRealm("internet");
		chaveSSO.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxz8PNmiUW5J1669pWY0APB4flqqDnghAv/QV5DIHyXE39fj9u1DPXbgfDUhUfK0i/B0CHJukbI44Rgo/vuhCMImTnLjS49XuTH6GI4lU/CtdzE/qACMO/GUky73m0Uszo2Bh1wNV+fvw/mMQVAGKj6/qXjSB9npRZKydoXnwGPIepcrqF6KkMJIFtZ+0w35J9SYwgLNezUbAJgs9dq3yMj4ussSfxMFcUC9UKziJJSg0UQfl0fOQGMsrsnUbS2GgXeDqdskbZq9/wfL0ikU2pWf0hKjX+PXtqZI0SVWurVyydc0efbTE7qIlrwF8lWZ8NZ8zcV2oVk7TjoIktZ4zBwIDAQAB");
		chaveSSO.setTokenService("https://logindes.caixa.gov.br/auth/realms/internet/protocol/openid-connect");
		chaveSSO.setAccountService("https://logindes.caixa.gov.br/auth/realms/internet/account");
		chaveSSO.setTokensNotBefore(new Date());
		validarToken(token, chaveSSO.getPublicKey());
	}

	private static boolean validarToken(String token, String publicKey)
			throws ExpiredJwtException, NoSuchAlgorithmException, InvalidKeySpecException, MalformedJwtException,
			SignatureException, UnsupportedJwtException {

		byte[] decode = DatatypeConverter.parseBase64Binary(publicKey);
		X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(decode);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(keySpecX509);

		Jwts.parser().setSigningKey(pubKey).parseClaimsJws(token).getBody();
		return true;
	}
    
	public static Jws<Claims> decodificaToken(String token) {
		try {
			return Jwts.parser().setSigningKey(chave).parseClaimsJws(token);
		} 
		catch (Exception e) {
			return null;
		}
	}
	
}
