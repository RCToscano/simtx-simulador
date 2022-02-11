package br.gov.caixa.simtx.simulador.testes.xml.sicco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sun.jersey.api.client.ClientResponse;

import br.gov.caixa.simtx.simulador.testes.banco.Conexao;
import br.gov.caixa.simtx.simulador.testes.base.BaseTeste;
import br.gov.caixa.simtx.simulador.testes.base.Constantes;
import br.gov.caixa.simtx.simulador.testes.base.RespostaErroSIMTX;
import br.gov.caixa.simtx.simulador.testes.fila.Fila;
import br.gov.caixa.simtx.simulador.testes.pix.IdFimaFimVO;
import br.gov.caixa.simtx.simulador.testes.pix.RespostaPixV1VO;
import br.gov.caixa.simtx.simulador.testes.pix.agendamento.vo.RespostaAgendamentoPixV1VO;
import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
import br.gov.caixa.simtx.simulador.testes.tabelas.TarefasSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoAgendamento;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoInterfaceSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoSicco;
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.http.ClientID;
import br.gov.caixa.simtx.simulador.util.http.PropriedadesHTTP;
import br.gov.caixa.simtx.simulador.util.http.RequisicaoHTTP;
import br.gov.caixa.simtx.simulador.util.http.RespostaHTTP;
import br.gov.caixa.simtx.simulador.util.http.TipoGeracaoToken;
import br.gov.caixa.simtx.simulador.util.http.TokenTransacaoSaida;
import br.gov.caixa.simtx.simulador.util.ssh.RequisicaoSSH;

@RunWith(JUnitPlatform.class)
class RecebimentoApiTest extends BaseTeste {

private Connection connection;
	
	private static final boolean UTILIZARHTTP = true;
	
	private static final String PATH = "pix/";
	
	private static final String URI = "http://sicco02.webservices.des.caixa/receber-transacoes-lote/lote/inclusao";
//	private static final String URI = "http://localhost:8080/pagamento-instantaneo-agendado-api/v1/agendamentos";
	
	private static final Long[] TAREFAS_NEGOCIAIS = { 100103l, 100129l, 100130l, 100131l };
	
	private String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJvbGczaGJWRU0zX2dSdDFEZHBYTXdPWHRTLUUyTVFRRGIwQmh3Nkl2WmRvIn0.eyJqdGkiOiJhZGQzODI3YS1hMGExLTQ5N2EtODU4YS1iZjZmMzgxNTE5NGQiLCJleHAiOjE2MjM5Njg2ODksIm5iZiI6MCwiaWF0IjoxNjIzOTY3Nzg5LCJpc3MiOiJodHRwczovL2xvZ2luZGVzLmNhaXhhLmdvdi5ici9hdXRoL3JlYWxtcy9pbnRlcm5ldCIsInN1YiI6IjY5OGJlOTk2LWMxYmItNGIxOC05ZDZjLTdhYmY0ZTY0ZWIyZiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsaS1zZXItbmJjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMWNkMGJhMTQtNjVjYi00YjhiLTkzZTktMmE4MGEwZTFlY2M1IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJCUkpfU0ZHX1NBUVVFX0VNRVJHRU5DSUFMX0FQSSIsIkJSSl9TRkdfU0FRVUVfRElHSVRBTF9BUEkiLCJCUkpfSVNPX1BFU1NPQV9OQVRVUkFMX0FQSSIsIkJSSl9TRkdfSU5GT1JNQUNPRVNfRkdUU19BUEkiLCJTUElfRENUIiwiSEFCX0NPTlRSQVRPU19TRVJWIiwidW1hX2F1dGhvcml6YXRpb24iLCJTSU5CQy1QVVNILUFUSVZPIiwiRkVDX0NBTkFMX1RPS0VOX1NFUlZJQ08iXX0sInNjb3BlIjoiIiwic2VnbWVudG9fc2lzdGVtYSI6IjExMTUiLCJjbGllbnRIb3N0IjoiMTg5LjEwOS4yMTYuMTAiLCJjbGllbnRJZCI6ImNsaS1zZXItbmJjIiwic2VydmljZV91c2VybmFtZSI6IlNJQkNTMDFEIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LWNsaS1zZXItbmJjIiwiY2xpZW50QWRkcmVzcyI6IjE4OS4xMDkuMjE2LjEwIiwiZW1haWwiOiJzZXJ2aWNlLWFjY291bnQtY2xpLXNlci1uYmNAcGxhY2Vob2xkZXIub3JnIn0.FYMxYmMV_S9J2QwlEFSoa9jcwrZ-QNuqioi8Tnu5PY7mEfwwqa-X2BmTmPV0mFYCgABsfiwuAonuADkm1SQRCEdqtGqmBhyq0NflDo1GE1g1nfC5w4oHHL3Gg-3PV67HMjheFSn1_ACDCsbyawh7BFZQY3_5WmioHVMi0oSs7njAr_IOOeIV7Q-M_R1AMGqL2gVcme0D-rwlF42kPfy3pJn_MTBZegtVaMfI6qhC793mCs3ixD6gLW8d6LXEx2TJf00KAIJCX6Rtvu85kJgxq1KlnvVQcyyp25gND7GWagm2rLwWYawcrbptFgPIWrS75m7Y8QN-9-LZkRKNPoFhcA";
	
	
	@BeforeEach
	public void inicializarDados() throws ControleException, SQLException {
		if (!URI.contains("localhost")) {
			token = RequisicaoHTTP
					.gerarToken(TipoGeracaoToken.NOVO_TOKEN, ClientID.SIMTX.getId(), ClientID.SIMTX.getSecret())
					.getAccessToken();
		}

		this.connection = Conexao.obterConexao();
	}
	
