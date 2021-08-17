package br.gov.caixa.simtx.simulador.testes.pix;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.gson.Gson;

import br.gov.caixa.simtx.simulador.services.pagamentospi.v2.RequisicaoPagamentoSpiV2;

public class ProcessadorAtualizacaoPixTest {

	ObjectMapper jsonMapper;
	
	Gson gson;
	
	String json = "{\"idFimAFim\":\"E00360305202106172040551b70991ac\",\"valor\":25,\"usuarioPagador\":{\"nome\":\"MARI ANNE\",\"cpf\":\"10986435775\",\"conta\":{\"agencia\":\"0238\",\"numeroConta\":\"20\",\"produto\":\"001\",\"tipoConta\":\"CACC\",\"ispb\":\"00360305\"}},\"usuarioRecebedor\":{\"nome\":\"RIBAMAR DA CAIXA\",\"cpf\":\"11666543543\",\"conta\":{\"agencia\":\"2\",\"numeroConta\":\"9882276879\",\"produto\":\"1288\",\"tipoConta\":\"SVGS\",\"ispb\":\"00360305\"}},\"dataHoraRecebimentoPagador\":\"28/06/2021 22:37:16\",\"informacoesEntreUsuarios\":\"Teste Automatizado\",\"tipoAutenticacao\":\"SIMPLES\",\"nsu\":360,\"participanteTarifado\":\"SLEV\",\"prioridadePagamento\":\"NORM\",\"canal\":\"SIIBC\",\"pagamentoSiaafDto\":{\"titularidade\":\"\",\"categoriaConta\":\"\",\"jurosMulta\":\"\",\"descontoAbatimento\":\"\",\"dataVencimentoPagamento\":\"\",\"detalhesPagamento\":\"\",\"tempoExpiracaoQrCode\":\"\",\"pointInitiationMethod\":\"\",\"merchantAccountInformation\":\"\",\"merchantName\":\"\",\"merchantCategoryCode\":\"\",\"merchantCity\":\"\",\"countryCode\":\"\",\"finalidade\":\"\",\"identificacao\":\"\",\"codigoResposta\":\"\",\"codigoAcesso\":\"\",\"ipDispositivo\":\"189.68.241.73\",\"portaDispositivo\":\"59562\",\"idMobileFirst\":\"267FBA85EA8E117D\",\"latitude\":\"-23.59880286\",\"longitude\":\"-46.68371601\",\"precisao\":\"48.898968\",\"timeStampGeo\":\"1601753753000\",\"sistOperacionalDispositivo\":\"ANDROID\",\"sistOperacionalVersao\":\"10\",\"tipoDeDispositivo\":\"ANDROID PHONE\",\"aplicativoVersao\":\"3.6.0\",\"tipoDeAutenticacao\":\"2\",\"vm\":\"Falso\",\"root\":\"Falso\",\"nuCartao\":\"\",\"agenciaVinculacaoTerminal\":\"\",\"nuATM\":\"\",\"nuConveniado\":\"\",\"nuTerminalLoterico\":\"\",\"nuOperadorTerminal\":\"\",\"nuEstacaoFinanceiraOperacional\":\"\",\"ipURA\":\"\",\"mdcu\":\"\",\"nuTelefone\":\"\",\"nuOperadorEstacaoFinanceiraOperacional\":\"\",\"nuAutorizadorEstacaoFinanceiraOperacional\":\"\"},\"metodoLiquidacao\":\"CLRG\",\"transactionCurrency\":\"BRL\",\"formaIniciacaoPagamento\":\"QR_CODE_DINAMICO\",\"txId\":\"20210615N0770208653T0000021311\",\"tipoPrioridadePagamento\":\"PAGAGD\",\"finalidadeTransacao\":\"IPAY\"}";
	
	@Before
	public void antes() {
		jsonMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		gson = new Gson();
	}
	
