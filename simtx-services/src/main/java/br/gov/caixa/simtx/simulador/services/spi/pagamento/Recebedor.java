package br.gov.caixa.simtx.simulador.services.spi.pagamento;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Recebedor {

	@NotNull(message = "cpf recebedor nao informado")
	@Size(min = 11, max = 11, message = "cpf recebedor deve ser informado e ter 11 caracteres")
	private String cpf;

	@Size(min = 14, max = 14, message = "cnpj recebedor deve ter 14 caracteres")
	private String cnpj;

	@NotNull(message = "nome recebedor nao informado")
	@Size(min = 3, message = "nome recebedor nao informado corretamente")
	private String nome;

	@Size(min = 3, message = "nomeFantasia recebedor nao informado corretamente")
	private String nomeFantasia;

	@NotNull(message = "logradouro recebedor nao informado")
	@Size(min = 2, message = "logradouro recebedor nao informado corretamente")
	private String logradouro;

	@NotNull(message = "cidade recebedor nao informado")
	@Size(min = 2, message = "cidade recebedor nao informado corretamente")
	private String cidade;

	@NotNull(message = "uf recebedor nao informado")
	@Size(min = 2, message = "uf recebedor nao informado corretamente")
	private String uf;

	@NotNull(message = "nome recebedor nao informado")
	@Size(min = 8, message = "nome recebedor nao informado corretamente")
	private String cep;

	public Recebedor() {}

	public Recebedor(String cpf, String nome, String logradouro, String cidade, String uf, String cep) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Recebedor(String cpf, String cnpj, String nome, String nomeFantasia, String logradouro, String cidade,
			String uf, String cep) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