	@AfterEach
	public void finalizarTestes() throws SQLException {
		if(this.connection != null) {
			this.connection.close();
		}
	}
	
	public String executarRequisicao(String path, String token, String meioEntrada, String dadosAntiFraude,
			int statusEsperado, int qtdeDiasDtEfetivacao) {
		if(UTILIZARHTTP) {
			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/").concat(path));
			jsonPagamento = jsonPagamento.replace("{IDFIMAFIM}", idFimAFim);
			jsonPagamento = jsonPagamento.replace("{DATAHORA}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON).concat("Z"));
			jsonPagamento = jsonPagamento.replace("{DATAEFETIVACAO}", DataUtil
					.getDataFormatada(DataUtil.obterDataFutura(qtdeDiasDtEfetivacao), DataUtil.FORMATO_DATA_XML));
			
			ClientResponse resposta = RequisicaoHTTP.requestPostApi(URI, token, jsonPagamento, meioEntrada, dadosAntiFraude);
			assertNotNull(Constantes.SEM_RESPOSTA_HTTP, resposta);
			assertEquals(Constantes.RESPOSTA_DIVERGENTE_HTTP + resposta.getStatus() + "] " + resposta, statusEsperado,
					resposta.getStatus());

			return resposta.getEntity(String.class);
		}
		else {
			path = path.replace(".json", "_curl.json");

			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/").concat(path));
			jsonPagamento = jsonPagamento.replace("{URI}", URI);
			jsonPagamento = jsonPagamento.replace("{TOKEN}", tokenTransacao);
			jsonPagamento = jsonPagamento.replace("{MEIOENTRADA}", meioEntrada);
			jsonPagamento = jsonPagamento.replace("{ANTIFRAUDE}", dadosAntiFraude);
			jsonPagamento = jsonPagamento.replace("{IDFIMAFIM}", idFimAFim);
			jsonPagamento = jsonPagamento.replace("{DATAHORA}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON).concat("Z"));
			jsonPagamento = jsonPagamento.replace("{DATAEFETIVACAO}", DataUtil
					.getDataFormatada(DataUtil.obterDataFutura(qtdeDiasDtEfetivacao), DataUtil.FORMATO_DATA_XML));

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
	void validarSICCO() throws ControleException {
		String url = "https://des.barramento.caixa/sibar/corporativo/administrativo/v1/bancos?situacao=ATIVOS";
		String usuario = "smtxsd01";
		String encoded = DatatypeConverter.printBase64Binary((usuario.concat(":123")).getBytes());

		RespostaHTTP resposta = RequisicaoHTTP.realizarEnvioHttps(url, "",
				PropriedadesHTTP.METODO_GET, 
				new PropriedadesHTTP("Content-Type", "application/json"),
				new PropriedadesHTTP("Accept-Encoding", "gzip,deflate"),
				new PropriedadesHTTP("Authorization", "Basic "+encoded),
				new PropriedadesHTTP("Connection", "Keep-Alive"),
				new PropriedadesHTTP("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)"));
		System.out.println(resposta.getMensagem());
	}

	@Test
	void validarSICCO2() throws ControleException, ParseException, IOException {
		String url = "http://des.barramento.caixa/sibar/corporativo/administrativo/v1/bancos?situacao=ATIVOS";
		String usuario = "smtxsd01";
		String encoded = DatatypeConverter.printBase64Binary((usuario.concat(":123")).getBytes());

		HttpResponse retorno = RequisicaoHTTP.requestGet(url, "",
				10000,
				new PropriedadesHTTP("Authorization", "Basic "+encoded));
		String resposta = EntityUtils.toString(retorno.getEntity(), "UTF-8");
		System.out.println(resposta);
	}

	@Test
	void testIBCSucesso() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
		tarefas.add(100110l);
		tarefas.add(100113l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada, dadosAntiFraude, Response.Status.CREATED.getStatusCode(), 2);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaAgendamentoPixV1VO respostasPixVO = mapper.readerFor(RespostaAgendamentoPixV1VO.class).readValue(saida);

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuTransacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 1, transacao.getIcSituacao());

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
		}

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(respostasPixVO.getNsuTransacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento);
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 1, transacaoAgendamento.getIcSituacaoAgendamento());
		assertNotNull(Constantes.VALOR_NULO_TB34, transacaoAgendamento.getValorTransacao());
		assertFalse(Constantes.VALOR_NULO_TB34, transacaoAgendamento.getValorTransacao().intValue() <= 0);
		assertNotNull(Constantes.IDENTIFICACAO_NULO_TB34, transacaoAgendamento.getDeIdentificacaoTransacao());
		assertFalse(Constantes.IDENTIFICACAO_NULO_TB34, transacaoAgendamento.getDeIdentificacaoTransacao().isEmpty());
	}

