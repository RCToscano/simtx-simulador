package br.gov.caixa.simtx.simulador.testes.xml.sicco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;

import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.gov.caixa.simtx.simulador.testes.banco.Conexao;
import br.gov.caixa.simtx.simulador.testes.base.BaseTeste;
import br.gov.caixa.simtx.simulador.testes.base.Constantes;
import br.gov.caixa.simtx.simulador.testes.fila.Fila;
import br.gov.caixa.simtx.simulador.testes.tabelas.TarefasSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoInterfaceSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoSicco;

@RunWith(JUnitPlatform.class)
class RecebimentoTest extends BaseTeste {

	private static final String XML_LINARIZATION_REGEX = "(>|&gt;){1,1}(\\t)*(\\n|\\r)+(\\s)*(<|&lt;){1,1}";
	private static final String XML_LINARIZATION_REPLACEMENT = "$1$5";

	private Connection connection;

	private String host = "localhost";
	private String port = "1414";
	private String manager = "QSDA";
	private String channel = "DEV.APP.SVRCONN";
	private String queueReq = "SICCO.REQ.RECEBE_INFORMACAO";


	@BeforeEach
	void inicializarDados() throws SQLException {
		this.connection = Conexao.obterConexao();
		
	}

	@AfterClass
	void fecharFilas() throws JMSException, SQLException {
		if(this.connection != null) {
			this.connection.close();
		}
		Fila.fecharFilas();
	}
	
	@Test
	void test1Boleto() throws JMSException, InterruptedException {
		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/boleto/teste1.xml");
		xml = xml.trim().replaceAll("(>+[\" \"]*)", ">");
		xml = xml.replaceAll(XML_LINARIZATION_REGEX, XML_LINARIZATION_REPLACEMENT);
		final String xmlFinal = xml;

		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();
		RecebimentoVO recebimentoVO = executarTest3Boleto(fila, xmlFinal);
		assertNotNull(recebimentoVO);
		
		Thread.sleep(5000);
		
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100043l);
		tarefas.add(100058l);
		tarefas.add(100057l);
		tarefas.add(100059l);
		tarefas.add(100073l);
		
