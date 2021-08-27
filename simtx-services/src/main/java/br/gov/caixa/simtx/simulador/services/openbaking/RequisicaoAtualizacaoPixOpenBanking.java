package br.gov.caixa.simtx.simulador.services.openbaking;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequisicaoAtualizacaoPixOpenBanking {

	@NotNull(message = "endToEndId nao informado")
	@Size(min = 32, max = 32, message = "endToEndId nao informado corretamente. espera ExxxxxxxxyyyyMMddHHmmkkkkkkkkkkk")
	private String endToEndId;
	
	private String status;
	
	private String rejectionReason;

	public String getEndToEndId() {
		return endToEndId;
	}

	public void setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	
	
}
