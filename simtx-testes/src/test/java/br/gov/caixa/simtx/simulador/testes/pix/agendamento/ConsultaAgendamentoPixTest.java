package br.gov.caixa.simtx.simulador.testes.pix.agendamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import br.gov.caixa.simtx.simulador.testes.banco.Conexao;
import br.gov.caixa.simtx.simulador.testes.base.BaseTeste;
import br.gov.caixa.simtx.simulador.testes.base.Constantes;
import br.gov.caixa.simtx.simulador.testes.base.RespostaErroSIMTX;
import br.gov.caixa.simtx.simulador.testes.pix.agendamento.vo.RespostaConsultaAgendamentoPixV1VO;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.http.RequisicaoHTTP;
import br.gov.caixa.simtx.simulador.util.ssh.RequisicaoSSH;


class ConsultaAgendamentoPixTest extends BaseTeste {
	
	private Connection connection;
	
	private static final boolean UTILIZARHTTP = true;
	
	private static final String PATH = "pix/";
	
//	private static final String URI = "https://simtx.pagamentopix.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx02.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx03.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
//	private static final String URI = "https://simtx.webservices.des.caixa/pagamentos-instantaneos/v1/pagamentos";
	private static final String URI = "http://localhost:8080/pagamento-instantaneo-agendado-api/v1/agendamentos/";
	
	private String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJvbGczaGJWRU0zX2dSdDFEZHBYTXdPWHRTLUUyTVFRRGIwQmh3Nkl2WmRvIn0.eyJqdGkiOiJhZGQzODI3YS1hMGExLTQ5N2EtODU4YS1iZjZmMzgxNTE5NGQiLCJleHAiOjE2MjM5Njg2ODksIm5iZiI6MCwiaWF0IjoxNjIzOTY3Nzg5LCJpc3MiOiJodHRwczovL2xvZ2luZGVzLmNhaXhhLmdvdi5ici9hdXRoL3JlYWxtcy9pbnRlcm5ldCIsInN1YiI6IjY5OGJlOTk2LWMxYmItNGIxOC05ZDZjLTdhYmY0ZTY0ZWIyZiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsaS1zZXItbmJjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMWNkMGJhMTQtNjVjYi00YjhiLTkzZTktMmE4MGEwZTFlY2M1IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJCUkpfU0ZHX1NBUVVFX0VNRVJHRU5DSUFMX0FQSSIsIkJSSl9TRkdfU0FRVUVfRElHSVRBTF9BUEkiLCJCUkpfSVNPX1BFU1NPQV9OQVRVUkFMX0FQSSIsIkJSSl9TRkdfSU5GT1JNQUNPRVNfRkdUU19BUEkiLCJTUElfRENUIiwiSEFCX0NPTlRSQVRPU19TRVJWIiwidW1hX2F1dGhvcml6YXRpb24iLCJTSU5CQy1QVVNILUFUSVZPIiwiRkVDX0NBTkFMX1RPS0VOX1NFUlZJQ08iXX0sInNjb3BlIjoiIiwic2VnbWVudG9fc2lzdGVtYSI6IjExMTUiLCJjbGllbnRIb3N0IjoiMTg5LjEwOS4yMTYuMTAiLCJjbGllbnRJZCI6ImNsaS1zZXItbmJjIiwic2VydmljZV91c2VybmFtZSI6IlNJQkNTMDFEIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LWNsaS1zZXItbmJjIiwiY2xpZW50QWRkcmVzcyI6IjE4OS4xMDkuMjE2LjEwIiwiZW1haWwiOiJzZXJ2aWNlLWFjY291bnQtY2xpLXNlci1uYmNAcGxhY2Vob2xkZXIub3JnIn0.FYMxYmMV_S9J2QwlEFSoa9jcwrZ-QNuqioi8Tnu5PY7mEfwwqa-X2BmTmPV0mFYCgABsfiwuAonuADkm1SQRCEdqtGqmBhyq0NflDo1GE1g1nfC5w4oHHL3Gg-3PV67HMjheFSn1_ACDCsbyawh7BFZQY3_5WmioHVMi0oSs7njAr_IOOeIV7Q-M_R1AMGqL2gVcme0D-rwlF42kPfy3pJn_MTBZegtVaMfI6qhC793mCs3ixD6gLW8d6LXEx2TJf00KAIJCX6Rtvu85kJgxq1KlnvVQcyyp25gND7GWagm2rLwWYawcrbptFgPIWrS75m7Y8QN-9-LZkRKNPoFhcA";
	
