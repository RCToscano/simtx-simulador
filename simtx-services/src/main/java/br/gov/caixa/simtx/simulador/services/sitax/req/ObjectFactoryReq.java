
package br.gov.caixa.simtx.simulador.services.sitax.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.caixa.siatr.limite.valida.req package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactoryReq {

    private final static QName _Valida_QNAME = new QName("http://caixa.gov.br/siatr/limite/valida/req", "valida");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.caixa.siatr.limite.valida.req
     * 
     */
    public ObjectFactoryReq() {
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq }
     * 
     */
    public ProgramInterfaceReq createProgramInterface() {
        return new ProgramInterfaceReq();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl createProgramInterfaceWsAtrwsvcl() {
        return new ProgramInterfaceReq.WsAtrwsvcl();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada createProgramInterfaceWsAtrwsvclWsvclEntrada() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino createProgramInterfaceWsAtrwsvclWsvclEntradaWsvclEDadosDestino() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix createProgramInterfaceWsAtrwsvclWsvclEntradaWsvclEDadosDestinoWsvclEDestinoPix() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoPix();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc createProgramInterfaceWsAtrwsvclWsvclEntradaWsvclEDadosDestinoWsvclEDestinoDoc() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoDoc();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed createProgramInterfaceWsAtrwsvclWsvclEntradaWsvclEDadosDestinoWsvclEDestinoTed() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTed();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev createProgramInterfaceWsAtrwsvclWsvclEntradaWsvclEDadosDestinoWsvclEDestinoTev() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoTev();
    }

    /**
     * Create an instance of {@link ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn }
     * 
     */
    public ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn createProgramInterfaceWsAtrwsvclWsvclEntradaWsvclEDadosDestinoWsvclEDestinoCsn() {
        return new ProgramInterfaceReq.WsAtrwsvcl.WsvclEntrada.WsvclEDadosDestino.WsvclEDestinoCsn();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProgramInterfaceReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caixa.gov.br/siatr/limite/valida/req", name = "valida")
    public JAXBElement<ProgramInterfaceReq> createValida(ProgramInterfaceReq value) {
        return new JAXBElement<ProgramInterfaceReq>(_Valida_QNAME, ProgramInterfaceReq.class, null, value);
    }

}
