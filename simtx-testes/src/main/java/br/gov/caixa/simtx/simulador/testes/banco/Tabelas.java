package br.gov.caixa.simtx.simulador.testes.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.testes.tabelas.Tarefa;
import br.gov.caixa.simtx.simulador.testes.tabelas.Transacao;

public class Tabelas {

	private static final Logger logger = Logger.getLogger(Tabelas.class);

	public Transacao possuiTransacao(Long nsuTransacao, Connection connection) {
		String query = "SELECT T.NU_NSU_TRANSACAO, T.IC_SITUACAO FROM MTX.MTXTB014_TRANSACAO T WHERE T.NU_NSU_TRANSACAO = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					return new Transacao(nsuTransacao, rs.getInt("IC_SITUACAO"));
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

		String query = "SELECT T.NU_TAREFA_012, NU_VERSAO_TAREFA_012 FROM MTX.MTXTB015_SRVCO_TRNSO_TARFA T WHERE T.NU_NSU_TRANSACAO_017 = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setLong(1, nsuTransacao);

			try (ResultSet rs = statement.executeQuery()) {

				List<Tarefa> lista = new ArrayList<>();

				while (rs.next()) {
					Tarefa tarefa = new Tarefa(rs.getInt("NU_TAREFA_012"), rs.getInt("NU_VERSAO_TAREFA_012"));
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

}
