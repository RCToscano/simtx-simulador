package br.gov.caixa.simtx.simulador.testes.pix.agendamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import br.gov.caixa.simtx.simulador.testes.banco.Conexao;
import br.gov.caixa.simtx.simulador.testes.base.BaseTeste;
import br.gov.caixa.simtx.simulador.testes.base.Constantes;
import br.gov.caixa.simtx.simulador.testes.base.RespostaErroSIMTX;
import br.gov.caixa.simtx.simulador.testes.pix.RespostaPixV1VO;
import br.gov.caixa.simtx.simulador.testes.pix.agendamento.vo.RespostaCancelamentoAgendamentoPixV1VO;
import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoAgendamento;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.http.RequisicaoHTTP;
import br.gov.caixa.simtx.simulador.util.ssh.RequisicaoSSH;

public class CancelamentoAgendamentoPixTest extends BaseTeste {
	
	private Connection connection;
	
	private static final boolean UTILIZARHTTP = true;
	
	private static final String PATH = "pix/";
	
	private static final String DATAEFETIVACAO = "2021-06-21";
	
	private static final String NSUTRANSACAO = "123";
	
//	private static final String URI = "https://simtx.pagamentopix.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx02.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx03.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
	private static final String URI = "http://localhost:8080/pagamento-instantaneo-agendado-api/v1/agendamentos/{NSUTRANSACAO}/cancelar";
	
	private static final Long[] TAREFAS_NEGOCIAIS = { 100133l, 100131l };
	
	private String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJvbGczaGJWRU0zX2dSdDFEZHBYTXdPWHRTLUUyTVFRRGIwQmh3Nkl2WmRvIn0.eyJqdGkiOiJhZGQzODI3YS1hMGExLTQ5N2EtODU4YS1iZjZmMzgxNTE5NGQiLCJleHAiOjE2MjM5Njg2ODksIm5iZiI6MCwiaWF0IjoxNjIzOTY3Nzg5LCJpc3MiOiJodHRwczovL2xvZ2luZGVzLmNhaXhhLmdvdi5ici9hdXRoL3JlYWxtcy9pbnRlcm5ldCIsInN1YiI6IjY5OGJlOTk2LWMxYmItNGIxOC05ZDZjLTdhYmY0ZTY0ZWIyZiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsaS1zZXItbmJjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMWNkMGJhMTQtNjVjYi00YjhiLTkzZTktMmE4MGEwZTFlY2M1IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJCUkpfU0ZHX1NBUVVFX0VNRVJHRU5DSUFMX0FQSSIsIkJSSl9TRkdfU0FRVUVfRElHSVRBTF9BUEkiLCJCUkpfSVNPX1BFU1NPQV9OQVRVUkFMX0FQSSIsIkJSSl9TRkdfSU5GT1JNQUNPRVNfRkdUU19BUEkiLCJTUElfRENUIiwiSEFCX0NPTlRSQVRPU19TRVJWIiwidW1hX2F1dGhvcml6YXRpb24iLCJTSU5CQy1QVVNILUFUSVZPIiwiRkVDX0NBTkFMX1RPS0VOX1NFUlZJQ08iXX0sInNjb3BlIjoiIiwic2VnbWVudG9fc2lzdGVtYSI6IjExMTUiLCJjbGllbnRIb3N0IjoiMTg5LjEwOS4yMTYuMTAiLCJjbGllbnRJZCI6ImNsaS1zZXItbmJjIiwic2VydmljZV91c2VybmFtZSI6IlNJQkNTMDFEIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LWNsaS1zZXItbmJjIiwiY2xpZW50QWRkcmVzcyI6IjE4OS4xMDkuMjE2LjEwIiwiZW1haWwiOiJzZXJ2aWNlLWFjY291bnQtY2xpLXNlci1uYmNAcGxhY2Vob2xkZXIub3JnIn0.FYMxYmMV_S9J2QwlEFSoa9jcwrZ-QNuqioi8Tnu5PY7mEfwwqa-X2BmTmPV0mFYCgABsfiwuAonuADkm1SQRCEdqtGqmBhyq0NflDo1GE1g1nfC5w4oHHL3Gg-3PV67HMjheFSn1_ACDCsbyawh7BFZQY3_5WmioHVMi0oSs7njAr_IOOeIV7Q-M_R1AMGqL2gVcme0D-rwlF42kPfy3pJn_MTBZegtVaMfI6qhC793mCs3ixD6gLW8d6LXEx2TJf00KAIJCX6Rtvu85kJgxq1KlnvVQcyyp25gND7GWagm2rLwWYawcrbptFgPIWrS75m7Y8QN-9-LZkRKNPoFhcA";
	
	private String tokenTransacao = "";
	
