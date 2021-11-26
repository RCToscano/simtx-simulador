package br.gov.caixa.simtx.simulador.services.sitax.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclEFormaIniciacao",
    "wsvclETipoPessoa",
    "wsvclECpfCnpjRecebedor",
    "wsvclETipoChave",
    "wsvclEChaveRecebedor",
    "wsvclEIspbRecebedor",
    "wsvclEAgenciaRecebedor",
    "wsvclEProdutoRecebedor",
    "wsvclEContaRecebedor",
    "wsvclEDvContaRecebedor"
})
public class WsvclEDestinoPix {

	 @XmlElement(name = "wsvcl_e_forma_iniciacao")
     protected int wsvclEFormaIniciacao;
     @XmlElement(name = "wsvcl_e_tipo_pessoa")
     protected int wsvclETipoPessoa;
     @XmlElement(name = "wsvcl_e_cpf_cnpj_recebedor")
     protected long wsvclECpfCnpjRecebedor;
     @XmlElement(name = "wsvcl_e_tipo_chave")
     protected int wsvclETipoChave;
     @XmlElement(name = "wsvcl_e_chave_recebedor", required = true)
     protected String wsvclEChaveRecebedor;
     @XmlElement(name = "wsvcl_e_ispb_recebedor")
     protected long wsvclEIspbRecebedor;
     @XmlElement(name = "wsvcl_e_agencia_recebedor")
     protected int wsvclEAgenciaRecebedor;
     @XmlElement(name = "wsvcl_e_produto_recebedor")
     protected int wsvclEProdutoRecebedor;
     @XmlElement(name = "wsvcl_e_conta_recebedor", required = true)
     protected String wsvclEContaRecebedor;
     @XmlElement(name = "wsvcl_e_dv_conta_recebedor", required = true)
     protected String wsvclEDvContaRecebedor;
	public int getWsvclEFormaIniciacao() {
		return wsvclEFormaIniciacao;
	}
	public void setWsvclEFormaIniciacao(int wsvclEFormaIniciacao) {
		this.wsvclEFormaIniciacao = wsvclEFormaIniciacao;
	}
	public int getWsvclETipoPessoa() {
		return wsvclETipoPessoa;
	}
	public void setWsvclETipoPessoa(int wsvclETipoPessoa) {
		this.wsvclETipoPessoa = wsvclETipoPessoa;
	}
	public long getWsvclECpfCnpjRecebedor() {
		return wsvclECpfCnpjRecebedor;
	}
	public void setWsvclECpfCnpjRecebedor(long wsvclECpfCnpjRecebedor) {
		this.wsvclECpfCnpjRecebedor = wsvclECpfCnpjRecebedor;
	}
	public int getWsvclETipoChave() {
		return wsvclETipoChave;
	}
	public void setWsvclETipoChave(int wsvclETipoChave) {
		this.wsvclETipoChave = wsvclETipoChave;
	}
	public String getWsvclEChaveRecebedor() {
		return wsvclEChaveRecebedor;
	}
	public void setWsvclEChaveRecebedor(String wsvclEChaveRecebedor) {
		this.wsvclEChaveRecebedor = wsvclEChaveRecebedor;
	}
	public long getWsvclEIspbRecebedor() {
		return wsvclEIspbRecebedor;
	}
	public void setWsvclEIspbRecebedor(long wsvclEIspbRecebedor) {
		this.wsvclEIspbRecebedor = wsvclEIspbRecebedor;
	}
	public int getWsvclEAgenciaRecebedor() {
		return wsvclEAgenciaRecebedor;
	}
	public void setWsvclEAgenciaRecebedor(int wsvclEAgenciaRecebedor) {
		this.wsvclEAgenciaRecebedor = wsvclEAgenciaRecebedor;
	}
	public int getWsvclEProdutoRecebedor() {
		return wsvclEProdutoRecebedor;
	}
	public void setWsvclEProdutoRecebedor(int wsvclEProdutoRecebedor) {
		this.wsvclEProdutoRecebedor = wsvclEProdutoRecebedor;
	}
	public String getWsvclEContaRecebedor() {
		return wsvclEContaRecebedor;
	}
	public void setWsvclEContaRecebedor(String wsvclEContaRecebedor) {
		this.wsvclEContaRecebedor = wsvclEContaRecebedor;
	}
	public String getWsvclEDvContaRecebedor() {
		return wsvclEDvContaRecebedor;
	}
	public void setWsvclEDvContaRecebedor(String wsvclEDvContaRecebedor) {
		this.wsvclEDvContaRecebedor = wsvclEDvContaRecebedor;
	}
     
}
