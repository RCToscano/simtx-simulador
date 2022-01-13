package br.gov.caixa.simtx.simulador.testes.base;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;

import br.gov.caixa.simtx.simulador.testes.banco.Tabelas;
import br.gov.caixa.simtx.simulador.testes.banco.TabelasSicco;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;


public abstract class BaseTeste {

	private static final Logger logger = Logger.getLogger(BaseTeste.class);

	protected static final String SIMULADOR_ERRO = "[SIMULADOR] ERRO";

	protected static final String BASE_PATH_JSON = "testes_json/";
	
	protected static final String BASE_PATH_XML = "testes_xml/";
	
	protected static final String PATH_MEIO_ENTRADA = "meio_entrada/";
	
	protected Tabelas tabelas = new Tabelas();
	
	protected TabelasSicco tabelasSicco = new TabelasSicco();

	protected Gson gson = new Gson();

	protected ObjectMapper mapper = new ObjectMapper();
	
	
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
	
	public void validarAtributosCampos(Object objeto) throws ControleException {
		if(objeto != null) {
			logger.info("Validando campos");
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Object>> violations = validator.validate(objeto);
			if(!violations.isEmpty() ) {
				String mensagem = "Campos invalidos:";
				for (Iterator<ConstraintViolation<Object>> iter = violations.iterator(); iter.hasNext();) {
					ConstraintViolation<Object> erro = iter.next();
					mensagem = mensagem.concat(" | ").concat(erro.getMessage());
				}
				throw new ControleException(mensagem, "TESTE");
			}
		}
	}
	
	public void validarTabelasBase(Long nsuTransacao, Connection connection) {
		assertTrue("Registro nao encontrada na tabela MTXTB014_TRANSACAO", tabelas.possuiTransacao(nsuTransacao, connection) != null);
		assertTrue("Registro nao encontrado na tabela MTXTB016_ITERACAO_CANAL", tabelas.possuiIteracaoCanal(nsuTransacao, connection));
		assertTrue("Registro nao encontrada na tabela MTXTB017_VERSAO_SRVCO_TRNSO", tabelas.possuiServicoTransacao(nsuTransacao, connection));
	}
	
	public String codificaBase64(String informacoes) {
		return BaseEncoding.base64().encode(informacoes.getBytes());
    }
	
	public String decodificaBase64(String informacoes) {
		return new String(BaseEncoding.base64().decode(informacoes));
	}

}
