package br.gov.caixa.simtx.simulador.testes.pix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import br.gov.caixa.simtx.simulador.testes.banco.Conexao;
import br.gov.caixa.simtx.simulador.testes.base.BaseTeste;
import br.gov.caixa.simtx.simulador.testes.base.Constantes;
import br.gov.caixa.simtx.simulador.testes.base.RespostaErroSIMTX;
import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.http.ClientID;
import br.gov.caixa.simtx.simulador.util.http.PropriedadesHTTP;
import br.gov.caixa.simtx.simulador.util.http.RequisicaoHTTP;
import br.gov.caixa.simtx.simulador.util.http.RespostaHTTP;
import br.gov.caixa.simtx.simulador.util.http.TipoGeracaoToken;
import br.gov.caixa.simtx.simulador.util.http.TokenTransacaoSaida;
import br.gov.caixa.simtx.simulador.util.ssh.RequisicaoSSH;

public class PixTest extends BaseTeste {
	
	private Connection connection;
	
	private static final boolean UTILIZARHTTP = true;
	
	private static final String PATH = "pix/";
	
//	private static final String URI = "https://simtx.pagamentopix.des.caixa/pagamentos-instantaneos/v3/pagamentos";
//	private static final String URI = "https://simtx02.webservices.des.caixa/pagamentos-instantaneos/v3/pagamentos";
//	private static final String URI = "https://simtx03.webservices.des.caixa/pagamentos-instantaneos/v3/pagamentos";
//	private static final String URI = "https://simtx.webservices.des.caixa/pagamentos-instantaneos/v3/pagamentos";
	private static final String URI = "http://localhost:28080/pagamentos-instantaneos/v3/pagamentos";
	
	private static final String URI_IDFIMAFIM = "https://sispi-container-backend-des-esteiras.nprd2.caixa/sispi-api-war/api/v1/ids-pagamento";
	
	private static final Long[] TAREFAS_NEGOCIAIS = { 100109l, 100103l };
	
	private String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJvbGczaGJWRU0zX2dSdDFEZHBYTXdPWHRTLUUyTVFRRGIwQmh3Nkl2WmRvIn0.eyJqdGkiOiJhZGQzODI3YS1hMGExLTQ5N2EtODU4YS1iZjZmMzgxNTE5NGQiLCJleHAiOjE2MjM5Njg2ODksIm5iZiI6MCwiaWF0IjoxNjIzOTY3Nzg5LCJpc3MiOiJodHRwczovL2xvZ2luZGVzLmNhaXhhLmdvdi5ici9hdXRoL3JlYWxtcy9pbnRlcm5ldCIsInN1YiI6IjY5OGJlOTk2LWMxYmItNGIxOC05ZDZjLTdhYmY0ZTY0ZWIyZiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsaS1zZXItbmJjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMWNkMGJhMTQtNjVjYi00YjhiLTkzZTktMmE4MGEwZTFlY2M1IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJCUkpfU0ZHX1NBUVVFX0VNRVJHRU5DSUFMX0FQSSIsIkJSSl9TRkdfU0FRVUVfRElHSVRBTF9BUEkiLCJCUkpfSVNPX1BFU1NPQV9OQVRVUkFMX0FQSSIsIkJSSl9TRkdfSU5GT1JNQUNPRVNfRkdUU19BUEkiLCJTUElfRENUIiwiSEFCX0NPTlRSQVRPU19TRVJWIiwidW1hX2F1dGhvcml6YXRpb24iLCJTSU5CQy1QVVNILUFUSVZPIiwiRkVDX0NBTkFMX1RPS0VOX1NFUlZJQ08iXX0sInNjb3BlIjoiIiwic2VnbWVudG9fc2lzdGVtYSI6IjExMTUiLCJjbGllbnRIb3N0IjoiMTg5LjEwOS4yMTYuMTAiLCJjbGllbnRJZCI6ImNsaS1zZXItbmJjIiwic2VydmljZV91c2VybmFtZSI6IlNJQkNTMDFEIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LWNsaS1zZXItbmJjIiwiY2xpZW50QWRkcmVzcyI6IjE4OS4xMDkuMjE2LjEwIiwiZW1haWwiOiJzZXJ2aWNlLWFjY291bnQtY2xpLXNlci1uYmNAcGxhY2Vob2xkZXIub3JnIn0.FYMxYmMV_S9J2QwlEFSoa9jcwrZ-QNuqioi8Tnu5PY7mEfwwqa-X2BmTmPV0mFYCgABsfiwuAonuADkm1SQRCEdqtGqmBhyq0NflDo1GE1g1nfC5w4oHHL3Gg-3PV67HMjheFSn1_ACDCsbyawh7BFZQY3_5WmioHVMi0oSs7njAr_IOOeIV7Q-M_R1AMGqL2gVcme0D-rwlF42kPfy3pJn_MTBZegtVaMfI6qhC793mCs3ixD6gLW8d6LXEx2TJf00KAIJCX6Rtvu85kJgxq1KlnvVQcyyp25gND7GWagm2rLwWYawcrbptFgPIWrS75m7Y8QN-9-LZkRKNPoFhcA";
	