	private static final String DATA_EFETIVACAO = "2021-06-19";
	
	
	@BeforeEach
	public void inicializarDados() throws ControleException, SQLException {
//		token = RequisicaoHTTP
//				.gerarToken(TipoGeracaoToken.NOVO_TOKEN, ClientID.SINBC.getId(), ClientID.SINBC.getSecret())
//				.getAccessToken();
		this.connection = Conexao.obterConexao();
	}
	
	@AfterEach
	public void finalizarTestes() throws SQLException {
		if(this.connection != null) {
			this.connection.close();
		}
	}
	
	public String executarRequisicao(String path, String token, String nsuTransacao, MultivaluedMap<String, String> param) {
		if(UTILIZARHTTP) {
			ClientResponse resposta = RequisicaoHTTP.requestGetApi(URI.concat(nsuTransacao), token, param);
			assertNotNull(Constantes.SEM_RESPOSTA_HTTP, resposta);

			return resposta.getEntity(String.class);
		}
		else {
			path = path.replace(".json", "_curl.json");

			String jsonPagamento = recuperarJson(BASE_PATH_JSON.concat(PATH).concat("agendamento/").concat(path));

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

	@ParameterizedTest
	@CsvSource({
        "212, AGENDADO",
        "195, EFETIVADO",
        "193, CANCELADO",
        "192, NEGADO",
        "190, PROCESSANDO",
    })
	void testSituacoes(String nsu, String situacao) throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		
		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("dataTransacao", DATA_EFETIVACAO);

		String saida = executarRequisicao(pathTeste001, token, nsu, param);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaConsultaAgendamentoPixV1VO respostasPixVO = mapper.readerFor(RespostaConsultaAgendamentoPixV1VO.class).readValue(saida);
		assertEquals(Constantes.SITUACAO_TB34_DIVERGENTE, situacao, respostasPixVO.getSituacaoTransacao());
	}
	
	/**
	 * Verifica se o Sistema devolve msg de nsu nao encontrado
	 */
	@Test
	void testNsuInexistente() throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		
		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("dataTransacao", DATA_EFETIVACAO);

		String saida = executarRequisicao(pathTeste001, token, "123", param);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));

		RespostaErroSIMTX respostasPixVO = mapper.readerFor(RespostaErroSIMTX.class).readValue(saida);
		assertTrue(Constantes.MSG_NEGOCIAL_DIFERENTE,
				respostasPixVO.getMensagem().getMensagemNegocial().contains("AGENDAMENTO NAO ENCONTRADO"));

		Transacao transacao = tabelas.possuiTransacao(respostasPixVO.getNsu(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB14, transacao);
		assertEquals(Constantes.SITUACAO_TB14_DIVERGENTE, 2, transacao.getIcSituacao());

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB16,
				tabelas.possuiIteracaoCanal(respostasPixVO.getNsu(), this.connection));

		assertTrue(Constantes.REGISTRO_N_ENCONTRADO_TB17,
				tabelas.possuiServicoTransacao(respostasPixVO.getNsu(), this.connection));
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "2021-06-"})
	void testDataInvalida(String data) throws IOException {
		String pathTeste001 = "V1/todosCampos.json";
		
		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("dataTransacao", data);
		
		String saida = executarRequisicao(pathTeste001, token, "123", param);
		assertFalse(Constantes.RESPOSTA_CONTEM_CAMPOS_NULOS, saida.contains("null"));
		
		RespostaErroSIMTX respostasPixVO = mapper.readerFor(RespostaErroSIMTX.class).readValue(saida);
		assertTrue(Constantes.MSG_TECNICA_DIFERENTE,
				respostasPixVO.getMensagem().getMensagemTecnica().contains("dataTransacao invalida"));
	}
	
	
}
