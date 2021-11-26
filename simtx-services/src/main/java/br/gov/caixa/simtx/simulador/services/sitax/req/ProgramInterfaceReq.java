
package br.gov.caixa.simtx.simulador.services.sitax.req;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "ProgramInterface")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramInterface", propOrder = {
    "wsAtrwsvcl"
})
public class ProgramInterfaceReq {

    @XmlElement(name = "ws_atrwsvcl", required = true)
    protected ProgramInterfaceReq.WsAtrwsvcl wsAtrwsvcl;

    public ProgramInterfaceReq.WsAtrwsvcl getWsAtrwsvcl() {
        return wsAtrwsvcl;
    }

    public void setWsAtrwsvcl(ProgramInterfaceReq.WsAtrwsvcl value) {
        this.wsAtrwsvcl = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "wsvclEntrada"
    })
    public static class WsAtrwsvcl {

        @XmlElement(name = "wsvcl_entrada", required = true)
        protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada wsvclEntrada;

        /**
         * Obt�m o valor da propriedade wsvclEntrada.
         * 
         * @return
         *     possible object is
         *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada }
         *     
         */
        public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada getWsvclEntrada() {
            return wsvclEntrada;
        }

        /**
         * Define o valor da propriedade wsvclEntrada.
         * 
         * @param value
         *     allowed object is
         *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada }
         *     
         */
        public void setWsvclEntrada(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada value) {
            this.wsvclEntrada = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "wsvclEVersao",
            "wsvclETipoSolicitacao",
            "wsvclESiglaServ",
            "wsvclESgCanalOrigem",
            "wsvclENuNsuMtx",
            "wsvclEAgencia",
            "wsvclEProduto",
            "wsvclEConta",
            "wsvclEDvConta",
            "wsvclEVrTransacao",
            "wsvclEVrTarifa",
            "wsvclEDtTransacao",
            "wsvclEDtMovimento",
            "wsvclETpAutenticacao",
            "wsvclETitularTrans",
            "wsvclECpfCnpjTitTran",
            "wsvclEIcAgendamento",
            "wsvclEDadosDestino"
        })
        public static class WsvclEntrada {

            @XmlElement(name = "wsvcl_e_versao")
            protected int wsvclEVersao;
            @XmlElement(name = "wsvcl_e_tipo_solicitacao")
            protected int wsvclETipoSolicitacao;
            @XmlElement(name = "wsvcl_e_sigla_serv", required = true)
            protected String wsvclESiglaServ;
            @XmlElement(name = "wsvcl_e_sg_canal_origem", required = true)
            protected String wsvclESgCanalOrigem;
            @XmlElement(name = "wsvcl_e_nu_nsu_mtx")
            protected long wsvclENuNsuMtx;
            @XmlElement(name = "wsvcl_e_agencia")
            protected int wsvclEAgencia;
            @XmlElement(name = "wsvcl_e_produto")
            protected int wsvclEProduto;
            @XmlElement(name = "wsvcl_e_conta")
            protected long wsvclEConta;
            @XmlElement(name = "wsvcl_e_dv_conta")
            protected int wsvclEDvConta;
            @XmlElement(name = "wsvcl_e_vr_transacao", required = true)
            protected BigDecimal wsvclEVrTransacao;
            @XmlElement(name = "wsvcl_e_vr_tarifa", required = true)
            protected BigDecimal wsvclEVrTarifa;
            @XmlElement(name = "wsvcl_e_dt_transacao")
            protected long wsvclEDtTransacao;
            @XmlElement(name = "wsvcl_e_dt_movimento")
            protected long wsvclEDtMovimento;
            @XmlElement(name = "wsvcl_e_tp_autenticacao")
            protected int wsvclETpAutenticacao;
            @XmlElement(name = "wsvcl_e_titular_trans")
            protected int wsvclETitularTrans;
            @XmlElement(name = "wsvcl_e_cpf_cnpj_tit_tran")
            protected Long wsvclECpfCnpjTitTran;
            @XmlElement(name = "wsvcl_e_ic_agendamento")
            protected int wsvclEIcAgendamento;
            @XmlElement(name = "wsvcl_e_dados_destino", required = true)
            protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino wsvclEDadosDestino;

            /**
             * Obt�m o valor da propriedade wsvclEVersao.
             * 
             */
            public int getWsvclEVersao() {
                return wsvclEVersao;
            }

            /**
             * Define o valor da propriedade wsvclEVersao.
             * 
             */
            public void setWsvclEVersao(int value) {
                this.wsvclEVersao = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclETipoSolicitacao.
             * 
             */
            public int getWsvclETipoSolicitacao() {
                return wsvclETipoSolicitacao;
            }

            /**
             * Define o valor da propriedade wsvclETipoSolicitacao.
             * 
             */
            public void setWsvclETipoSolicitacao(int value) {
                this.wsvclETipoSolicitacao = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclESiglaServ.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWsvclESiglaServ() {
                return wsvclESiglaServ;
            }

            /**
             * Define o valor da propriedade wsvclESiglaServ.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWsvclESiglaServ(String value) {
                this.wsvclESiglaServ = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclESgCanalOrigem.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWsvclESgCanalOrigem() {
                return wsvclESgCanalOrigem;
            }

            /**
             * Define o valor da propriedade wsvclESgCanalOrigem.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWsvclESgCanalOrigem(String value) {
                this.wsvclESgCanalOrigem = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclENuNsuMtx.
             * 
             */
            public long getWsvclENuNsuMtx() {
                return wsvclENuNsuMtx;
            }

            /**
             * Define o valor da propriedade wsvclENuNsuMtx.
             * 
             */
            public void setWsvclENuNsuMtx(long value) {
                this.wsvclENuNsuMtx = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEAgencia.
             * 
             */
            public int getWsvclEAgencia() {
                return wsvclEAgencia;
            }

            /**
             * Define o valor da propriedade wsvclEAgencia.
             * 
             */
            public void setWsvclEAgencia(int value) {
                this.wsvclEAgencia = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEProduto.
             * 
             */
            public int getWsvclEProduto() {
                return wsvclEProduto;
            }

            /**
             * Define o valor da propriedade wsvclEProduto.
             * 
             */
            public void setWsvclEProduto(int value) {
                this.wsvclEProduto = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEConta.
             * 
             */
            public long getWsvclEConta() {
                return wsvclEConta;
            }

            /**
             * Define o valor da propriedade wsvclEConta.
             * 
             */
            public void setWsvclEConta(long value) {
                this.wsvclEConta = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEDvConta.
             * 
             */
            public int getWsvclEDvConta() {
                return wsvclEDvConta;
            }

            /**
             * Define o valor da propriedade wsvclEDvConta.
             * 
             */
            public void setWsvclEDvConta(int value) {
                this.wsvclEDvConta = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEVrTransacao.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getWsvclEVrTransacao() {
                return wsvclEVrTransacao;
            }

            /**
             * Define o valor da propriedade wsvclEVrTransacao.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setWsvclEVrTransacao(BigDecimal value) {
                this.wsvclEVrTransacao = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEVrTarifa.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getWsvclEVrTarifa() {
                return wsvclEVrTarifa;
            }

            /**
             * Define o valor da propriedade wsvclEVrTarifa.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setWsvclEVrTarifa(BigDecimal value) {
                this.wsvclEVrTarifa = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEDtTransacao.
             * 
             */
            public long getWsvclEDtTransacao() {
                return wsvclEDtTransacao;
            }

            /**
             * Define o valor da propriedade wsvclEDtTransacao.
             * 
             */
            public void setWsvclEDtTransacao(long value) {
                this.wsvclEDtTransacao = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEDtMovimento.
             * 
             */
            public long getWsvclEDtMovimento() {
                return wsvclEDtMovimento;
            }

            /**
             * Define o valor da propriedade wsvclEDtMovimento.
             * 
             */
            public void setWsvclEDtMovimento(long value) {
                this.wsvclEDtMovimento = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclETpAutenticacao.
             * 
             */
            public int getWsvclETpAutenticacao() {
                return wsvclETpAutenticacao;
            }

            /**
             * Define o valor da propriedade wsvclETpAutenticacao.
             * 
             */
            public void setWsvclETpAutenticacao(int value) {
                this.wsvclETpAutenticacao = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclETitularTrans.
             * 
             */
            public int getWsvclETitularTrans() {
                return wsvclETitularTrans;
            }

            /**
             * Define o valor da propriedade wsvclETitularTrans.
             * 
             */
            public void setWsvclETitularTrans(int value) {
                this.wsvclETitularTrans = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclECpfCnpjTitTran.
             * 
             */
            public Long getWsvclECpfCnpjTitTran() {
                return wsvclECpfCnpjTitTran;
            }

            /**
             * Define o valor da propriedade wsvclECpfCnpjTitTran.
             * 
             */
            public void setWsvclECpfCnpjTitTran(Long value) {
                this.wsvclECpfCnpjTitTran = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEIcAgendamento.
             * 
             */
            public int getWsvclEIcAgendamento() {
                return wsvclEIcAgendamento;
            }

            /**
             * Define o valor da propriedade wsvclEIcAgendamento.
             * 
             */
            public void setWsvclEIcAgendamento(int value) {
                this.wsvclEIcAgendamento = value;
            }

            /**
             * Obt�m o valor da propriedade wsvclEDadosDestino.
             * 
             * @return
             *     possible object is
             *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino }
             *     
             */
            public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino getWsvclEDadosDestino() {
                return wsvclEDadosDestino;
            }

            /**
             * Define o valor da propriedade wsvclEDadosDestino.
             * 
             * @param value
             *     allowed object is
             *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino }
             *     
             */
            public void setWsvclEDadosDestino(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino value) {
                this.wsvclEDadosDestino = value;
            }


            /**
             * <p>Classe Java de anonymous complex type.
             * 
             * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="wsvcl_e_destino_pix">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="wsvcl_e_forma_iniciacao">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="99"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_tipo_pessoa">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_cpf_cnpj_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;maxInclusive value="99999999999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_tipo_chave">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="99"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_chave_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="80"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_ispb_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
             *                         &lt;maxInclusive value="99999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_agencia_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_produto_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_conta_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="20"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_dv_conta_recebedor">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="2"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="wsvcl_e_destino_doc">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="wsvcl_e_banco_destino">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_agencia_destino">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_conta_destino">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;maxInclusive value="999999999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_dv_conta_destino">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="2"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_tp_pessoa_doc">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_cpf_cnpj_doc">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;maxInclusive value="99999999999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="wsvcl_e_destino_ted">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="wsvcl_e_ispb_destino">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
             *                         &lt;maxInclusive value="99999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_agencia_dest_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_conta_dest_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;maxInclusive value="999999999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_dv_conta_dest_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="2"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_tipo_conta_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="1"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_conta_pagamento">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="20"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_tp_pessoa_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_cpf_cnpj_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;maxInclusive value="99999999999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_tipo_ted">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="6"/>
             *                         &lt;whiteSpace value="collapse"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="wsvcl_e_destino_tev">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="wsvcl_e_agencia_dest_tev">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_produto_dest_tev">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_conta_dest_tev">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;maxInclusive value="999999999999"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="wsvcl_e_dv_conta_dest_tev">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="wsvcl_e_destino_csn">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="wsvcl_e_segmento_con">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
             *                         &lt;maxInclusive value="9"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "wsvclEDestinoPix",
                "wsvclEDestinoDoc",
                "wsvclEDestinoTed",
                "wsvclEDestinoTev",
                "wsvclEDestinoCsn"
            })
            public static class WsvclEDadosDestino {

                @XmlElement(name = "wsvcl_e_destino_pix", required = true)
                protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix wsvclEDestinoPix;
                @XmlElement(name = "wsvcl_e_destino_doc", required = true)
                protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc wsvclEDestinoDoc;
                @XmlElement(name = "wsvcl_e_destino_ted", required = true)
                protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed wsvclEDestinoTed;
                @XmlElement(name = "wsvcl_e_destino_tev", required = true)
                protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev wsvclEDestinoTev;
                @XmlElement(name = "wsvcl_e_destino_csn", required = true)
                protected ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn wsvclEDestinoCsn;

                /**
                 * Obt�m o valor da propriedade wsvclEDestinoPix.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix }
                 *     
                 */
                public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix getWsvclEDestinoPix() {
                    return wsvclEDestinoPix;
                }

                /**
                 * Define o valor da propriedade wsvclEDestinoPix.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix }
                 *     
                 */
                public void setWsvclEDestinoPix(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix value) {
                    this.wsvclEDestinoPix = value;
                }

                /**
                 * Obt�m o valor da propriedade wsvclEDestinoDoc.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc }
                 *     
                 */
                public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc getWsvclEDestinoDoc() {
                    return wsvclEDestinoDoc;
                }

                /**
                 * Define o valor da propriedade wsvclEDestinoDoc.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc }
                 *     
                 */
                public void setWsvclEDestinoDoc(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc value) {
                    this.wsvclEDestinoDoc = value;
                }

                /**
                 * Obt�m o valor da propriedade wsvclEDestinoTed.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed }
                 *     
                 */
                public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed getWsvclEDestinoTed() {
                    return wsvclEDestinoTed;
                }

                /**
                 * Define o valor da propriedade wsvclEDestinoTed.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed }
                 *     
                 */
                public void setWsvclEDestinoTed(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed value) {
                    this.wsvclEDestinoTed = value;
                }

                /**
                 * Obt�m o valor da propriedade wsvclEDestinoTev.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev }
                 *     
                 */
                public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev getWsvclEDestinoTev() {
                    return wsvclEDestinoTev;
                }

                /**
                 * Define o valor da propriedade wsvclEDestinoTev.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev }
                 *     
                 */
                public void setWsvclEDestinoTev(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev value) {
                    this.wsvclEDestinoTev = value;
                }

                /**
                 * Obt�m o valor da propriedade wsvclEDestinoCsn.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn }
                 *     
                 */
                public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn getWsvclEDestinoCsn() {
                    return wsvclEDestinoCsn;
                }

                /**
                 * Define o valor da propriedade wsvclEDestinoCsn.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn }
                 *     
                 */
                public void setWsvclEDestinoCsn(ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn value) {
                    this.wsvclEDestinoCsn = value;
                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="wsvcl_e_segmento_con">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "wsvclESegmentoCon"
                })
                public static class WsvclEDestinoCsn {

                    @XmlElement(name = "wsvcl_e_segmento_con")
                    protected int wsvclESegmentoCon;

                    /**
                     * Obt�m o valor da propriedade wsvclESegmentoCon.
                     * 
                     */
                    public int getWsvclESegmentoCon() {
                        return wsvclESegmentoCon;
                    }

                    /**
                     * Define o valor da propriedade wsvclESegmentoCon.
                     * 
                     */
                    public void setWsvclESegmentoCon(int value) {
                        this.wsvclESegmentoCon = value;
                    }

                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="wsvcl_e_banco_destino">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_agencia_destino">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_conta_destino">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;maxInclusive value="999999999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_dv_conta_destino">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="2"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_tp_pessoa_doc">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_cpf_cnpj_doc">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;maxInclusive value="99999999999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "wsvclEBancoDestino",
                    "wsvclEAgenciaDestino",
                    "wsvclEContaDestino",
                    "wsvclEDvContaDestino",
                    "wsvclETpPessoaDoc",
                    "wsvclECpfCnpjDoc"
                })
                public static class WsvclEDestinoDoc {

                    @XmlElement(name = "wsvcl_e_banco_destino")
                    protected int wsvclEBancoDestino;
                    @XmlElement(name = "wsvcl_e_agencia_destino")
                    protected int wsvclEAgenciaDestino;
                    @XmlElement(name = "wsvcl_e_conta_destino")
                    protected long wsvclEContaDestino;
                    @XmlElement(name = "wsvcl_e_dv_conta_destino", required = true)
                    protected String wsvclEDvContaDestino;
                    @XmlElement(name = "wsvcl_e_tp_pessoa_doc")
                    protected int wsvclETpPessoaDoc;
                    @XmlElement(name = "wsvcl_e_cpf_cnpj_doc")
                    protected long wsvclECpfCnpjDoc;

                    /**
                     * Obt�m o valor da propriedade wsvclEBancoDestino.
                     * 
                     */
                    public int getWsvclEBancoDestino() {
                        return wsvclEBancoDestino;
                    }

                    /**
                     * Define o valor da propriedade wsvclEBancoDestino.
                     * 
                     */
                    public void setWsvclEBancoDestino(int value) {
                        this.wsvclEBancoDestino = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEAgenciaDestino.
                     * 
                     */
                    public int getWsvclEAgenciaDestino() {
                        return wsvclEAgenciaDestino;
                    }

                    /**
                     * Define o valor da propriedade wsvclEAgenciaDestino.
                     * 
                     */
                    public void setWsvclEAgenciaDestino(int value) {
                        this.wsvclEAgenciaDestino = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEContaDestino.
                     * 
                     */
                    public long getWsvclEContaDestino() {
                        return wsvclEContaDestino;
                    }

                    /**
                     * Define o valor da propriedade wsvclEContaDestino.
                     * 
                     */
                    public void setWsvclEContaDestino(long value) {
                        this.wsvclEContaDestino = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEDvContaDestino.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclEDvContaDestino() {
                        return wsvclEDvContaDestino;
                    }

                    /**
                     * Define o valor da propriedade wsvclEDvContaDestino.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclEDvContaDestino(String value) {
                        this.wsvclEDvContaDestino = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclETpPessoaDoc.
                     * 
                     */
                    public int getWsvclETpPessoaDoc() {
                        return wsvclETpPessoaDoc;
                    }

                    /**
                     * Define o valor da propriedade wsvclETpPessoaDoc.
                     * 
                     */
                    public void setWsvclETpPessoaDoc(int value) {
                        this.wsvclETpPessoaDoc = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclECpfCnpjDoc.
                     * 
                     */
                    public long getWsvclECpfCnpjDoc() {
                        return wsvclECpfCnpjDoc;
                    }

                    /**
                     * Define o valor da propriedade wsvclECpfCnpjDoc.
                     * 
                     */
                    public void setWsvclECpfCnpjDoc(long value) {
                        this.wsvclECpfCnpjDoc = value;
                    }

                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="wsvcl_e_forma_iniciacao">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="99"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_tipo_pessoa">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_cpf_cnpj_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;maxInclusive value="99999999999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_tipo_chave">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="99"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_chave_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="80"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_ispb_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
                 *               &lt;maxInclusive value="99999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_agencia_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_produto_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_conta_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="20"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_dv_conta_recebedor">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="2"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
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
                public static class WsvclEDestinoPix {

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

                    /**
                     * Obt�m o valor da propriedade wsvclEFormaIniciacao.
                     * 
                     */
                    public int getWsvclEFormaIniciacao() {
                        return wsvclEFormaIniciacao;
                    }

                    /**
                     * Define o valor da propriedade wsvclEFormaIniciacao.
                     * 
                     */
                    public void setWsvclEFormaIniciacao(int value) {
                        this.wsvclEFormaIniciacao = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclETipoPessoa.
                     * 
                     */
                    public int getWsvclETipoPessoa() {
                        return wsvclETipoPessoa;
                    }

                    /**
                     * Define o valor da propriedade wsvclETipoPessoa.
                     * 
                     */
                    public void setWsvclETipoPessoa(int value) {
                        this.wsvclETipoPessoa = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclECpfCnpjRecebedor.
                     * 
                     */
                    public long getWsvclECpfCnpjRecebedor() {
                        return wsvclECpfCnpjRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclECpfCnpjRecebedor.
                     * 
                     */
                    public void setWsvclECpfCnpjRecebedor(long value) {
                        this.wsvclECpfCnpjRecebedor = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclETipoChave.
                     * 
                     */
                    public int getWsvclETipoChave() {
                        return wsvclETipoChave;
                    }

                    /**
                     * Define o valor da propriedade wsvclETipoChave.
                     * 
                     */
                    public void setWsvclETipoChave(int value) {
                        this.wsvclETipoChave = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEChaveRecebedor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclEChaveRecebedor() {
                        return wsvclEChaveRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclEChaveRecebedor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclEChaveRecebedor(String value) {
                        this.wsvclEChaveRecebedor = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEIspbRecebedor.
                     * 
                     */
                    public long getWsvclEIspbRecebedor() {
                        return wsvclEIspbRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclEIspbRecebedor.
                     * 
                     */
                    public void setWsvclEIspbRecebedor(long value) {
                        this.wsvclEIspbRecebedor = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEAgenciaRecebedor.
                     * 
                     */
                    public int getWsvclEAgenciaRecebedor() {
                        return wsvclEAgenciaRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclEAgenciaRecebedor.
                     * 
                     */
                    public void setWsvclEAgenciaRecebedor(int value) {
                        this.wsvclEAgenciaRecebedor = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEProdutoRecebedor.
                     * 
                     */
                    public int getWsvclEProdutoRecebedor() {
                        return wsvclEProdutoRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclEProdutoRecebedor.
                     * 
                     */
                    public void setWsvclEProdutoRecebedor(int value) {
                        this.wsvclEProdutoRecebedor = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEContaRecebedor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclEContaRecebedor() {
                        return wsvclEContaRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclEContaRecebedor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclEContaRecebedor(String value) {
                        this.wsvclEContaRecebedor = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEDvContaRecebedor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclEDvContaRecebedor() {
                        return wsvclEDvContaRecebedor;
                    }

                    /**
                     * Define o valor da propriedade wsvclEDvContaRecebedor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclEDvContaRecebedor(String value) {
                        this.wsvclEDvContaRecebedor = value;
                    }

                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="wsvcl_e_ispb_destino">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
                 *               &lt;maxInclusive value="99999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_agencia_dest_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_conta_dest_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;maxInclusive value="999999999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_dv_conta_dest_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="2"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_tipo_conta_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="1"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_conta_pagamento">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="20"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_tp_pessoa_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_cpf_cnpj_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;maxInclusive value="99999999999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_tipo_ted">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="6"/>
                 *               &lt;whiteSpace value="collapse"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "wsvclEIspbDestino",
                    "wsvclEAgenciaDestTed",
                    "wsvclEContaDestTed",
                    "wsvclEDvContaDestTed",
                    "wsvclETipoContaTed",
                    "wsvclEContaPagamento",
                    "wsvclETpPessoaTed",
                    "wsvclECpfCnpjTed",
                    "wsvclETipoTed"
                })
                public static class WsvclEDestinoTed {

                    @XmlElement(name = "wsvcl_e_ispb_destino")
                    protected long wsvclEIspbDestino;
                    @XmlElement(name = "wsvcl_e_agencia_dest_ted")
                    protected int wsvclEAgenciaDestTed;
                    @XmlElement(name = "wsvcl_e_conta_dest_ted")
                    protected long wsvclEContaDestTed;
                    @XmlElement(name = "wsvcl_e_dv_conta_dest_ted", required = true)
                    protected String wsvclEDvContaDestTed;
                    @XmlElement(name = "wsvcl_e_tipo_conta_ted", required = true)
                    protected String wsvclETipoContaTed;
                    @XmlElement(name = "wsvcl_e_conta_pagamento", required = true)
                    protected String wsvclEContaPagamento;
                    @XmlElement(name = "wsvcl_e_tp_pessoa_ted")
                    protected int wsvclETpPessoaTed;
                    @XmlElement(name = "wsvcl_e_cpf_cnpj_ted")
                    protected long wsvclECpfCnpjTed;
                    @XmlElement(name = "wsvcl_e_tipo_ted", required = true)
                    protected String wsvclETipoTed;

                    /**
                     * Obt�m o valor da propriedade wsvclEIspbDestino.
                     * 
                     */
                    public long getWsvclEIspbDestino() {
                        return wsvclEIspbDestino;
                    }

                    /**
                     * Define o valor da propriedade wsvclEIspbDestino.
                     * 
                     */
                    public void setWsvclEIspbDestino(long value) {
                        this.wsvclEIspbDestino = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEAgenciaDestTed.
                     * 
                     */
                    public int getWsvclEAgenciaDestTed() {
                        return wsvclEAgenciaDestTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclEAgenciaDestTed.
                     * 
                     */
                    public void setWsvclEAgenciaDestTed(int value) {
                        this.wsvclEAgenciaDestTed = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEContaDestTed.
                     * 
                     */
                    public long getWsvclEContaDestTed() {
                        return wsvclEContaDestTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclEContaDestTed.
                     * 
                     */
                    public void setWsvclEContaDestTed(long value) {
                        this.wsvclEContaDestTed = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEDvContaDestTed.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclEDvContaDestTed() {
                        return wsvclEDvContaDestTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclEDvContaDestTed.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclEDvContaDestTed(String value) {
                        this.wsvclEDvContaDestTed = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclETipoContaTed.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclETipoContaTed() {
                        return wsvclETipoContaTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclETipoContaTed.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclETipoContaTed(String value) {
                        this.wsvclETipoContaTed = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEContaPagamento.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclEContaPagamento() {
                        return wsvclEContaPagamento;
                    }

                    /**
                     * Define o valor da propriedade wsvclEContaPagamento.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclEContaPagamento(String value) {
                        this.wsvclEContaPagamento = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclETpPessoaTed.
                     * 
                     */
                    public int getWsvclETpPessoaTed() {
                        return wsvclETpPessoaTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclETpPessoaTed.
                     * 
                     */
                    public void setWsvclETpPessoaTed(int value) {
                        this.wsvclETpPessoaTed = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclECpfCnpjTed.
                     * 
                     */
                    public long getWsvclECpfCnpjTed() {
                        return wsvclECpfCnpjTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclECpfCnpjTed.
                     * 
                     */
                    public void setWsvclECpfCnpjTed(long value) {
                        this.wsvclECpfCnpjTed = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclETipoTed.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getWsvclETipoTed() {
                        return wsvclETipoTed;
                    }

                    /**
                     * Define o valor da propriedade wsvclETipoTed.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setWsvclETipoTed(String value) {
                        this.wsvclETipoTed = value;
                    }

                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="wsvcl_e_agencia_dest_tev">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_produto_dest_tev">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_conta_dest_tev">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;maxInclusive value="999999999999"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="wsvcl_e_dv_conta_dest_tev">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
                 *               &lt;maxInclusive value="9"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "wsvclEAgenciaDestTev",
                    "wsvclEProdutoDestTev",
                    "wsvclEContaDestTev",
                    "wsvclEDvContaDestTev"
                })
                public static class WsvclEDestinoTev {

                    @XmlElement(name = "wsvcl_e_agencia_dest_tev")
                    protected int wsvclEAgenciaDestTev;
                    @XmlElement(name = "wsvcl_e_produto_dest_tev")
                    protected int wsvclEProdutoDestTev;
                    @XmlElement(name = "wsvcl_e_conta_dest_tev")
                    protected long wsvclEContaDestTev;
                    @XmlElement(name = "wsvcl_e_dv_conta_dest_tev")
                    protected int wsvclEDvContaDestTev;

                    /**
                     * Obt�m o valor da propriedade wsvclEAgenciaDestTev.
                     * 
                     */
                    public int getWsvclEAgenciaDestTev() {
                        return wsvclEAgenciaDestTev;
                    }

                    /**
                     * Define o valor da propriedade wsvclEAgenciaDestTev.
                     * 
                     */
                    public void setWsvclEAgenciaDestTev(int value) {
                        this.wsvclEAgenciaDestTev = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEProdutoDestTev.
                     * 
                     */
                    public int getWsvclEProdutoDestTev() {
                        return wsvclEProdutoDestTev;
                    }

                    /**
                     * Define o valor da propriedade wsvclEProdutoDestTev.
                     * 
                     */
                    public void setWsvclEProdutoDestTev(int value) {
                        this.wsvclEProdutoDestTev = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEContaDestTev.
                     * 
                     */
                    public long getWsvclEContaDestTev() {
                        return wsvclEContaDestTev;
                    }

                    /**
                     * Define o valor da propriedade wsvclEContaDestTev.
                     * 
                     */
                    public void setWsvclEContaDestTev(long value) {
                        this.wsvclEContaDestTev = value;
                    }

                    /**
                     * Obt�m o valor da propriedade wsvclEDvContaDestTev.
                     * 
                     */
                    public int getWsvclEDvContaDestTev() {
                        return wsvclEDvContaDestTev;
                    }

                    /**
                     * Define o valor da propriedade wsvclEDvContaDestTev.
                     * 
                     */
                    public void setWsvclEDvContaDestTev(int value) {
                        this.wsvclEDvContaDestTev = value;
                    }

                }

            }

        }

    }

}
