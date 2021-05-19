package br.gov.caixa.simtx.simulador.testes.tabelas;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.gov.caixa.simtx.simulador.testes.banco.Conexao;

public class Dados {
	
	private static final Logger logger = Logger.getLogger(Dados.class);
	
	
	@Test
	public void buscarServico() throws SQLException {
		String query = "   SELECT S.NU_SERVICO, " + 
				"          VS.NU_VERSAO_SERVICO, " + 
				"          S.IC_SITUACAO_SERVICO, " + 
				"          VS.DE_XSD_REQUISICAO AS XSD_REQUISICAO_SERVICO, " + 
				"          VS.DE_XSD_RESPOSTA AS XSD_RESPOSTA_SERVICO, " + 
				"          VS.DE_XSLT_REQUISICAO AS XSLT_REQUISICAO_SERVICO, " + 
				"          VS.DE_XSLT_RESPOSTA AS XSLT_RESPOSTA_SERVICO, " + 
				"          VS.IC_STCO_VRSO_SRVCO, " + 
				"          VS.IC_SERVICO_MIGRADO, " + 
				"          VMS.NU_MEIO_ENTRADA_008, " + 
				"          VMS.IC_SITUACAO AS IC_SITUACAO_ME, " + 
				"          ME.NO_MEIO_ENTRADA, " + 
				"          C.NU_CANAL, " + 
				"          C.NO_CANAL, " + 
				"          C.SG_CANAL, " + 
				"          C.IC_SITUACAO_CANAL, " + 
				"          C.NO_FILA_RESPOSTA_CANAL, " + 
				"          C.NO_CONEXAO_CANAL, " + 
				"          C.NU_REDE_TRANSMISSORA, " + 
				"          C.NU_SEGMENTO, " + 
				"          T.NU_TAREFA, " + 
				"          T.NO_TAREFA, " + 
				"          T.NO_SERVICO_BARRAMENTO, " + 
				"          T.NO_OPERACAO_BARRAMENTO, " + 
				"          T.IC_TIPO_TAREFA, " + 
				"          VT.NU_VERSAO_TAREFA, " + 
				"          VT.NU_TAREFA_DESFAZIMENTO_012, " + 
				"          VT.NU_VERSAO_TAREFA_DSFZO_012, " + 
				"          VT.IC_SITUACAO AS IC_SITUACAO_VERSAO_TAREFA, " + 
				"          VT.IC_ASSINCRONO, " + 
				"          VT.DE_XSLT_REQUISICAO AS XSLT_REQUISICAO_TAREFA, " + 
				"          VT.DE_XSLT_RESPOSTA AS XSLT_RESPOSTA_TAREFA, " + 
				"          VT.DE_XSD_REQUISICAO AS XSD_REQUISICAO_TAREFA, " + 
				"          VT.DE_XSD_RESPOSTA AS XSD_RESPOSTA_TAREFA, " + 
				"          VT.CO_VERSAO_BARRAMENTO, " + 
				"          ST.NU_SEQUENCIA_EXECUCAO, " + 
				"          ST.IC_SITUACAO AS IC_SITUACAO_SERVICO_TAREFA, " + 
				"          ST.IC_IMPEDIMENTO AS IC_IMPEDIMENTO_TAREFA, " + 
				"          TF.NO_FILA_REQUISICAO, " + 
				"          TF.QT_SGNDO_LMTE_REQUISICAO, " + 
				"          TF.QT_SGNDO_LMTE_RESPOSTA, " + 
				"          TF.NO_FILA_RESPOSTA, " + 
				"          TF.NO_CONEXAO AS NO_CONEXAO_TAREFA, " + 
				"          TF.NO_MODO_INTEGRACAO, " + 
				"          TF.NO_RECURSO AS NO_RECURSO_TAREFA, " + 
				"          TF.QT_TEMPO_ESPERA AS QT_TEMPO_ESPERA_TAREFA, " + 
				"          RP.NU_REGRA, " + 
				"          RP.NO_CAMPO_DEPENDENCIA, " + 
				"          RP.NO_SERVICO_ORIGEM, " + 
				"          RP.NO_OPERACAO_ORIGEM, " + 
				"          RP.DE_CAMINHO_INFORMACAO, " + 
				"          M.NU_NSU_MENSAGEM, " + 
				"          M.IC_TIPO_MENSAGEM, " + 
				"          M.CO_MENSAGEM AS CODIGO_RETORNO_CORPORATIVO, " + 
				"          M.CO_RETORNO AS CODIGO_RETORNO_CANAL, " + 
				"          M.DE_MENSAGEM_NEGOCIAL, " + 
				"          M.DE_MENSAGEM_TECNICA, " + 
				"          M.DE_MENSAGEM_RESUMIDA, " + 
				"          M.NU_CATEGORIA_MENSAGEM_051, " + 
				"          TM.NO_CAMPO_RETORNO " + 
				"     FROM MTX.MTXTB001_SERVICO S " + 
				"LEFT JOIN MTX.MTXTB011_VERSAO_SERVICO VS " + 
				"       ON S.NU_SERVICO = VS.NU_SERVICO_001 " + 
				"LEFT JOIN MTX.MTXTB003_SERVICO_TAREFA ST " + 
				"       ON VS.NU_SERVICO_001 = ST.NU_SERVICO_011 " + 
				"      AND VS.NU_VERSAO_SERVICO = ST.NU_VERSAO_SERVICO_011 " + 
				"LEFT JOIN (   SELECT SC1.NU_CANAL_004, " + 
				"                     SC1.NU_SERVICO_001 " + 
				"                FROM MTX.MTXTB005_SERVICO_CANAL SC1 " + 
				"               WHERE SC1.NU_SERVICO_001 = 110029 " + 
				"                 AND SC1.NU_CANAL_004 = 106 " + 
				"            GROUP BY SC1.NU_SERVICO_001, SC1.NU_CANAL_004 " + 
				"          ) SC " + 
				"       ON S.NU_SERVICO = SC.NU_SERVICO_001 " + 
				"LEFT JOIN MTX.MTXTB004_CANAL C " + 
				"       ON SC.NU_CANAL_004 = C.NU_CANAL " + 
				"LEFT JOIN (   SELECT VMS1.NU_MEIO_ENTRADA_008, " + 
				"                     VMS1.NU_SERVICO_011,  " + 
				"                     VMS1.NU_VERSAO_SERVICO_011, " + 
				"                     VMS1.IC_SITUACAO " + 
				"                FROM MTX.MTXTB018_VRSO_MEIO_ENTRA_SRVCO VMS1 " + 
				"               WHERE VMS1.NU_SERVICO_011 = 110029 " + 
				"                 AND VMS1.NU_VERSAO_SERVICO_011 = 1 " + 
				"                 AND VMS1.NU_MEIO_ENTRADA_008 = 4 " + 
				"            GROUP BY VMS1.NU_SERVICO_011, VMS1.NU_VERSAO_SERVICO_011, VMS1.NU_MEIO_ENTRADA_008, VMS1.IC_SITUACAO " + 
				"          ) VMS " + 
				"       ON VS.NU_SERVICO_001 = VMS.NU_SERVICO_011 " + 
				"      AND VS.NU_VERSAO_SERVICO = VMS.NU_VERSAO_SERVICO_011 " + 
				"LEFT JOIN MTX.MTXTB008_MEIO_ENTRADA ME " + 
				"       ON VMS.NU_MEIO_ENTRADA_008 = ME.NU_MEIO_ENTRADA " + 
				"LEFT JOIN (   SELECT STC1.NU_TAREFA_003, " + 
				"                     STC1.NU_VERSAO_TAREFA_003, " + 
				"                     STC1.NU_SERVICO_003, " + 
				"                     STC1.NU_VERSAO_SERVICO_003 " + 
				"                FROM MTX.MTXTB020_SRVCO_TARFA_CANAL STC1   " + 
				"           LEFT JOIN MTX.MTXTB010_VRSO_TARFA_MEIO_ENTRA VTM1 " + 
				"                  ON STC1.NU_TAREFA_003 = VTM1.NU_TAREFA_012    " + 
				"                 AND STC1.NU_VERSAO_TAREFA_003 = VTM1.NU_VERSAO_TAREFA_012    " + 
				"               WHERE STC1.NU_SERVICO_003 = 110029    " + 
				"                 AND STC1.NU_VERSAO_SERVICO_003 = 1    " + 
				"                 AND STC1.NU_CANAL_004 = 106    " + 
				"                 AND VTM1.NU_MEIO_ENTRADA_008 = 4 " + 
				"          UNION ALL " + 
				"             SELECT STC1.NU_TAREFA_003, " + 
				"                    STC1.NU_VERSAO_TAREFA_003, " + 
				"                    STC1.NU_SERVICO_003, " + 
				"                    STC1.NU_VERSAO_SERVICO_003 " + 
				"               FROM MTX.MTXTB020_SRVCO_TARFA_CANAL STC1  " + 
				"          LEFT JOIN MTX.MTXTB002_TAREFA T " + 
				"                 ON STC1.NU_TAREFA_003 = T.NU_TAREFA " + 
				"              WHERE STC1.NU_SERVICO_003 = 110029    " + 
				"                AND STC1.NU_VERSAO_SERVICO_003 = 1    " + 
				"                AND STC1.NU_CANAL_004 = 106 " + 
				"                AND T.IC_TIPO_TAREFA = 2    " + 
				"          ) STM    " + 
				"       ON ST.NU_SERVICO_011 = STM.NU_SERVICO_003 " + 
				"      AND ST.NU_VERSAO_SERVICO_011 = STM.NU_VERSAO_SERVICO_003 " + 
				"      AND ST.NU_TAREFA_012 = STM.NU_TAREFA_003 " + 
				"      AND ST.NU_VERSAO_TAREFA_012 = STM.NU_VERSAO_TAREFA_003 " + 
				"LEFT JOIN MTX.MTXTB002_TAREFA T " + 
				"       ON STM.NU_TAREFA_003 = T.NU_TAREFA " + 
				"LEFT JOIN MTX.MTXTB012_VERSAO_TAREFA VT " + 
				"       ON STM.NU_TAREFA_003 = VT.NU_TAREFA_002 " + 
				"      AND STM.NU_VERSAO_TAREFA_003 = VT.NU_VERSAO_TAREFA " + 
				"LEFT JOIN MTX.MTXTB024_TAREFA_FILA TF " + 
				"       ON STM.NU_TAREFA_003 = TF.NU_TAREFA_012 " + 
				"      AND STM.NU_VERSAO_TAREFA_003 = TF.NU_VERSAO_TAREFA_012 " + 
				"LEFT JOIN MTX.MTXTB026_SERVICO_TAREFA_REGRA STR " + 
				"       ON STM.NU_TAREFA_003 = STR.NU_TAREFA_003 " + 
				"      AND STM.NU_VERSAO_TAREFA_003 = STR.NU_VERSAO_TAREFA_003 " + 
				"LEFT JOIN MTX.MTXTB025_REGRA_PROCESSAMENTO RP " + 
				"       ON STR.NU_REGRA_025 = RP.NU_REGRA " + 
				"LEFT JOIN MTX.MTXTB007_TAREFA_MENSAGEM TM " + 
				"       ON STM.NU_TAREFA_003 = TM.NU_TAREFA_012 " + 
				"      AND STM.NU_VERSAO_TAREFA_003 = TM.NU_VERSAO_TAREFA_012 " + 
				"LEFT JOIN MTX.MTXTB006_MENSAGEM M " + 
				"       ON TM.NU_MENSAGEM_006 = M.NU_NSU_MENSAGEM " + 
				"    WHERE VS.NU_SERVICO_001 = 110029 " + 
				"      AND VS.NU_VERSAO_SERVICO = 1 " + 
				" GROUP BY S.NU_SERVICO, " + 
				"          VS.NU_VERSAO_SERVICO, " + 
				"          S.IC_SITUACAO_SERVICO, " + 
				"          VS.DE_XSD_REQUISICAO, " + 
				"          VS.DE_XSD_RESPOSTA, " + 
				"          VS.DE_XSLT_REQUISICAO, " + 
				"          VS.DE_XSLT_RESPOSTA, " + 
				"          VS.IC_STCO_VRSO_SRVCO, " + 
				"          VS.IC_SERVICO_MIGRADO, " + 
				"          VMS.NU_MEIO_ENTRADA_008, " + 
				"          VMS.IC_SITUACAO, " + 
				"          ME.NO_MEIO_ENTRADA, " + 
				"          C.NU_CANAL, " + 
				"          C.NO_CANAL, " + 
				"          C.SG_CANAL, " + 
				"          C.IC_SITUACAO_CANAL, " + 
				"          C.NO_FILA_RESPOSTA_CANAL, " + 
				"          C.NO_CONEXAO_CANAL, " + 
				"          C.NU_REDE_TRANSMISSORA, " + 
				"          C.NU_SEGMENTO, " + 
				"          T.NU_TAREFA, " + 
				"          T.NO_TAREFA, " + 
				"          T.NO_SERVICO_BARRAMENTO, " + 
				"          T.NO_OPERACAO_BARRAMENTO, " + 
				"          T.IC_TIPO_TAREFA, " + 
				"          VT.NU_VERSAO_TAREFA, " + 
				"          VT.NU_TAREFA_DESFAZIMENTO_012, " + 
				"          VT.NU_VERSAO_TAREFA_DSFZO_012, " + 
				"          VT.IC_SITUACAO, " + 
				"          VT.IC_ASSINCRONO, " + 
				"          VT.DE_XSLT_REQUISICAO, " + 
				"          VT.DE_XSLT_RESPOSTA, " + 
				"          VT.DE_XSD_REQUISICAO, " + 
				"          VT.DE_XSD_RESPOSTA, " + 
				"          VT.CO_VERSAO_BARRAMENTO, " + 
				"          ST.NU_SEQUENCIA_EXECUCAO, " + 
				"          ST.IC_SITUACAO, " + 
				"          ST.IC_IMPEDIMENTO, " + 
				"          TF.NO_FILA_REQUISICAO, " + 
				"          TF.QT_SGNDO_LMTE_REQUISICAO, " + 
				"          TF.NO_FILA_RESPOSTA, " + 
				"          TF.QT_SGNDO_LMTE_RESPOSTA, " + 
				"          TF.NO_CONEXAO, " + 
				"          TF.NO_MODO_INTEGRACAO, " + 
				"          TF.NO_RECURSO, " + 
				"          TF.QT_TEMPO_ESPERA, " + 
				"          RP.NU_REGRA, " + 
				"          RP.NO_CAMPO_DEPENDENCIA, " + 
				"          RP.NO_SERVICO_ORIGEM, " + 
				"          RP.NO_OPERACAO_ORIGEM, " + 
				"          RP.DE_CAMINHO_INFORMACAO, " + 
				"          M.NU_NSU_MENSAGEM, " + 
				"          M.IC_TIPO_MENSAGEM, " + 
				"          M.CO_MENSAGEM, " + 
				"          M.CO_RETORNO, " + 
				"          M.DE_MENSAGEM_NEGOCIAL, " + 
				"          M.DE_MENSAGEM_TECNICA, " + 
				"          M.DE_MENSAGEM_RESUMIDA, " + 
				"          M.NU_CATEGORIA_MENSAGEM_051, " + 
				"          TM.NO_CAMPO_RETORNO " + 
				" ORDER BY ST.NU_SEQUENCIA_EXECUCAO,  " + 
				"          RP.NU_REGRA";
		try (Connection connection = Conexao.obterConexao();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet rs = statement.executeQuery(query);) {
			
			Servico servico = new Servico();
			List<Tarefa> listaTarefas = new ArrayList<>();
			List<Regra> listaRegras = new ArrayList<>();
			List<Mensagem> listaMsg = new ArrayList<>();
			
			Tarefa tarefa = new Tarefa();
			
			int nuTarefa = 0;
			int nuRegra = 0;
			int nuMsg = 0;
			
			while (rs.next()) {
				
				logger.info(rs.getInt("NU_SERVICO"));
				servico.setNuServico(rs.getInt("NU_SERVICO"));
				
				logger.info(rs.getInt("NU_TAREFA"));
				nuTarefa = rs.getInt("NU_TAREFA");
				if(nuTarefa > 0) {
					
					Tarefa tarefaAux = new Tarefa();
					tarefaAux.setNuTarefa(nuTarefa);
					
					if(listaTarefas.contains(tarefaAux)) {
						adicionarTarefa(tarefaAux, rs);
						
						logger.info(rs.getInt("NU_REGRA"));
						nuRegra = rs.getInt("NU_REGRA");
						if(nuRegra > 0) {
							Regra regrasAux = new Regra();
							regrasAux.setNuRegra(nuRegra);
							if(!listaRegras.contains(regrasAux)) {
								adicionarRegra(regrasAux, rs);
								listaRegras.add(regrasAux);
							}
						}
						
						logger.info(rs.getInt("NU_NSU_MENSAGEM"));
						nuMsg = rs.getInt("NU_NSU_MENSAGEM");
						if(nuMsg > 0) {
							Mensagem msgAux = new Mensagem();
							msgAux.setNuNsuMensagem(nuMsg);
							if(!listaMsg.contains(msgAux)) {
								adicionarMensagem(msgAux, rs);
								listaMsg.add(msgAux);
							}
						}
						
					}
					else {
						listaRegras = new ArrayList<>();
						listaMsg = new ArrayList<>();
						adicionarTarefa(tarefaAux, rs);
						tarefa = tarefaAux;
						
						logger.info(rs.getInt("NU_REGRA"));
						nuRegra = rs.getInt("NU_REGRA");
						if(nuRegra > 0) {
							Regra regrasAux = new Regra();
							regrasAux.setNuRegra(nuRegra);
							adicionarRegra(regrasAux, rs);
							listaRegras.add(regrasAux);
						}
						
						logger.info(rs.getInt("NU_NSU_MENSAGEM"));
						nuMsg = rs.getInt("NU_NSU_MENSAGEM");
						if(nuMsg > 0) {
							Mensagem msgAux = new Mensagem();
							msgAux.setNuNsuMensagem(nuMsg);
							adicionarMensagem(msgAux, rs);
							listaMsg.add(msgAux);
						}
						
						tarefa.setListaRegras(listaRegras);
						tarefa.setListaMsg(listaMsg);
						listaTarefas.add(tarefa);
						
					}
				}
				
				

			}
			
			servico.setListaTarefas(listaTarefas);
			
		} 
		catch (Exception e) {
			logger.error(e);
			fail();
		}
	}
	
