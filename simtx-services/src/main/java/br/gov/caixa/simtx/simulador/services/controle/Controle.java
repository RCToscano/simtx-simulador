package br.gov.caixa.simtx.simulador.services.controle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import br.gov.caixa.simtx.simulador.util.exception.ControleException;


public abstract class Controle {
	
	private static final Logger logger = Logger.getLogger(Controle.class);
	
	protected static final String BASE_PATH_JSON = "/respostas/";
	
	protected Gson gson = new Gson();
	

	public String simuladorGenerico(Object requisicao, String path) throws ControleException, IOException {
		logger.info("[SIMULADOR] Mensagem recebida: "+ gson.toJson(requisicao));
		validarAtributosCampos(requisicao);
		
		InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + path + "/200.json");
		String resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
		
		logger.info("[SIMULADOR] Enviando resposta: " + resposta);
		return resposta;
	}
	
	public void validarAtributosCampos(Object objeto) throws ControleException {
		logger.info("Validando campos de entrada");
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
			logger.error("Arquivo com caminho["+path+"] nao encontrado", e);
			return "Arquivo com caminho["+path+"] nao encontrado";
		}  
	}
	
}
