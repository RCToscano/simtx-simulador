package br.gov.caixa.simtx.simulador.services.siatr.valida.resp;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclSCodRetorno",
    "wsvclSNsuSiatr",
    "wsvclSMsg",
    "wsvclSVrUsoCrot",
    "wsvclSNomeClienteTit",
    "wsvclSTipoPessoaTit",
    "wsvclSCpfCnpjConta",
    "wsvclSAgenciaMig",
    "wsvclSProdutoMig",
    "wsvclSContaMig",
    "wsvclSDvContaMig",
    "wsvclSDtContabil",
    "wsvclSSistemaOriginal",
    "wsvclSMarcaCgu",
    "wsvclSAgenciaRel",
    "wsvclSNomeClienteDest",
    "wsvclETipoPessoaDest",
    "wsvclSCpfCnpjContaDest"
})
public class WsvclSaida {
	
	@XmlElement(name = "wsvcl_s_cod_retorno")
    protected int wsvclSCodRetorno;
    @XmlElement(name = "wsvcl_s_nsu_siatr")
    protected long wsvclSNsuSiatr;
    @XmlElement(name = "wsvcl_s_msg", required = true)
    protected String wsvclSMsg;
    @XmlElement(name = "wsvcl_s_vr_uso_crot", required = true)
    protected BigDecimal wsvclSVrUsoCrot;
    @XmlElement(name = "wsvcl_s_nome_cliente_tit", required = true)
    protected String wsvclSNomeClienteTit;
    @XmlElement(name = "wsvcl_s_tipo_pessoa_tit")
    protected int wsvclSTipoPessoaTit;
    @XmlElement(name = "wsvcl_s_cpf_cnpj_conta")
    protected long wsvclSCpfCnpjConta;
    @XmlElement(name = "wsvcl_s_agencia_mig")
    protected int wsvclSAgenciaMig;
    @XmlElement(name = "wsvcl_s_produto_mig")
    protected int wsvclSProdutoMig;
    @XmlElement(name = "wsvcl_s_conta_mig")
    protected long wsvclSContaMig;
    @XmlElement(name = "wsvcl_s_dv_conta_mig")
    protected int wsvclSDvContaMig;
    @XmlElement(name = "wsvcl_s_dt_contabil")
    protected long wsvclSDtContabil;
    @XmlElement(name = "wsvcl_s_sistema_original", required = true)
    protected String wsvclSSistemaOriginal;
    @XmlElement(name = "wsvcl_s_marca_cgu")
    protected int wsvclSMarcaCgu;
    @XmlElement(name = "wsvcl_s_agencia_rel")
    protected int wsvclSAgenciaRel;
    @XmlElement(name = "wsvcl_s_nome_cliente_dest", required = true)
    protected String wsvclSNomeClienteDest;
    @XmlElement(name = "wsvcl_e_tipo_pessoa_dest")
    protected int wsvclETipoPessoaDest;
    @XmlElement(name = "wsvcl_s_cpf_cnpj_conta_dest")
    protected long wsvclSCpfCnpjContaDest;
    