	@Test
	void testNBMSucesso() throws IOException {
		try {
			String pathTeste001 = "V1/todosCampos.json";
			List<Long> tarefas = new ArrayList<>();
			tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
			tarefas.add(100116l);
	
			String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("token_transacao/dados.json"));
			meioEntrada = codificaBase64(meioEntrada);
	
			String saida = executarRequisicao(pathTeste001, tokenTransacao, meioEntrada, dadosAntiFraude,
					Response.Status.CREATED.getStatusCode(), 1);
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
				assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS,
						listTarefas.get(i).getDeXmlRequisicao().contains("null"));
			}
			
			TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(respostasPixVO.getNsuTransacao(), this.connection);
			assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento);
			assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 1, transacaoAgendamento.getIcSituacaoAgendamento());
			assertNotNull(Constantes.VALOR_NULO_TB34, transacaoAgendamento.getValorTransacao());
			assertFalse(Constantes.VALOR_NULO_TB34, transacaoAgendamento.getValorTransacao().intValue() <= 0);
		} 
		catch (ControleException e) {
			assertTrue(e.getMensagem(), e.getMensagem().isEmpty());
		}
	}

	@Test
	void testCPFDiferenteConta() throws IOException, ControleException {
		String pathTeste001 = "V1/cpfDiferenteConta.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100116l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("token_transacao/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("pagamento/").concat(pathTeste001));
		jsonPagamento = jsonPagamento.replace("{IDFIMAFIM}", idFimAFim);
		jsonPagamento = jsonPagamento.replace("{DATAHORA}",
				DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));

		String saida = executarRequisicao(pathTeste001, pathTeste001, meioEntrada, jsonPagamento, Response.Status.CREATED.getStatusCode(), 1);
		
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
			assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS,
					listTarefas.get(i).getDeXmlRequisicao().contains("null"));
		}
	}
	
	/**
	 * Verifica se o Sistema nao esta permitindo agendar para o mesmo dia.
	 */
	@Test
	void testDtEfetivacaoMesmoDia() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada, dadosAntiFraude, Response.Status.BAD_REQUEST.getStatusCode(), 0);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaErroSIMTX erroSIMTX = mapper.readerFor(RespostaErroSIMTX.class).readValue(saida);
		assertTrue(Constantes.MSG_NEGOCIAL_DIFERENTE,
				erroSIMTX.getMensagem().getMensagemNegocial().contains("DATA INVALIDA PARA REALIZAR A TRANSACAO"));
		assertTrue(Constantes.MSG_TECNICA_DIFERENTE,
				erroSIMTX.getMensagem().getMensagemTecnica().contains("DATA DEVE SER MAIOR QUE DATA ATUAL E INFERIOR A 548 DIAS"));

		Transacao transacao = tabelas.possuiTransacao(erroSIMTX.getNsu(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 2, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(erroSIMTX.getNsu(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(erroSIMTX.getNsu(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(erroSIMTX.getNsu(), this.connection);
		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(erroSIMTX.getNsu(), this.connection);
		assertNull(Constantes.N_DEVE_TER_REGISTRO_TB34, transacaoAgendamento);
	}
	
	/**
	 * Verifica se o Sistema esta validando a data limite para um agendamento.
	 * O limite é de 540 dias. 
	 */
	@Test
	void testDtEfetivacaoMaiorQueLimite() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada, dadosAntiFraude,  Response.Status.BAD_REQUEST.getStatusCode(), 549);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaErroSIMTX erroSIMTX = mapper.readerFor(RespostaErroSIMTX.class).readValue(saida);
		assertTrue(Constantes.MSG_NEGOCIAL_DIFERENTE,
				erroSIMTX.getMensagem().getMensagemNegocial().contains("DATA INVALIDA PARA REALIZAR A TRANSACAO"));
		assertTrue(Constantes.MSG_TECNICA_DIFERENTE,
				erroSIMTX.getMensagem().getMensagemTecnica().contains("DATA DEVE SER INFERIOR A 548 DIAS"));

		Transacao transacao = tabelas.possuiTransacao(erroSIMTX.getNsu(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 2, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(erroSIMTX.getNsu(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(erroSIMTX.getNsu(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(erroSIMTX.getNsu(), this.connection);
		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(erroSIMTX.getNsu(), this.connection);
		assertNull(Constantes.N_DEVE_TER_REGISTRO_TB34, transacaoAgendamento);
	}
	
	@Test
	void testComTarefaQrCode() throws IOException {
		String pathTeste001 = "V1/comQrCode.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
		tarefas.add(100132l);
		tarefas.add(100110l);
		tarefas.add(100113l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada, dadosAntiFraude, Response.Status.CREATED.getStatusCode(), 1);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaAgendamentoPixV1VO respostasPixVO = mapper.readerFor(RespostaAgendamentoPixV1VO.class).readValue(saida);

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuTransacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 1, transacao.getIcSituacao());

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
		}

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(respostasPixVO.getNsuTransacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento);
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 1, transacaoAgendamento.getIcSituacaoAgendamento());
		assertNotNull(Constantes.VALOR_NULO_TB34, transacaoAgendamento.getValorTransacao());
		assertFalse(Constantes.VALOR_NULO_TB34, transacaoAgendamento.getValorTransacao().intValue() <= 0);
		assertNotNull(Constantes.IDENTIFICACAO_NULO_TB34, transacaoAgendamento.getDeIdentificacaoTransacao());
		assertFalse(Constantes.IDENTIFICACAO_NULO_TB34, transacaoAgendamento.getDeIdentificacaoTransacao().isEmpty());
	}	

}
