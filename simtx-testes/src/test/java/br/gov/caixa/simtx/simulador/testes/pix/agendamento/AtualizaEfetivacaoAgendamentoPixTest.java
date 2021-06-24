package br.gov.caixa.simtx.simulador.testes.pix.agendamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoAgendamento;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.http.ClientID;
import br.gov.caixa.simtx.simulador.util.http.RequisicaoHTTP;
import br.gov.caixa.simtx.simulador.util.http.TipoGeracaoToken;
import br.gov.caixa.simtx.simulador.util.ssh.RequisicaoSSH;

public class AtualizaEfetivacaoAgendamentoPixTest extends BaseTeste {
	
	private Connection connection;
	
	private static final boolean UTILIZARHTTP = true;
	
	private static final Long NSU_TRANSACAO = 1000025483L;
	
	private static final String PATH = "pix/";
	
//	private static final String URI = "https://simtx.pagamentopix.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx02.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx03.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
	private static final String URI = "http://localhost:8080/pagamento-instantaneo-api/v1/efetivacao";
	
	private static final Long[] TAREFAS_NEGOCIAIS = { 100109l };
	
	private String token;
	
	
	@Before
	public void inicializarDados() throws ControleException, SQLException {
		token = RequisicaoHTTP
				.gerarToken(TipoGeracaoToken.NOVO_TOKEN, ClientID.SIMTX.getId(), ClientID.SIMTX.getSecret())
				.getAccessToken();

		this.connection = Conexao.obterConexao();
	}
	
	@After
	public void finalizarTestes() throws SQLException {
		if(this.connection != null) {
			this.connection.close();
		}
	}
	
	public String executarRequisicao(String path, String token) {
		if(UTILIZARHTTP) {
			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/atualizacao/").concat(path));
			jsonPagamento = jsonPagamento.replace("{NSUTRANSACAO}", NSU_TRANSACAO.toString());
			
			ClientResponse resposta = RequisicaoHTTP.requestPutApi(URI, token, jsonPagamento);
			assertNotNull(Constantes.SEM_RESPOSTA_HTTP, resposta);

			String saida = resposta.getEntity(String.class);
			assertEquals(Constantes.RESPOSTA_DIVERGENTE_HTTP + resposta.getStatus() + "] " + saida,
					Response.Status.OK.getStatusCode(), resposta.getStatus());
			return saida;
		}
		else {
			path = path.replace(".json", "_curl.json");

			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/atualizacao/").concat(path));
			jsonPagamento = jsonPagamento.replace("{URI}", URI);
			jsonPagamento = jsonPagamento.replace("{NSUTRANSACAO}", NSU_TRANSACAO.toString());

			String resposta = RequisicaoSSH.requisicao(jsonPagamento);
			assertNotNull(Constantes.SEM_RESPOSTA, resposta);
			assertFalse(Constantes.SEM_RESPOSTA, resposta.isEmpty());
			assertFalse(Constantes.SEM_RESPOSTA, resposta.contains("404 Not Found"));

			try {
				RespostaErroSIMTX erroSIMTX = mapper.readerFor(RespostaErroSIMTX.class).readValue(resposta);

				assertEquals(Constantes.RESPOSTA_IMPEDITIVA_HTTP + erroSIMTX.getCodigoRetorno() + "] " + resposta,
						Response.Status.BAD_REQUEST.getStatusCode(), erroSIMTX.getCodigoRetorno());
			} 
			catch (IOException e) {
				return resposta;
			}
			return resposta;
		}
	}

	@Test
	public void testSucesso() throws InterruptedException {
		String pathTeste001 = "V1/sucesso.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));

		executarRequisicao(pathTeste001, token);
		Thread.sleep(3000);

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(NSU_TRANSACAO, this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento.getNuNsuEfetivacao());
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 6, transacaoAgendamento.getIcSituacaoAgendamento());

