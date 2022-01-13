package br.gov.caixa.simtx.simulador.testes.banco;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;
import br.gov.caixa.simtx.simulador.testes.tabelas.TransacaoAgendamento;

public class Tabelas {

	private static final Logger logger = Logger.getLogger(Tabelas.class);
	
	public BigDecimal gerarNsuTransacao(Connection connection) {
		BigDecimal nuNsuCoordenador = null;
		String query = "SELECT MTX.MTXSQ014_NU_NSU_TRANSACAO.NEXTVAL AS NSU_TRANSACAO FROM DUAL";
    	
		try (PreparedStatement statement1 = connection.prepareStatement(query);) {
			
			try (ResultSet rs = statement1.executeQuery()) {
			    while(rs.next()) {
			    	nuNsuCoordenador = rs.getBigDecimal("NSU_TRANSACAO");
			    }
			}
			return nuNsuCoordenador;
		} 
		catch (SQLException e) {
			logger.error(e);
			return null;
		}
	}

	public Transacao possuiTransacao(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_NSU_TRANSACAO_ORIGEM, " +
					"T.IC_SITUACAO, " +
					"T.IC_ENVIO, " +
					"T.IC_RETORNO, " +
					"T.CO_TRANSACAO_EXTERNO, " +
					"T.DT_REFERENCIA " +
					"FROM MTX.MTXTB014_TRANSACAO T WHERE T.NU_NSU_TRANSACAO = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					return new Transacao(nsuTransacao, 
							rs.getLong("NU_NSU_TRANSACAO_ORIGEM"), 
							rs.getInt("IC_SITUACAO"), 
							rs.getInt("IC_ENVIO"), 
							rs.getInt("IC_RETORNO"), 
							rs.getString("CO_TRANSACAO_EXTERNO"), 
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

	public boolean possuiIteracaoCanal(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_NSU_TRANSACAO_014 FROM MTX.MTXTB016_ITERACAO_CANAL T WHERE T.NU_NSU_TRANSACAO_014 = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				return rs.next();
			}
		} 
		catch (SQLException e) {
			logger.error(e);
			return false;
		}
	}

	public boolean possuiServicoTransacao(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_NSU_TRANSACAO_014 FROM MTX.MTXTB017_VERSAO_SRVCO_TRNSO T WHERE T.NU_NSU_TRANSACAO_014 = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				return rs.next();
			}
		} 
		catch (SQLException e) {
			logger.error(e);
			return false;
		}
	}

	public List<Tarefa> possuiTarefasTransacao(Long nsuTransacao, Connection connection) {

		String query = "SELECT T.NU_TAREFA_012, T.NU_VERSAO_TAREFA_012, T.DE_XML_REQUISICAO FROM MTX.MTXTB015_SRVCO_TRNSO_TARFA T WHERE T.NU_NSU_TRANSACAO_017 = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {

				List<Tarefa> lista = new ArrayList<>();

				while (rs.next()) {
					Tarefa tarefa = new Tarefa(rs.getInt("NU_TAREFA_012"), rs.getInt("NU_VERSAO_TAREFA_012"), rs.getString("DE_XML_REQUISICAO"));
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
	
	public TransacaoAgendamento possuiTransacaoAgendamento(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_NSU_EFETIVACAO, " + 
				"T.DT_REFERENCIA, " + 
				"T.DT_EFETIVACAO, " + 
				"T.DE_IDENTIFICACAO_TRANSACAO, " + 
				"T.IC_SITUACAO_AGENDAMENTO, " + 
				"T.NU_SERVICO, " + 
				"T.NU_VERSAO_SERVICO, " + 
				"T.NU_CANAL, " + 
				"T.VR_TRANSACAO, " + 
				"T.IC_CONTA_SOLUCAO, " + 
				"T.NU_UNIDADE, " + 
				"T.NU_PRODUTO, " + 
				"T.NU_CONTA, " + 
				"T.NU_DV_CONTA FROM MTX.MTXTB034_TRANSACAO_AGENDAMENTO T WHERE T.NU_NSU_TRANSACAO_AGENDAMENTO = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					return new TransacaoAgendamento(nsuTransacao, 
							rs.getLong("NU_NSU_EFETIVACAO"), 
							rs.getDate("DT_REFERENCIA"),
							rs.getDate("DT_EFETIVACAO"), 
							rs.getString("DE_IDENTIFICACAO_TRANSACAO"), 
							rs.getInt("IC_SITUACAO_AGENDAMENTO"), 
							rs.getInt("NU_SERVICO"), 
							rs.getInt("NU_VERSAO_SERVICO"),
							rs.getInt("NU_CANAL"), 
							rs.getBigDecimal("VR_TRANSACAO"), 
							rs.getInt("NU_UNIDADE"), 
							rs.getInt("NU_PRODUTO"), 
							rs.getLong("NU_CONTA"), 
							rs.getInt("NU_DV_CONTA"), 
							rs.getInt("IC_CONTA_SOLUCAO"));
				}
			}
			return null;
		} 
		catch (SQLException e) {
			logger.error(e);
			return null;
		}
	}


}