		TransacaoSicco transacaoSicco = tabelasSicco.possuiTransacao(recebimentoVO.getNsuTransacao(),
				this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB03, transacaoSicco);

		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB09,
				tabelasSicco.possuiTransacaoXml(recebimentoVO.getNsuTransacao(), this.connection));

		List<TarefasSicco> listTarefas = tabelasSicco.possuiTarefasTransacao(recebimentoVO.getNsuTransacao(),
				this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB18, tarefas.size(), listTarefas.size());

		List<TransacaoInterfaceSicco> listaTransacaoInterfaceSicco = tabelasSicco
				.possuiTransacaoInterface(recebimentoVO.getNsuTransacao(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listaTransacaoInterfaceSicco.isEmpty());
		assertEquals(Constantes.QTDE_INTERFACES_DIVERGENTE_TB38, 2, listaTransacaoInterfaceSicco.size());
		
		for (TransacaoInterfaceSicco transacaoInterface : listaTransacaoInterfaceSicco) {
			if(transacaoInterface.getNuParametroInterface() == 2) {
				String deConteudo = transacaoInterface.getDeConteudo();
				int dv = Integer.parseInt(deConteudo.substring(684, 685));
				assertEquals(recebimentoVO.getDv(), dv);

				long conta = Long.parseLong(deConteudo.substring(672, 684));
				assertEquals(recebimentoVO.getConta(), conta);

				int produto = Integer.parseInt(deConteudo.substring(668, 672));
				assertEquals(recebimentoVO.getProduto(), produto);

				int agenciaCo = Integer.parseInt(deConteudo.substring(651, 655));
				assertEquals(recebimentoVO.getAgencia(), agenciaCo);

				int agenciaAc = Integer.parseInt(deConteudo.substring(647, 651));
				assertEquals(recebimentoVO.getAgencia(), agenciaAc);

				Long nsu2 = Long.parseLong(deConteudo.substring(632, 647));
				assertEquals(recebimentoVO.getNsuTransacao(), nsu2);

				BigDecimal valor = new BigDecimal(deConteudo.substring(591, 604));
				assertEquals(recebimentoVO.getValor(), valor);

				String codBarras = deConteudo.substring(179, 223);
				assertEquals(recebimentoVO.getCodBarras(), codBarras);

				Long nsu = Long.parseLong(deConteudo.substring(23, 27));
				assertEquals(recebimentoVO.getNsuTransacao(), nsu);

				Long cpf = Long.parseLong(deConteudo.substring(462, 473));
				assertEquals(recebimentoVO.getCpf(), cpf);
			}
		}
	}
	
	@Test
	void test2Boleto() throws JMSException {
		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/boleto/teste1.xml");
		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();

		for (int i = 0; i < 10; i++) {
			BigDecimal nsuTransacao = tabelas.gerarNsuTransacao(this.connection);

			String xmlAux = xml.replace("{{nsuMtx}}", nsuTransacao.toString());

			String id = fila.publicar(xmlAux);
			assertNotNull(id);
		}
	}
	
	/**
	 * Envia diversas requisicoes com dados randomicos e valida 1 por 1 se os campos da tabela 38
	 * sao exatamentes os mesmos enviados.
	 * Serve como teste de stress para verificar paralelismo.
	 * Para evitar problemas de uma transacao baguncar com outra.
	 */
	@Test
	void test3Boleto() throws JMSException, InterruptedException {
		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/boleto/teste1.xml");
		xml = xml.trim().replaceAll("(>+[\" \"]*)", ">");
		xml = xml.replaceAll(XML_LINARIZATION_REGEX, XML_LINARIZATION_REPLACEMENT);
		final String xmlFinal = xml;
		
		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();
		
		List<RecebimentoVO> listaTransacoes = new ArrayList<>();

		for (int i = 0; i < 35; i++) {
			listaTransacoes.add(executarTest3Boleto(fila, xmlFinal));
		}
		
		Thread.sleep(15000);
		
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100043l);
		tarefas.add(100058l);
		tarefas.add(100057l);
		tarefas.add(100059l);
		tarefas.add(100073l);
		
		for (RecebimentoVO recebimentoVO : listaTransacoes) {
			TransacaoSicco transacaoSicco = tabelasSicco.possuiTransacao(recebimentoVO.getNsuTransacao(),
					this.connection);
			assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB03, transacaoSicco);

			assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB09,
					tabelasSicco.possuiTransacaoXml(recebimentoVO.getNsuTransacao(), this.connection));

			List<TarefasSicco> listTarefas = tabelasSicco.possuiTarefasTransacao(recebimentoVO.getNsuTransacao(),
					this.connection);
			assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listTarefas.isEmpty());
			assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB18, tarefas.size(), listTarefas.size());

			List<TransacaoInterfaceSicco> listaTransacaoInterfaceSicco = tabelasSicco
					.possuiTransacaoInterface(recebimentoVO.getNsuTransacao(), this.connection);
			assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listaTransacaoInterfaceSicco.isEmpty());
			assertEquals(Constantes.QTDE_INTERFACES_DIVERGENTE_TB38, 2, listaTransacaoInterfaceSicco.size());
			
			for (TransacaoInterfaceSicco transacaoInterface : listaTransacaoInterfaceSicco) {
				if(transacaoInterface.getNuParametroInterface() == 2) {
					String deConteudo = transacaoInterface.getDeConteudo();
					int dv = Integer.parseInt(deConteudo.substring(684, 685));
					assertEquals(recebimentoVO.getDv(), dv);

					long conta = Long.parseLong(deConteudo.substring(672, 684));
					assertEquals(recebimentoVO.getConta(), conta);

					int produto = Integer.parseInt(deConteudo.substring(668, 672));
					assertEquals(recebimentoVO.getProduto(), produto);

					int agenciaCo = Integer.parseInt(deConteudo.substring(651, 655));
					assertEquals(recebimentoVO.getAgencia(), agenciaCo);

					int agenciaAc = Integer.parseInt(deConteudo.substring(647, 651));
					assertEquals(recebimentoVO.getAgencia(), agenciaAc);

					Long nsu2 = Long.parseLong(deConteudo.substring(632, 647));
					assertEquals(recebimentoVO.getNsuTransacao(), nsu2);

					BigDecimal valor = new BigDecimal(deConteudo.substring(591, 604));
					assertEquals(recebimentoVO.getValor(), valor);

					String codBarras = deConteudo.substring(179, 223);
					assertEquals(recebimentoVO.getCodBarras(), codBarras);

					Long nsu = Long.parseLong(deConteudo.substring(23, 27));
					assertEquals(recebimentoVO.getNsuTransacao(), nsu);

					Long cpf = Long.parseLong(deConteudo.substring(462, 473));
					assertEquals(recebimentoVO.getCpf(), cpf);
				}
			}
		}
	}
	
	RecebimentoVO executarTest3Boleto(Fila fila, String xml) throws JMSException, InterruptedException {
        int dv = (int)(Math.random() * (9 - 0 + 1)) + 0;
        int produto = (int)(Math.random() * (9999 - 100 + 1)) + 100;
        long conta = (long)(Math.random() * (999999999999l - 100000 + 1)) + 100000;
        int agencia = (int)(Math.random() * (9999 - 100 + 1)) + 100;
        long cpf = (long)(Math.random() * (99999999999l - 10000000000l + 1)) + 10000000000l;
        int codBarras = (int)(Math.random() * (9999 - 1000 + 1)) + 1000;
        int valor = (int)(Math.random() * (999 - 1 + 1)) + 1;

        BigDecimal nsuTransacao = tabelas.gerarNsuTransacao(this.connection);

		String xmlAux = xml.replace("{{nsuMtx}}", nsuTransacao.toString());
		xmlAux = xmlAux.replace("{{dv}}", String.valueOf(dv));
		xmlAux = xmlAux.replace("{{produto}}", String.valueOf(produto));
		xmlAux = xmlAux.replace("{{conta}}", String.valueOf(conta));
		xmlAux = xmlAux.replace("{{agencia}}", String.valueOf(agencia));
		xmlAux = xmlAux.replace("{{cpf}}", String.valueOf(cpf));
		xmlAux = xmlAux.replace("{{codBarras}}", String.valueOf(codBarras));
		xmlAux = xmlAux.replace("{{valor}}", String.valueOf(valor));
		
		int inicio = xmlAux.lastIndexOf("<CODIGO_BARRAS>");
		int fim = xmlAux.lastIndexOf("</CODIGO_BARRAS>");
		String codgBarras = xmlAux.substring(inicio + 15, fim);

		String id = fila.publicar(xmlAux);
		assertNotNull(id);

		return new RecebimentoVO(nsuTransacao.longValue(), dv, produto, conta, agencia, cpf, codgBarras,
				new BigDecimal(valor));
		
	}
	
	@Test
	void test1MegaSena() throws JMSException, InterruptedException {
		BigDecimal nsuTransacao = tabelas.gerarNsuTransacao(this.connection);

		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/mega_sena/teste1.xml");
		xml = xml.replace("{{nsuMtx}}", nsuTransacao.toString());

		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();
		String id = fila.publicar(xml);
		assertNotNull(id);
		
		Thread.sleep(1500);
		
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100043l);
		tarefas.add(100060l);
		tarefas.add(100053l);
		tarefas.add(100067l);
		tarefas.add(100058l);
		tarefas.add(100057l);
		tarefas.add(100085l);
		
		TransacaoSicco transacaoSicco = tabelasSicco.possuiTransacao(nsuTransacao.longValue(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB03, transacaoSicco);

		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB09,
				tabelasSicco.possuiTransacaoXml(nsuTransacao.longValue(), this.connection));

		List<TarefasSicco> listTarefas = tabelasSicco.possuiTarefasTransacao(nsuTransacao.longValue(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB18, tarefas.size(), listTarefas.size());
		
	}
	
	@Test
	void test1Pix() throws JMSException, InterruptedException {
		BigDecimal nsuTransacao = tabelas.gerarNsuTransacao(this.connection);

		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/pix/teste3.xml");
		xml = xml.replace("{{nsuMtx}}", nsuTransacao.toString());

		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();
		String id = fila.publicar(xml);
		assertNotNull(id);
		
		Thread.sleep(1500);
		
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100109l);
		tarefas.add(100113l);
		tarefas.add(100121l);
		
		TransacaoSicco transacaoSicco = tabelasSicco.possuiTransacao(nsuTransacao.longValue(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB03, transacaoSicco);

		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB09,
				tabelasSicco.possuiTransacaoXml(nsuTransacao.longValue(), this.connection));

		List<TarefasSicco> listTarefas = tabelasSicco.possuiTarefasTransacao(nsuTransacao.longValue(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB18, tarefas.size(), listTarefas.size());
		
	}
	
	@Test
	void test1AgendamentoPix() throws JMSException, InterruptedException {
		BigDecimal nsuTransacao = tabelas.gerarNsuTransacao(this.connection);
		
		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/agendamento_pix/teste1.xml");
		xml = xml.replace("{{nsuMtx}}", nsuTransacao.toString());
		
		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();
		String id = fila.publicar(xml);
		assertNotNull(id);
		
		Thread.sleep(1500);
		
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100116l);
		tarefas.add(100131l);
		tarefas.add(100130l);
		tarefas.add(100143l);
		
		TransacaoSicco transacaoSicco = tabelasSicco.possuiTransacao(nsuTransacao.longValue(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB03, transacaoSicco);
		
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB09,
				tabelasSicco.possuiTransacaoXml(nsuTransacao.longValue(), this.connection));
		
		List<TarefasSicco> listTarefas = tabelasSicco.possuiTarefasTransacao(nsuTransacao.longValue(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB18, tarefas.size(), listTarefas.size());
		
	}
	
	@Test
	void test1DevolucaoPix() throws JMSException, InterruptedException {
		BigDecimal nsuTransacao = tabelas.gerarNsuTransacao(this.connection);
		
		String xml = recuperarJson(BASE_PATH_XML + "recebimento_sicco/devolucao_pix/teste1.xml");
		xml = xml.replace("{{nsuMtx}}", nsuTransacao.toString());
		
		Fila fila = Fila.getFilaRequisicao(host, port, manager, channel, queueReq);
		fila.abrir();
		String id = fila.publicar(xml);
		assertNotNull(id);
		
		Thread.sleep(1500);
		
		List<Long> tarefas = new ArrayList<>();
		tarefas.add(100116l);
		tarefas.add(100131l);
		tarefas.add(100130l);
		tarefas.add(100143l);
		
		TransacaoSicco transacaoSicco = tabelasSicco.possuiTransacao(nsuTransacao.longValue(), this.connection);
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB03, transacaoSicco);
		
		assertNotNull(Constantes.REGISTRO_N_ENCONTRADO_TB09,
				tabelasSicco.possuiTransacaoXml(nsuTransacao.longValue(), this.connection));
		
		List<TarefasSicco> listTarefas = tabelasSicco.possuiTarefasTransacao(nsuTransacao.longValue(), this.connection);
		assertFalse(Constantes.REGISTRO_N_ENCONTRADO_TB18, listTarefas.isEmpty());
		assertEquals(Constantes.QTDE_TAREFAS_DIVERGENTE_TB18, tarefas.size(), listTarefas.size());
		
	}
	
	

}