	@Test
	public void test0() throws JsonParseException, JsonMappingException, IOException {
		JSONObject jsonObject = new JSONObject(json);
		JsonNode jsonNode = convertJsonFormat(jsonObject);
		String idFimAFim = jsonNode.get("idFimAFim").asText();
		assertEquals("E00360305202106172040551b70991ac", idFimAFim);
		RequisicaoPagamentoSpiV2 requisicao = jsonMapper.readValue(json, RequisicaoPagamentoSpiV2.class);
		assertEquals("E00360305202106172040551b70991ac", requisicao.getIdFimAFim());
	}
	
	@Test
	public void test1() {
		JSONObject jsonObject = new JSONObject(json);
		JsonNode jsonNode = convertJsonFormat(jsonObject);
		String idFimAFim = jsonNode.get("idFimAFim").asText();
		assertEquals("E00360305202106172040551b70991ac", idFimAFim);
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException {
		RequisicaoPagamentoSpiV2 requisicao = jsonMapper.readValue(json, RequisicaoPagamentoSpiV2.class);
		assertEquals("E00360305202106172040551b70991ac", requisicao.getIdFimAFim());
	}
	
	@Test
	public void test3() throws JsonParseException, JsonMappingException, IOException {
		RequisicaoPagamentoSpiV2 requisicao = gson.fromJson(json, RequisicaoPagamentoSpiV2.class);
		assertEquals("E00360305202106172040551b70991ac", requisicao.getIdFimAFim());
	}
	
	@Test
	public void test4() throws JsonParseException, JsonMappingException, IOException {
		JSONObject jsonObject = new JSONObject(json);
		JsonNode jsonNode = convertJsonFormat(jsonObject);
		RequisicaoPagamentoSpiV2 requisicao = jsonMapper.readValue(new TreeTraversingParser(jsonNode),
				RequisicaoPagamentoSpiV2.class);
		assertEquals("E00360305202106172040551b70991ac", requisicao.getIdFimAFim());
	}

	
	JsonNode convertJsonFormat(JSONObject json) {
	    ObjectNode ret = JsonNodeFactory.instance.objectNode();

	    @SuppressWarnings("unchecked")
	    Iterator<String> iterator = json.keys();
	    for (; iterator.hasNext();) {
	        String key = iterator.next();
	        Object value;
	        try {
	            value = json.get(key);
	        } catch (JSONException e) {
	            throw new RuntimeException(e);
	        }
	        if (json.isNull(key))
	            ret.putNull(key);
	        else if (value instanceof String)
	            ret.put(key, (String) value);
	        else if (value instanceof Integer)
	            ret.put(key, (Integer) value);
	        else if (value instanceof Long)
	            ret.put(key, (Long) value);
	        else if (value instanceof Double)
	            ret.put(key, (Double) value);
	        else if (value instanceof Boolean)
	            ret.put(key, (Boolean) value);
	        else if (value instanceof JSONObject)
	            ret.put(key, convertJsonFormat((JSONObject) value));
	        else if (value instanceof JSONArray)
	            ret.put(key, convertJsonFormat((JSONArray) value));
	        else
	            throw new RuntimeException("not prepared for converting instance of class " + value.getClass());
	    }
	    return ret;
	}

	JsonNode convertJsonFormat(JSONArray json) {
	    ArrayNode ret = JsonNodeFactory.instance.arrayNode();
	    for (int i = 0; i < json.length(); i++) {
	        Object value;
	        try {
	            value = json.get(i);
	        } catch (JSONException e) {
	            throw new RuntimeException(e);
	        }
	        if (json.isNull(i))
	            ret.addNull();
	        else if (value instanceof String)
	            ret.add((String) value);
	        else if (value instanceof Integer)
	            ret.add((Integer) value);
	        else if (value instanceof Long)
	            ret.add((Long) value);
	        else if (value instanceof Double)
	            ret.add((Double) value);
	        else if (value instanceof Boolean)
	            ret.add((Boolean) value);
	        else if (value instanceof JSONObject)
	            ret.add(convertJsonFormat((JSONObject) value));
	        else if (value instanceof JSONArray)
	            ret.add(convertJsonFormat((JSONArray) value));
	        else
	            throw new RuntimeException("not prepared for converting instance of class " + value.getClass());
	    }
	    return ret;
	}
	
}