	private String tokenTransacao;
	
	private String idFimAFim = "E00360305202106172040551b70991ac";
	
	private String dadosAntiFraude;
	
	
	@Before
	public void inicializarDados() throws ControleException, SQLException {
		if (!URI.contains("localhost")) {
			token = RequisicaoHTTP
					.gerarToken(TipoGeracaoToken.NOVO_TOKEN, ClientID.SINBC.getId(), ClientID.SINBC.getSecret())
					.getAccessToken();
	
			String comando = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("token_transacao/curl.json"));
	
			String tokenSaida = RequisicaoSSH.requisicao(comando);
			assertNotNull(Constantes.ERRO_GERAR_TOKEN, tokenSaida);
			assertTrue(Constantes.ERRO_GERAR_TOKEN, tokenSaida.contains("token"));
	
			TokenTransacaoSaida tokenTransacaoSaida = gson.fromJson(tokenSaida, TokenTransacaoSaida.class);
			tokenTransacao = tokenTransacaoSaida.getToken();
	
			String jsonIdFimAFim = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("idFim/pagamento.json"));
	
			RespostaHTTP respidFimAFim = RequisicaoHTTP.realizarEnvioHttps(URI_IDFIMAFIM, jsonIdFimAFim,
					PropriedadesHTTP.METODO_POST, 
					new PropriedadesHTTP("Content-Type", MediaType.APPLICATION_JSON),
					new PropriedadesHTTP("Authorization", "Bearer ".concat(token)));
			
			assertNotEquals("IdFimAFim nao gerado. Resposta status: " + respidFimAFim.getStatus(),
					respidFimAFim.getMensagem(), "");
	