	public void adicionarTarefa(Tarefa tarefa, ResultSet rs) throws SQLException {
		tarefa.setCoVersaoBarramento(rs.getString("CO_VERSAO_BARRAMENTO"));
		tarefa.setDeXsdRequisicao(rs.getString("XSD_REQUISICAO_TAREFA"));
		tarefa.setDeXsdResposta(rs.getString("XSD_RESPOSTA_TAREFA"));
		tarefa.setDeXsltRequisicao(rs.getString("XSLT_REQUISICAO_TAREFA"));
		tarefa.setDeXsltResposta(rs.getString("XSLT_RESPOSTA_TAREFA"));
		tarefa.setIcAssincrono(rs.getInt("IC_ASSINCRONO"));
		tarefa.setIcImpedimento(rs.getInt("IC_IMPEDIMENTO_TAREFA"));
		tarefa.setIcSituacaoServicoTarefa(rs.getInt("IC_SITUACAO_SERVICO_TAREFA"));
		tarefa.setIcSituacaoVersaoTarefa(rs.getInt("IC_SITUACAO_VERSAO_TAREFA"));
		tarefa.setNoConexao(rs.getString("NO_CONEXAO_TAREFA"));
		tarefa.setNoFilaRequisicao(rs.getString("NO_FILA_REQUISICAO"));
		tarefa.setNoFilaResposta(rs.getString("NO_FILA_RESPOSTA"));
		tarefa.setNoModoIntegracao(rs.getString("NO_MODO_INTEGRACAO"));
		tarefa.setNoRecurso(rs.getString("NO_RECURSO_TAREFA"));
		tarefa.setNuSequenciaExecucao(rs.getInt("NU_SEQUENCIA_EXECUCAO"));
		tarefa.setNuTimeoutRequisicao(rs.getInt("QT_SGNDO_LMTE_REQUISICAO"));
		tarefa.setNuTimeoutResposta(rs.getInt("QT_SGNDO_LMTE_RESPOSTA"));
		tarefa.setQtdeTempoEspera(rs.getInt("QT_TEMPO_ESPERA_TAREFA"));
	}
	