		Transacao transacao = tabelas.possuiTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 3, transacao.getIcSituacao());
		assertNotNull("Campo CO_TRANSACAO_EXTERNO deve conter o IDFIMAFIM", transacao.getCoTransacaoExterna());
		assertFalse("Campo CO_TRANSACAO_EXTERNO deve conter o IDFIMAFIM", transacao.getCoTransacaoExterna().isEmpty());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(transacaoAgendamento.getNuNsuEfetivacao(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, tarefas.size(), listTarefas.size());
		for (int i = 0; i < listTarefas.size(); i++) {
			assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
					tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
			assertFalse(Constantes.JSON_TAREFAS_CONTEM_CAMPOS_NULOS,
					listTarefas.get(i).getDeXmlRequisicao().contains("null"));
			assertTrue("Campo prioridadePagamento deve ser NORM",
					listTarefas.get(i).getDeXmlRequisicao().contains("\"prioridadePagamento\":\"NORM\""));
			assertTrue("Campo tipoPrioridadePagamento deve ser PAGAGD",
					listTarefas.get(i).getDeXmlRequisicao().contains("\"tipoPrioridadePagamento\":\"PAGAGD\""));
		}
	}
	
	@Test
	public void testSemCamposObrigatorios() {
		
	}
	
	@Test
	public void testDominioNaoPermitido() {
		
	}
	
	
	@Test
	public void testClientIdNaoPermitido() {
		
	}
	
	/**
	 * O sistema pode permitir atualizacao se o status for igual a Situacao da Transacao Finalizada.
	 */
	@Test
	public void testTransacaoFinalizada() {
		
	}
	
	
	/**
	 * O sistema nao pode permitir atualizacao com status diferente da Situacao da Transacao.
	 */
	@Test
	public void testStatusDiferenteSituacaoTransacao() {
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testRJCT() {
		String pathTeste001 = "V1/erroNegocial.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));

		String saida = executarRequisicao(pathTeste001, token);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));
		
//		RespostaPixV1VO respostasPixVO = mapper.readerFor(RespostaPixV1VO.class).readValue(saida);
//		validarAtributosCampos(respostasPixVO);

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(NSU_TRANSACAO, this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento.getNuNsuEfetivacao());
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 4, transacaoAgendamento.getIcSituacaoAgendamento());

		Transacao transacao = tabelas.possuiTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 2, transacao.getIcSituacao());
		assertEquals("NSU do Agendamento deve ser o NSU Origem da Transacao Atual", NSU_TRANSACAO,
				transacao.getNsuTransacaoOrigem());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(transacaoAgendamento.getNuNsuEfetivacao(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, tarefas.size(), listTarefas.size());
		for (int i = 0; i < listTarefas.size(); i++) {
			assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
					tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
		}
	}
	
	/**
	 * Deve ser realizada mais de uma tentativa de efetivação de agendamento de Pix caso ocorra erro no simtx ou
	 * de infraestrutura.
	 */
	@Test
	public void testHOLD() {
		String pathTeste001 = "V1/erroInterno.json";
		List<Long> tarefas = new ArrayList<>();
		tarefas.addAll(Arrays.asList(TAREFAS_NEGOCIAIS));

		String saida = executarRequisicao(pathTeste001, token);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));
		
//		RespostaPixV1VO respostasPixVO = mapper.readerFor(RespostaPixV1VO.class).readValue(saida);
//		validarAtributosCampos(respostasPixVO);

		TransacaoAgendamento transacaoAgendamento = tabelas.possuiTransacaoAgendamento(NSU_TRANSACAO, this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB34, transacaoAgendamento.getNuNsuEfetivacao());
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, 1, transacaoAgendamento.getIcSituacaoAgendamento());

		Transacao transacao = tabelas.possuiTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 2, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(transacaoAgendamento.getNuNsuEfetivacao(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection));

		List<Tarefa> listTarefas = tabelas.possuiTarefasTransacao(transacaoAgendamento.getNuNsuEfetivacao(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB15, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB15, tarefas.size(), listTarefas.size());
		for (int i = 0; i < listTarefas.size(); i++) {
			assertTrue(Constantes.TAREFA_GRAVADA_ERRADA,
					tarefas.contains(Long.valueOf(listTarefas.get(i).getNuTarefa())));
		}
	}
	
}
