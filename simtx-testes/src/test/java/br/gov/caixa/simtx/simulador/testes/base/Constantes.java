package br.gov.caixa.simtx.simulador.testes.base;

public class Constantes {
	
	private Constantes() {
	}
	
	public static final String ERRO_GERAR_TOKEN = "Nao foi possivel gerar o Token Transacao";
	
	public static final String SEM_RESPOSTA = "Nenhuma resposta da requisicao";
	
	public static final String SEM_RESPOSTA_HTTP = "Nenhuma resposta da requisicao HTTP";
	
	public static final String RESPOSTA_IMPEDITIVA_HTTP = "Resposta Impeditiva - Codigo[";
	
	public static final String RESPOSTA_DIVERGENTE_HTTP = "Resposta Divergente - Codigo[";
	
	public static final String RESPOSTA_CONTEM_CAMPOS_NULOS = "Resposta contem campos nulos";
	
	public static final String SITUACAO_TB14_DIVERGENTE = "Situacao da tabela MTXTB014_TRANSACAO divergente";
	
	public static final String SITUACAO_TB34_DIVERGENTE = "Situacao da tabela MTXTB034_TRANSACAO_AGENDAMENTO divergente";
	
	public static final String REGISTRO_N_ENCONTRADO_TB14 = "Registro nao encontrada na tabela MTXTB014_TRANSACAO";
	
	public static final String REGISTRO_N_ENCONTRADO_TB16 = "Registro nao encontrado na tabela MTXTB016_ITERACAO_CANAL";
	
	public static final String REGISTRO_N_ENCONTRADO_TB17 = "Registro nao encontrada na tabela MTXTB017_VERSAO_SRVCO_TRNSO";
	
	public static final String REGISTRO_N_ENCONTRADO_TB15 = "Nenhum Tarefa encontrada na tabela MTXTB015_SRVCO_TRNSO_TARFA";
	
	public static final String REGISTRO_N_ENCONTRADO_TB34 = "Registro nao encontrada na tabela MTXTB034_TRANSACAO_AGENDAMENTO";
	
	public static final String N_DEVE_TER_REGISTRO_TB15 = "Nao espera-se registros na tabela MTXTB015_SRVCO_TRNSO_TARFA";
	
	public static final String QTDE_TAREFAS_DIVERGENTE_TB15 = "Quantidade de tarefas gravadas na tabela MTXTB015_SRVCO_TRNSO_TARFA esta divergente";
	
	public static final String TAREFA_GRAVADA_ERRADA = "Tarefa nao deveria estar gravada na tabela";
	
	public static final String MSG_NEGOCIAL_DIFERENTE = "Mensagem Negocial diferente do esperado";
	
	public static final String VALOR_NULO_TB34 = "Valor na tabela MTXTB034_TRANSACAO_AGENDAMENTO nao pode ser nulo ou zero";

}