	private String dadosAntiFraude;
	
	
	@Before
	public void inicializarDados() throws ControleException, SQLException {
//		token = RequisicaoHTTP
//				.gerarToken(TipoGeracaoToken.NOVO_TOKEN, ClientID.SINBC.getId(), ClientID.SINBC.getSecret())
//				.getAccessToken();

//		String comando = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("token_transacao/curl.json"));
//
//		String tokenSaida = RequisicaoSSH.requisicao(comando);
//		assertNotNull(Constantes.ERRO_GERAR_TOKEN, tokenSaida);
//		assertTrue(Constantes.ERRO_GERAR_TOKEN, tokenSaida.contains("token"));
//
//		TokenTransacaoSaida tokenTransacaoSaida = gson.fromJson(tokenSaida, TokenTransacaoSaida.class);
//		tokenTransacao = tokenTransacaoSaida.getToken();

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
	
	public String executarRequisicao(String path, String token, String meioEntrada) {
		if(UTILIZARHTTP) {
			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/cancelamento/").concat(path));
			
			ClientResponse resposta = RequisicaoHTTP.requestPostApi(URI.replace("{NSUTRANSACAO}", NSUTRANSACAO), token,
					jsonPagamento, meioEntrada, "");
			assertNotNull(Constantes.SEM_RESPOSTA_HTTP, resposta);

			return resposta.getEntity(String.class);
		}
		else {
			path = path.replace(".json", "_curl.json");

			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/cancelamento/").concat(path));
			jsonPagamento = jsonPagamento.replace("{URI}", URI);
			jsonPagamento = jsonPagamento.replace("{TOKEN}", tokenTransacao);
			jsonPagamento = jsonPagamento.replace("{MEIOENTRADA}", meioEntrada);
			jsonPagamento = jsonPagamento.replace("{DATAEFETIVACAO}", DATAEFETIVACAO);

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
	public void testIBCSucesso() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));
		tarefas.add(100110l);
		tarefas.add(100113l);

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaCancelamentoAgendamentoPixV1VO respostasPixVO = mapper.readerFor(RespostaCancelamentoAgendamentoPixV1VO.class).readValue(saida);

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuCancelamento(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 1, transacao.getIcSituacao());
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, NSUTRANSACAO, respostasPixVO.getNsuTransacao().toString());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(respostasPixVO.getNsuCancelamento(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(respostasPixVO.getNsuCancelamento(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(respostasPixVO.getNsuCancelamento(), this.connection);
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
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 3, transacaoAgendamento.getIcSituacaoAgendamento());
	}
	
	@Test
	public void testSegurancaSucesso() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaCancelamentoAgendamentoPixV1VO respostasPixVO = mapper.readerFor(RespostaCancelamentoAgendamentoPixV1VO.class).readValue(saida);

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuCancelamento(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 1, transacao.getIcSituacao());
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, NSUTRANSACAO, respostasPixVO.getNsuTransacao().toString());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(respostasPixVO.getNsuCancelamento(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(respostasPixVO.getNsuCancelamento(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(respostasPixVO.getNsuCancelamento(), this.connection);
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
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 3, transacaoAgendamento.getIcSituacaoAgendamento());
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
	
			String saida = executarRequisicao(pathTeste001, tokenTransacao, meioEntrada);
			assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS + saida, saida.contains("null"));
	
			RespostaPixV1VO respostasPixVO = mapper.readerFor(RespostaPixV1VO.class).readValue(saida);
			validarAtributosCampos(respostasPixVO);
	
			Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsuTransacao(), this.connection);
			assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
			assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 1, transacao.getIcSituacao());
			assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, NSUTRANSACAO, respostasPixVO.getNsuTransacao().toString());
	
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

	/**
	 * Verifica se o Sistema devolve msg corretamente qnd nao existe o NSU.
	 */
	@Test
	public void testNsuNaoEncontrado() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));

		String meioEntrada = recuperarJson(BASE_PATH_JSON.concat(PATH_MEIO_ENTRADA).concat("assinatura_simples/dados.json"));
		meioEntrada = codificaBase64(meioEntrada);

		String saida = executarRequisicao(pathTeste001, token, meioEntrada);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaErroSIMTX erroSIMTX = mapper.readerFor(RespostaErroSIMTX.class).readValue(saida);
		assertTrue(Constantes.MSG_NEGOCIAL_DIFERENTE,
				erroSIMTX.getMensagem().getMensagemNegocial().contains("AGENDAMENTO NAO ENCONTRADO"));
		assertTrue(Constantes.MSG_TECNICA_DIFERENTE,
				erroSIMTX.getMensagem().getMensagemTecnica().contains("AGENDAMENTO NAO ENCONTRADO"));

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
	 * Deve permitir cancelar ate um dia antes.
	 */
	@Test
	public void testIBCDMenosUm() throws IOException {
		
	}
	
	/**
	 * Nao deve permitir cancelamento no mesmo dia da data de efetivacao.
	 */
	@Test
	public void testIBCMesmoDia() throws IOException {
		
	}
	
	/**
	 * Canal Seguranca (120) deve permitir cancelamento no mesmo dia da data de efetivacao.
	 */
	@Test
	public void testSegurancaMesmoDia() throws IOException {
		
	}
	
	
}
