package br.gov.caixa.simtx.simulador.services.sitax;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dados_saida_negocial_type", propOrder = {
    "formaRecebimento", "valorNominal", "dataVencimento"
})
public class ConsultaRegrasBoletoDadosSaida {

    @XmlElement(name = "FORMA_RECEBIMENTO", required = true)
    @XmlSchemaType(name = "string")
    protected String formaRecebimento;

    @XmlElement(name = "VALOR_NOMINAL")
    protected BigDecimal valorNominal;
    
    @XmlElement(name = "DATA_VENCIMENTO")
    @XmlSchemaType(name = "string")
    protected String dataVencimento;

    
    
    public String getFormaRecebimento() {
		return formaRecebimento;
	}

	public void setFormaRecebimento(String formaRecebimento) {
		this.formaRecebimento = formaRecebimento;
	}

	public BigDecimal getValorNominal() {
		return valorNominal;
	}

	public void setValorNominal(BigDecimal valorNominal) {
		this.valorNominal = valorNominal;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
}
