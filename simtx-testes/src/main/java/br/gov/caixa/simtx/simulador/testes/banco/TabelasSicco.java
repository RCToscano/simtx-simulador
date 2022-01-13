package br.gov.caixa.simtx.simulador.testes.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.testes.tabelas.TarefasSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoInterfaceSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoSicco;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoXmlSicco;

public class TabelasSicco {

	private static final Logger logger = Logger.getLogger(TabelasSicco.class);

	public TransacaoSicco possuiTransacao(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_NSU_ORIGEM, " +
					"T.NU_NSU_COORDENADOR, " +
					"T.IC_SITUACAO, " +
					"T.NU_CANAL, " +
					"T.NU_SERVICO, " +
					"T.NU_VERSAO_SERVICO, " +
					"T.NU_NSU_TRANSACAO_CANAL, " +
					"T.VR_TRANSACAO, " +
					"T.NU_UNIDADE, " +
					"T.NU_PRODUTO, " +
					"T.NU_CONTA, " +
					"T.NU_DV_CONTA, " +
					"T.IC_CONTA_SOLUCAO, " +
					"T.NU_CPF, " +
					"T.NU_CNPJ, " +
					"T.DH_TRANSACAO_CANAL, " +
					"T.DH_MULTICANAL, " +
					"T.DH_COORDENADOR, " +
					"T.DT_REFERENCIA " +
					"FROM CCO.CCOTB003_TRANSACAO T WHERE T.NU_NSU_TRANSACAO = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					return new TransacaoSicco(
							nsuTransacao,
							rs.getLong("NU_NSU_ORIGEM"), 
							rs.getLong("NU_NSU_COORDENADOR"), 
							rs.getInt("IC_SITUACAO"), 
							rs.getInt("NU_CANAL"), 
							rs.getInt("NU_SERVICO"), 
							rs.getInt("NU_VERSAO_SERVICO"), 
							rs.getLong("NU_NSU_TRANSACAO_CANAL"), 
							rs.getBigDecimal("VR_TRANSACAO"),
							rs.getInt("NU_UNIDADE"), 
							rs.getInt("NU_PRODUTO"), 
							rs.getLong("NU_CONTA"), 
							rs.getInt("NU_DV_CONTA"), 
							rs.getInt("IC_CONTA_SOLUCAO"), 
							rs.getLong("NU_CPF"), 
							rs.getLong("NU_CNPJ"), 
							rs.getDate("DH_TRANSACAO_CANAL"), 
							rs.getDate("DH_MULTICANAL"), 
							rs.getDate("DH_COORDENADOR"), 
							rs.getDate("DT_REFERENCIA"));
				}
			}
			return null;
		} 
		catch (SQLException e) {
			logger.error(e);
			return null;
		}
	}

	public TransacaoXmlSicco possuiTransacaoXml(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.IC_SITUACAO_XML, " +
					"T.DE_XML_TRANSACAO, " +
					"T.DT_REFERENCIA " +
					"FROM CCO.CCOTB009_TRANSACAO_XML T WHERE T.NU_NSU_TRANSACAO_003 = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					return new TransacaoXmlSicco(
							nsuTransacao, 
							rs.getInt("IC_SITUACAO_XML"), 
							rs.getString("DE_XML_TRANSACAO"), 
							rs.getDate("DT_REFERENCIA"));
				}
			}
			return null;
		} 
		catch (SQLException e) {
			logger.error(e);
			return null;
		}
	}

	public List<TarefasSicco> possuiTarefasTransacao(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_TAREFA, " +
					"T.NU_VERSAO_TAREFA, " +
					"T.NU_NSU_TRANSACAO_CRPRO, " +
					"T.CO_RETORNO_TAREFA, " +
					"T.DE_XML_REQUISICAO, " +
					"T.DE_XML_RESPOSTA, " +
					"T.NU_RETORNO_STATUS, " +
					"T.NU_NSU_MENSAGEM, " +
					"T.DT_REFERENCIA " +
					"FROM CCO.CCOTB018_SRVCO_TRNSO_TARFA T WHERE T.NU_NSU_TRANSACAO_003 = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {

				List<TarefasSicco> lista = new ArrayList<>();

				while (rs.next()) {
					TarefasSicco tarefa = new TarefasSicco(nsuTransacao,
							rs.getInt("NU_TAREFA"), 
							rs.getInt("NU_VERSAO_TAREFA"), 
							rs.getLong("NU_NSU_TRANSACAO_CRPRO"), 
							rs.getString("CO_RETORNO_TAREFA"), 
							rs.getInt("NU_RETORNO_STATUS"), 
							rs.getString("DE_XML_REQUISICAO"), 
							rs.getString("DE_XML_RESPOSTA"), 
							rs.getInt("NU_NSU_MENSAGEM"), 
							rs.getDate("DT_REFERENCIA"));
					lista.add(tarefa);
				}
				return lista;
			}
		} 
		catch (SQLException e) {
			logger.error(e);
			return new ArrayList<>();
		}
	}
	
	public List<TransacaoInterfaceSicco> possuiTransacaoInterface(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_PARAMETRO_INTERFACE_032, " +
					"T.IC_SITUACAO_INTERFACE, " +
					"T.VR_TRANSACAO, " +
					"T.DE_CONTEUDO_LEIAUTE_TRANSACAO, " +
					"T.NU_CONTROLE_ARQUIVO_033, " +
					"T.NU_CONCURSO, " +
					"T.DT_MOVIMENTO, " +
					"T.DT_REFERENCIA " +
					"FROM CCO.CCOTB038_TRANSACAO_INTERFACE T WHERE T.NU_NSU_TRANSACAO_003 = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				
				List<TransacaoInterfaceSicco> lista = new ArrayList<>();
				
				while(rs.next()) {
					TransacaoInterfaceSicco transacao = new TransacaoInterfaceSicco(
							nsuTransacao,
							rs.getLong("NU_PARAMETRO_INTERFACE_032"), 
							rs.getInt("IC_SITUACAO_INTERFACE"), 
							rs.getBigDecimal("VR_TRANSACAO"), 
							rs.getString("DE_CONTEUDO_LEIAUTE_TRANSACAO"), 
							rs.getInt("NU_CONTROLE_ARQUIVO_033"), 
							rs.getLong("NU_CONCURSO"), 
							rs.getDate("DT_MOVIMENTO"), 
							rs.getDate("DT_REFERENCIA"));
					lista.add(transacao);
				}
				return lista;
			}
		} 
		catch (SQLException e) {
			logger.error(e);
			return new ArrayList<>();
		}
	}
	

}