	public void adicionarMensagem(Mensagem mensagem, ResultSet rs) throws SQLException {
		mensagem.setCoRetornoCanal(rs.getString("CODIGO_RETORNO_CANAL"));
		mensagem.setCoRetornoCorporativo(rs.getString("CODIGO_RETORNO_CORPORATIVO"));
		mensagem.setDeMensagemNegocial(rs.getString("DE_MENSAGEM_NEGOCIAL"));
		mensagem.setDeMensagemTecnica(rs.getString("DE_MENSAGEM_TECNICA"));
		mensagem.setDeMensagemResumida(rs.getString("DE_MENSAGEM_RESUMIDA"));
		mensagem.setIcTipoMensagem(rs.getInt("IC_TIPO_MENSAGEM"));
		mensagem.setNoCampoRetorno(rs.getString("NO_CAMPO_RETORNO"));
		mensagem.setCategoriaMensagem(adicionarCategoria(rs));
	}
	
	public void adicionarRegra(Regra regra, ResultSet rs) throws SQLException {
		regra.setDeCaminhoInformacao(rs.getString("DE_CAMINHO_INFORMACAO"));
		regra.setNoCampoDependencia(rs.getString("NO_CAMPO_DEPENDENCIA"));
		regra.setNoOperacaoOrigem(rs.getString("NO_OPERACAO_ORIGEM"));
		regra.setNoServicoOrigem(rs.getString("NO_SERVICO_ORIGEM"));
	}
	
