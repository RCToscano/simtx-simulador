package br.gov.caixa.simtx.simulador.services.feriados;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feriados {

	private Long codigo;

	private String nome;

	private String data;

	private String modalidade;

	private String origem;

	@JsonProperty("data_hora_inclusao")
	private String dataHoraInclusao;

	private Integer pais;

	private Integer localidade;

	@JsonProperty("abrangencia_geografica")
	private String abrangenciaGeografica;
	
	public Feriados() {}

	public Feriados(String data) {
		super();
		this.data = data;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(String dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public Integer getPais() {
		return pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public Integer getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Integer localidade) {
		this.localidade = localidade;
	}

	public String getAbrangenciaGeografica() {
		return abrangenciaGeografica;
	}

	public void setAbrangenciaGeografica(String abrangenciaGeografica) {
		this.abrangenciaGeografica = abrangenciaGeografica;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feriados [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", data=");
		builder.append(data);
		builder.append(", modalidade=");
		builder.append(modalidade);
		builder.append(", origem=");
		builder.append(origem);
		builder.append(", dataHoraInclusao=");
		builder.append(dataHoraInclusao);
		builder.append(", pais=");
		builder.append(pais);
		builder.append(", localidade=");
		builder.append(localidade);
		builder.append(", abrangenciaGeografica=");
		builder.append(abrangenciaGeografica);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abrangenciaGeografica == null) ? 0 : abrangenciaGeografica.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataHoraInclusao == null) ? 0 : dataHoraInclusao.hashCode());
		result = prime * result + ((localidade == null) ? 0 : localidade.hashCode());
		result = prime * result + ((modalidade == null) ? 0 : modalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		String other = (String) obj;
		if (!data.equals(other))
			return false;
		
		return true;
	}
}
