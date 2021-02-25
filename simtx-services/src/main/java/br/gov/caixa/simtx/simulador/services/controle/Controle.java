package br.gov.caixa.simtx.simulador.services.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.gov.caixa.simtx.simulador.util.exception.ControleException;


public abstract class Controle {
	
	private static final Logger logger = Logger.getLogger(Controle.class);
	
	protected static final String SIMULADOR_ERRO = "[SIMULADOR] ERRO";
	
	protected static final String BASE_PATH_JSON = "/respostas/";
	
	protected Gson gson = new Gson();
	
	protected ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	

	public String simuladorGenerico(Object requisicao, String path) throws ControleException, IOException {
		logger.info("[SIMULADOR] Mensagem recebida: "+ gson.toJson(requisicao));
		validarAtributosCampos(requisicao);
		
		InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + path + "/200.json");
		String resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
		
		logger.info("[SIMULADOR] Enviando resposta: " + resposta);
		return resposta;
	}
	
	public void validarAtributosCampos(Object objeto) throws ControleException {
		if(objeto != null) {
			logger.info("[SIMULADOR] Validando campos de entrada");
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Object>> violations = validator.validate(objeto);
			if(!violations.isEmpty() ) {
				String mensagem = "Campos invalidos:";
				for (Iterator<ConstraintViolation<Object>> iter = violations.iterator(); iter.hasNext();) {
					ConstraintViolation<Object> erro = iter.next();
					mensagem = mensagem.concat(" | ").concat(erro.getMessage());
				}
				throw new ControleException(mensagem, "SIMULADOR");
			}
		}
	}
	
	public String montarMsgErro(String path, String mensagem) {
		String jsonSibar = recuperarJson(path);
		return jsonSibar.replace("{MSG}", mensagem);
	}
	
	public String montarMsgErroSibar(String mensagem) {
		String jsonSibar = recuperarJson(BASE_PATH_JSON + "erro_generico_sibar.json");
		return jsonSibar.replace("{MSG}", mensagem);
	}
	
	public String recuperarJson(String path) {
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream(path);
			return IOUtils.toString(input, StandardCharsets.UTF_8);
		} 
		catch (IOException e) {
			logger.error("[SIMULADOR] Arquivo com caminho["+path+"] nao encontrado", e);
			return "Arquivo com caminho["+path+"] nao encontrado";
		}  
	}
	
	public String requisicaoHttpHttps(String uri, String metodo, String token, String requisicao) throws Exception {
		if(uri.contains("https")) {
			return requisicaoHttps(uri, metodo, token, requisicao);
		}
		else {
			return requisicaoHttp(uri, metodo, token, requisicao);
		}
	}
	
	public String requisicaoHttp(String uri, String metodo, String token, String requisicao) throws Exception {
		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", token);
			connection.setRequestMethod(metodo);
			connection.setConnectTimeout(1000);
			connection.setReadTimeout(10000);
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(requisicao);
			out.close();

			int status = connection.getResponseCode();
			if (status / 100 != 2) {
				logger.error("Ocorreu algum erro. Codigo de reposta: " + status);
			}
			
			String retornoTransacional = "";

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				while ((retornoTransacional = reader.readLine()) != null) {
					logger.info("Retorno: " + retornoTransacional);
					return retornoTransacional;
				}
			}
			
			return retornoTransacional;
		} 
		catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public String requisicaoHttps(String uri, String metodo, String token, String requisicao) throws Exception {
		try {
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

			URL url = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setSSLSocketFactory(sslsocketfactory);
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", token);
			connection.setRequestMethod(metodo);
			connection.setConnectTimeout(1000);
			connection.setReadTimeout(10000);
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(requisicao);
			out.close();

			int status = connection.getResponseCode();
			if (status / 100 != 2) {
				logger.error("Ocorreu algum erro. Codigo de reposta: " + status);
			}
			
			String retornoTransacional = "";

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				while ((retornoTransacional = reader.readLine()) != null) {
					logger.info("Retorno do transacional: " + retornoTransacional);
					return retornoTransacional;
				}
			}
			
			return retornoTransacional;
		} 
		catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
}
