package br.gov.caixa.simtx.simulador.services.pagamentospi.v5;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.gov.caixa.simtx.simulador.services.pagamentospi.v3.RequisicaoPagamentoSpiV3;

public class RequisicaoPagamentoSpiV5 extends RequisicaoPagamentoSpiV3 {

	@Digits(integer = 12, fraction = 2, message = "valorCompra invalido. espera-se <12 digitos>.<2 digitos>")
	private BigDecimal valorTarifa;

	@NotNull(message = "icContigenciaTarifa nao informada")
	@Max(value = 1, message = "icContigenciaTarifa deve ser informado e ter no maximo 1 caracter")
	private Integer icContingenciaTarifa;

	private ModalidadeAgenteEnum modalidadeAgente;

	@Size(max = 8, message = "cnpjIniciadorPagamento invalido, tamanho deve ser no maximo 14")
	private String prestadorDoServicoDeSaque;



	public BigDecimal getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(BigDecimal valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	public Integer getIcContigenciaTarifa() {
		return icContingenciaTarifa;
	}

	public void setIcContingenciaTarifa(Integer icContingenciaTarifa) {
		this.icContingenciaTarifa = icContingenciaTarifa;
	}

	public ModalidadeAgenteEnum getModalidadeAgente() {
		return modalidadeAgente;
	}

	public void setModalidadeAgente(ModalidadeAgenteEnum modalidadeAgente) {
		this.modalidadeAgente = modalidadeAgente;
	}

	public String getPrestadorDoServicoDeSaque() {
		return prestadorDoServicoDeSaque;
	}

	public void setPrestadorDoServicoDeSaque(String prestadorDoServicoDeSaque) {
		this.prestadorDoServicoDeSaque = prestadorDoServicoDeSaque;
	}

}