	public void adicionarMeioEntrada(MeioEntrada meioEntrada, ResultSet rs) throws SQLException {
		meioEntrada.setIcSituacao(rs.getInt("IC_SITUACAO_ME"));
		meioEntrada.setNoMeioEntrada(rs.getString("NO_MEIO_ENTRADA"));
		meioEntrada.setNuMeioEntrada(rs.getInt("NU_MEIO_ENTRADA_008"));
	}
	
	public void adicionarCanal(Canal canal, ResultSet rs) throws SQLException {
		canal.setNuCanal(rs.getInt("NU_CANAL"));
		canal.setIcSituacaoCanal(rs.getInt("IC_SITUACAO_CANAL"));
		canal.setNoCanal(rs.getString("NO_CANAL"));
		canal.setNoConexaoCanal(rs.getString("NO_CONEXAO_CANAL"));
		canal.setNoFilaRspCanal(rs.getString("NO_FILA_RESPOSTA_CANAL"));
		canal.setNuRedeTransmissora(rs.getInt("NU_REDE_TRANSMISSORA"));
		canal.setNuSegmento(rs.getInt("NU_SEGMENTO"));
		canal.setSigla(rs.getString("SG_CANAL"));
	}
	
	public CategoriaMensagem adicionarCategoria(ResultSet rs) throws SQLException {
		CategoriaMensagem categoria = new CategoriaMensagem();
		categoria.setNuCategoriaMensagem(rs.getInt("NU_CATEGORIA_MENSAGEM_051"));
//		categoria.setDeProcessoExecucao(rs.getString(""));
//		categoria.setNoCategoriaMensagem(rs.getString(""));
		return categoria;
	}

}
