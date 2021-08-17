//package br.gov.caixa.simtx.simulador.testes.banco;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
//import br.gov.caixa.simtx.simulador.testes.tabelas.TarefasSicco;
//import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoAgendamento;
//import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoSicco;
//import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoXmlSicco;
//
//public class TabelasSicco {
//
//	private static final Logger logger = Logger.getLogger(TabelasSicco.class);
//
//	public TransacaoSicco possuiTransacao(Long nsuTransacao, Connection connection) {
//		String query = "SELECT T.NU_NSU_ORIGEM, " +
//					"T.NU_NSU_COORDENADOR, " +
//					"T.IC_SITUACAO, " +
//					"T.NU_CANAL, " +
//					"T.NU_SERVICO, " +
//					"T.NU_VERSAO_SERVICO, " +
//					"T.NU_NSU_TRANSACAO_CANAL, " +
//					"T.VR_TRANSACAO, " +
//					"T.NU_UNIDADE, " +
//					"T.NU_PRODUTO, " +
//					"T.NU_CONTA, " +
//					"T.NU_DV_CONTA, " +
//					"T.IC_CONTA_SOLUCAO, " +
//					"T.NU_CPF, " +
//					"T.NU_CNPJ, " +
//					"T.DH_TRANSACAO_CANAL, " +
//					"T.DH_MULTICANAL, " +
//					"T.DH_COORDENADOR, " +
//					"T.DT_REFERENCIA " +
//					"FROM CCO.CCOTB003_TRANSACAO T WHERE T.NU_NSU_TRANSACAO = ?";
//		
//		try (PreparedStatement statement = connection.prepareStatement(query);) {
//
//			statement.setLong(1, nsuTransacao);
//
//			try (ResultSet rs = statement.executeQuery()) {
//				if(rs.next()) {
//					return new TransacaoSicco(
//							nsuTransacao,
//							rs.getLong("NU_NSU_ORIGEM"), 
//							rs.getLong("NU_NSU_COORDENADOR"), 
//							rs.getInt("IC_SITUACAO"), 
//							rs.getInt("NU_CANAL"), 
//							rs.getInt("NU_SERVICO"), 
//							rs.getInt("NU_VERSAO_SERVICO"), 
//							rs.getLong("NU_NSU_TRANSACAO_CANAL"), 
//							rs.getBigDecimal("VR_TRANSACAO"),
//							rs.getInt("NU_UNIDADE"), 
//							rs.getInt("NU_PRODUTO"), 
//							rs.getLong("NU_CONTA"), 
//							rs.getInt("NU_DV_CONTA"), 
//							rs.getInt("IC_CONTA_SOLUCAO"), 
//							rs.getLong("NU_CPF"), 
//							rs.getLong("NU_CNPJ"), 
//							rs.getDate("DH_TRANSACAO_CANAL"), 
//							rs.getDate("DH_MULTICANAL"), 
//							rs.getDate("DH_COORDENADOR"), 
//							rs.getDate("DT_REFERENCIA"));
//				}
//			}
//			return null;
//		} 
//		catch (SQLException e) {
//			logger.error(e);
//			return null;
//		}
//	}
//	
//	public TransacaoXmlSicco possuiTransacaoXml(Long nsuTransacao, Connection connection) {
//		String query = "SELECT T.IC_SITUACAO_XML, " +
//					"T.DE_XML_TRANSACAO, " +
//					"T.DT_REFERENCIA " +
//					"FROM CCO.CCOTB009_TRANSACAO_XML T WHERE T.NU_NSU_TRANSACAO_003 = ?";
//		
//		try (PreparedStatement statement = connection.prepareStatement(query);) {
//
//			statement.setLong(1, nsuTransacao);
//
//			try (ResultSet rs = statement.executeQuery()) {
//				if(rs.next()) {
//					return new TransacaoXmlSicco(
//							nsuTransacao, 
//							rs.getInt("IC_SITUACAO_XML"), 
//							rs.getString("DE_XML_TRANSACAO"), 
//							rs.getDate("DT_REFERENCIA"));
//				}
//			}
//			return null;
//		} 
//		catch (SQLException e) {
//			logger.error(e);
//			return null;
//		}
//	}
//
//	public List<TarefasSicco> possuiTarefasTransacao(Long nsuTransacao, Connection connection) {
//		String query = "SELECT T.NU_TAREFA, " +
//					"T.NU_VERSAO_TAREFA, " +
//					"T.NU_VERSAO_TAREFA, " +
//					"T.NU_NSU_TRANSACAO_CRPRO, " +
//					"T.CO_RETORNO_TAREFA, " +
//					"T.DE_XML_REQUISICAO, " +
//					"T.DE_XML_RESPOSTA, " +
//					"T.NU_RETORNO_STATUS, " +
//					"T.NU_NSU_MENSAGEM, " +
//					"T.DT_REFERENCIA " +
//					"FROM CCO.CCOTB018_SRVCO_TRNSO_TARFA T WHERE T.NU_NSU_TRANSACAO_003 = ?";
//
//		try (PreparedStatement statement = connection.prepareStatement(query);) {
//
//			statement.setLong(1, nsuTransacao);
//
//			try (ResultSet rs = statement.executeQuery()) {
//
//				List<TarefasSicco> lista = new ArrayList<>();
//
//				while (rs.next()) {
//					TarefasSicco tarefa = new TarefasSicco(
//							nsuTransacao, 
//							0, 
//							0, 
//							0, 
//							0, 
//							nsuTransacao, 
//							query, 
//							0, 
//							query, 
//							query, 
//							0, 
//							null);
//					
//					Tarefa tarefa = new Tarefa(rs.getInt("NU_TAREFA_012"), rs.getInt("NU_VERSAO_TAREFA_012"), rs.getString("DE_XML_REQUISICAO"));
//					lista.add(tarefa);
//				}
//				return lista;
//			}
//		} 
//		catch (SQLException e) {
//			logger.error(e);
//			return new ArrayList<>();
//		}
//	}
//	
//	public TransacaoAgendamento possuiTransacaoAgendamento(Long nsuTransacao, Connection connection) {
//		String query = "SELECT T.NU_NSU_EFETIVACAO, " + 
//				"T.DT_REFERENCIA, " + 
//				"T.DT_EFETIVACAO, " + 
//				"T.DE_IDENTIFICACAO_TRANSACAO, " + 
//				"T.IC_SITUACAO_AGENDAMENTO, " + 
//				"T.NU_SERVICO, " + 
//				"T.NU_VERSAO_SERVICO, " + 
//				"T.NU_CANAL, " + 
//				"T.VR_TRANSACAO, " + 
//				"T.IC_CONTA_SOLUCAO, " + 
//				"T.NU_UNIDADE, " + 
//				"T.NU_PRODUTO, " + 
//				"T.NU_CONTA, " + 
//				"T.NU_DV_CONTA FROM MTX.MTXTB034_TRANSACAO_AGENDAMENTO T WHERE T.NU_NSU_TRANSACAO_AGENDAMENTO = ?";
//
//		try (PreparedStatement statement = connection.prepareStatement(query);) {
//
//			statement.setLong(1, nsuTransacao);
//
//			try (ResultSet rs = statement.executeQuery()) {
//				if(rs.next()) {
//					return new TransacaoAgendamento(nsuTransacao, 
//							rs.getLong("NU_NSU_EFETIVACAO"), 
//							rs.getDate("DT_REFERENCIA"),
//							rs.getDate("DT_EFETIVACAO"), 
//							rs.getString("DE_IDENTIFICACAO_TRANSACAO"), 
//							rs.getInt("IC_SITUACAO_AGENDAMENTO"), 
//							rs.getInt("NU_SERVICO"), 
//							rs.getInt("NU_VERSAO_SERVICO"),
//							rs.getInt("NU_CANAL"), 
//							rs.getBigDecimal("VR_TRANSACAO"), 
//							rs.getInt("NU_UNIDADE"), 
//							rs.getInt("NU_PRODUTO"), 
//							rs.getLong("NU_CONTA"), 
//							rs.getInt("NU_DV_CONTA"), 
//							rs.getInt("IC_CONTA_SOLUCAO"));
//				}
//			}
//			return null;
//		} 
//		catch (SQLException e) {
//			logger.error(e);
//			return null;
//		}
//	}
//
//
//}