			idFimAFim = gson.fromJson(respidFimAFim.getMensagem(), IdFimaFimVO.class).getId();
		}

		dadosAntiFraude = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("anti_fraude/dados.json"));
		dadosAntiFraude = codificaBase64(dadosAntiFraude);
		
		this.connection = Conexao.obterConexao();
	}
	
	@After
	public void finalizarTestes() throws SQLException {
		if(this.connection != null) {
			this.connection.close();
		}
	}
	
	public String executarRequisicao(String path, String token, String meioEntrada, String dadosAntiFraude, int statusEsperado) {
		if(UTILIZARHTTP) {
			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("pagamento/").concat(path));
			jsonPagamento = jsonPagamento.replace("{IDFIMAFIM}", idFimAFim);
			jsonPagamento = jsonPagamento.replace("{DATAHORA}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON).concat("Z"));
			
			ClientResponse resposta = RequisicaoHTTP.requestPostApi(URI, token, jsonPagamento, meioEntrada, dadosAntiFraude);
			assertNotNull(Constantes.SEM_RESPOSTA_HTTP, resposta);
			String saida = resposta.getEntity(String.class);
			assertEquals(Constantes.RESPOSTA_DIVERGENTE_HTTP + resposta.getStatus() + "] " + saida, statusEsperado,
					resposta.getStatus());

			return saida;
		}
		else {
			path = path.replace(".json", "_curl.json");

			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("pagamento/").concat(path));
			jsonPagamento = jsonPagamento.replace("{URI}", URI);
			jsonPagamento = jsonPagamento.replace("{TOKEN}", tokenTransacao);
			jsonPagamento = jsonPagamento.replace("{MEIOENTRADA}", meioEntrada);
			jsonPagamento = jsonPagamento.replace("{ANTIFRAUDE}", dadosAntiFraude);
			jsonPagamento = jsonPagamento.replace("{IDFIMAFIM}", idFimAFim);
			jsonPagamento = jsonPagamento.replace("{DATAHORA}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON).concat("Z"));

			String resposta = RequisicaoSSH.requisicao(jsonPagamento);
			assertNotNull(Constantes.SEM_RESPOSTA, resposta);
			assertFalse(Constantes.SEM_RESPOSTA, resposta.isEmpty());
			assertFalse(Constantes.SEM_RESPOSTA, resposta.contains("404 Not Found"));

			try {
				RespostaErroSIMTX erroSIMTX = mapper.readerFor(RespostaErroSIMTX.class).readValue(resposta);

				assertEquals(Constantes.RESPOSTA_IMPEDITIVA_HTTP + erroSIMTX.getCodigoRetorno() + "] " + resposta,
						String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()), erroSIMTX.getCodigoRetorno());
			} 
			catch (IOException e) {
				return resposta;
			}
			return resposta;
		}
	}

	@Test
	public void testIBCSucesso() throws IOException, ControleException {
		String pathTeste001 = "V1/todosCampos.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
		tarefas.add(100113l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada, dadosAntiFraude, Response.Status.CREATED.getStatusCode());
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaPixV1VO respostasPixVO = mapper.readerFor(RespostaPixV1VO.class).readValue(saida);
		validarAtributosCampos(respostasPixVO);

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuTransacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 3, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(respostasPixVO.getNsuTransacao(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(respostasPixVO.getNsuTransacao(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(respostasPixVO.getNsuTransacao(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, tarefas.size(), listTarefas.size());
		for (int i = 0; i < listTarefas.size(); i++) {
			assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
					tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
		}
	}
	
	@Test
	public void testNBMSucesso() throws IOException {
		try {
			String pathTeste001 = "V1/todosCampos.json";
			List<Long> tarefas = new ArrayList<>();
			tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
			tarefas.add(100116l);
	
			String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("token_transacao/dados.json"));
			meioEntrada = codificaBase64(meioEntrada);
	
			String saida = executarRequisicao(pathTeste001, tokenTransacao, meioEntrada, dadosAntiFraude, Response.Status.CREATED.getStatusCode());
			assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS + saida, saida.contains("null"));
	
			RespostaPixV1VO respostasPixVO = mapper.readerFor(RespostaPixV1VO.class).readValue(saida);
			validarAtributosCampos(respostasPixVO);
	
			Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuTransacao(), this.connection);
			assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
			assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 3, transacao.getIcSituacao());
	
			assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
					tabelas.possuiIteracaoCanal(respostasPixVO.getNsuTransacao(), this.connection));
	
			assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
					tabelas.possuiServicoTransacao(respostasPixVO.getNsuTransacao(), this.connection));
	
			List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(respostasPixVO.getNsuTransacao(), this.connection);
			assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
			assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, tarefas.size(), listTarefas.size());
			for (int i = 0; i < listTarefas.size(); i++) {
				assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
						tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
			}
		} 
		catch (ControleException e) {
			assertTrue(e.getMensagem(), e.getMensagem().isEmpty());
		}
	}
	
	@Test
	public void testOpenBanking() throws IOException, ControleException {
		String pathTeste001 = "V1/todosCamposOpenBanking.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
		tarefas.add(100113l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada, dadosAntiFraude, Response.Status.CREATED.getStatusCode());
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaPixV1VO respostasPixVO = mapper.readerFor(RespostaPixV1VO.class).readValue(saida);
		validarAtributosCampos(respostasPixVO);

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuTransacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 3, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(respostasPixVO.getNsuTransacao(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(respostasPixVO.getNsuTransacao(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(respostasPixVO.getNsuTransacao(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, tarefas.size(), listTarefas.size());
		for (int i = 0; i < listTarefas.size(); i++) {
			assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
					tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
			assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS,
					listTarefas.get(i).getDeXmlRequisicao().contains("null"));
			if(listTarefas.get(i).getNuTarefa() == 100109l) {
				assertTrue(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS,
						listTarefas.get(i).getDeXmlRequisicao().contains("paymentId"));
				assertTrue(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS,
						listTarefas.get(i).getDeXmlRequisicao().contains("cnpjIniciadorPagamento"));
			}
		}
	}
	
	@Test
	public void testCPFDiferenteConta() throws IOException, ControleException {
		String pathTeste001 = "V1/cpfDiferenteConta.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100116l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("token_transacao/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("pagamento/").concat(pathTeste001));
		jsonPagamento = jsonPagamento.replace("{IDFIMAFIM}", idFimAFim);
		jsonPagamento = jsonPagamento.replace("{DATAHORA}",
				DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));

		String saida = executarRequisicao(pathTeste001, pathTeste001, meioEntrada, "", Response.Status.BAD_REQUEST.getStatusCode());
		
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaErroSIMTX respostaErro = mapper.readerFor(RespostaErroSIMTX.class).readValue(saida);
		validarAtributosCampos(respostaErro);

		assertTrue(Constantes.MSG_NEGOCIAL_DIFERENTE,
				respostaErro.getMensagem().getMensagemNegocial().contains("CPF INFORMADO"));

		Transacao transacao = tabelas.possuiTransacao(respostaErro.getNsu(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 2, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16, tabelas.possuiIteracaoCanal(respostaErro.getNsu(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17, tabelas.possuiServicoTransacao(respostaErro.getNsu(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(respostaErro.getNsu(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, 1, listTarefas.size());
		for (int i = 0; i < listTarefas.size(); i++) {
			assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
					tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
		}
	}
	
}
