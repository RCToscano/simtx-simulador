package br.gov.caixa.simtx.simulador.services.spi.pagamento;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Devedor {

	@NotNull(message = "cpf pagador nao informado")
	@Size(min = 11, max = 11, message = "cpf devedor deve ser informado e ter 11 caracteres")
	private String cpf;

	@Size(min = 14, max = 14, message = "cnpj devedor deve ter 14 caracteres")
	private String cnpj;

	@NotNull(message = "nome devedor nao informado")
	@Size(min = 3, message = "nome devedor nao informado corretamente")
	private String nome;

	public Devedor() {}

	public Devedor(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	public Devedor(String cpf, String cnpj, String nome) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.nome = nome;
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

}