	public int getWsvclSCodRetorno() {
		return wsvclSCodRetorno;
	}
	public void setWsvclSCodRetorno(int wsvclSCodRetorno) {
		this.wsvclSCodRetorno = wsvclSCodRetorno;
	}
	public long getWsvclSNsuSiatr() {
		return wsvclSNsuSiatr;
	}
	public void setWsvclSNsuSiatr(long wsvclSNsuSiatr) {
		this.wsvclSNsuSiatr = wsvclSNsuSiatr;
	}
	public String getWsvclSMsg() {
		return wsvclSMsg;
	}
	public void setWsvclSMsg(String wsvclSMsg) {
		this.wsvclSMsg = wsvclSMsg;
	}
	public BigDecimal getWsvclSVrUsoCrot() {
		return wsvclSVrUsoCrot;
	}
	public void setWsvclSVrUsoCrot(BigDecimal wsvclSVrUsoCrot) {
		this.wsvclSVrUsoCrot = wsvclSVrUsoCrot;
	}
	public String getWsvclSNomeClienteTit() {
		return wsvclSNomeClienteTit;
	}
	public void setWsvclSNomeClienteTit(String wsvclSNomeClienteTit) {
		this.wsvclSNomeClienteTit = wsvclSNomeClienteTit;
	}
	public int getWsvclSTipoPessoaTit() {
		return wsvclSTipoPessoaTit;
	}
	public void setWsvclSTipoPessoaTit(int wsvclSTipoPessoaTit) {
		this.wsvclSTipoPessoaTit = wsvclSTipoPessoaTit;
	}
	public long getWsvclSCpfCnpjConta() {
		return wsvclSCpfCnpjConta;
	}
	public void setWsvclSCpfCnpjConta(long wsvclSCpfCnpjConta) {
		this.wsvclSCpfCnpjConta = wsvclSCpfCnpjConta;
	}
	public int getWsvclSAgenciaMig() {
		return wsvclSAgenciaMig;
	}
	public void setWsvclSAgenciaMig(int wsvclSAgenciaMig) {
		this.wsvclSAgenciaMig = wsvclSAgenciaMig;
	}
	public int getWsvclSProdutoMig() {
		return wsvclSProdutoMig;
	}
	public void setWsvclSProdutoMig(int wsvclSProdutoMig) {
		this.wsvclSProdutoMig = wsvclSProdutoMig;
	}
	public long getWsvclSContaMig() {
		return wsvclSContaMig;
	}
	public void setWsvclSContaMig(long wsvclSContaMig) {
		this.wsvclSContaMig = wsvclSContaMig;
	}
	public int getWsvclSDvContaMig() {
		return wsvclSDvContaMig;
	}
	public void setWsvclSDvContaMig(int wsvclSDvContaMig) {
		this.wsvclSDvContaMig = wsvclSDvContaMig;
	}
	public long getWsvclSDtContabil() {
		return wsvclSDtContabil;
	}
	public void setWsvclSDtContabil(long wsvclSDtContabil) {
		this.wsvclSDtContabil = wsvclSDtContabil;
	}
	public String getWsvclSSistemaOriginal() {
		return wsvclSSistemaOriginal;
	}
	public void setWsvclSSistemaOriginal(String wsvclSSistemaOriginal) {
		this.wsvclSSistemaOriginal = wsvclSSistemaOriginal;
	}
	public int getWsvclSMarcaCgu() {
		return wsvclSMarcaCgu;
	}
	public void setWsvclSMarcaCgu(int wsvclSMarcaCgu) {
		this.wsvclSMarcaCgu = wsvclSMarcaCgu;
	}
	public int getWsvclSAgenciaRel() {
		return wsvclSAgenciaRel;
	}
	public void setWsvclSAgenciaRel(int wsvclSAgenciaRel) {
		this.wsvclSAgenciaRel = wsvclSAgenciaRel;
	}
	public String getWsvclSNomeClienteDest() {
		return wsvclSNomeClienteDest;
	}
	public void setWsvclSNomeClienteDest(String wsvclSNomeClienteDest) {
		this.wsvclSNomeClienteDest = wsvclSNomeClienteDest;
	}
	public int getWsvclETipoPessoaDest() {
		return wsvclETipoPessoaDest;
	}
	public void setWsvclETipoPessoaDest(int wsvclETipoPessoaDest) {
		this.wsvclETipoPessoaDest = wsvclETipoPessoaDest;
	}
	public long getWsvclSCpfCnpjContaDest() {
		return wsvclSCpfCnpjContaDest;
	}
	public void setWsvclSCpfCnpjContaDest(long wsvclSCpfCnpjContaDest) {
		this.wsvclSCpfCnpjContaDest = wsvclSCpfCnpjContaDest;
	}

    
}
