package br.gov.caixa.simtx.simulador.services.pagamentospi;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioRecebedor {

	@NotNull(message = "nome usuario recebedor nao informado")
	@Size(min = 3, message = "nome usuario recebedor nao informado corretamente")
	private String nome;

	@Min(value = 1, message = "cnpj recebedor deve ter 14 caracteres")
	@Max(value = 99999999999999l, message = "cnpj recebedor deve ter 14 caracteres")
	private Long cnpj;

	@Max(value = 99999999999l, message = "cpf recebedor deve ser informado e ter 11 caracteres")
	private Long cpf;

	@NotNull(message = "conta recebedor nao informada")
	@Valid
	private ContaSPI conta;



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public ContaSPI getConta() {
		return conta;
	}

	public void setConta(ContaSPI conta) {
		this.conta = conta;
	}

}
