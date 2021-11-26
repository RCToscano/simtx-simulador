
package br.gov.caixa.simtx.simulador.services.siatr.valida.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactoryReq {

    public ProgramInterfaceReq createProgramInterface() {
        return new ProgramInterfaceReq();
    }

    public WsAtrwsvclReq createWsAtrwsvcl() {
        return new WsAtrwsvclReq();
    }

    public WsvclEntrada createWsvclEntrada() {
        return new WsvclEntrada();
    }

    public WsvclEDadosDestino createWsvclEDadosDestino() {
        return new WsvclEDadosDestino();
    }

    public WsvclEDestinoPix createWsvclEDestinoPix() {
        return new WsvclEDestinoPix();
    }

    public WsvclEDestinoDoc createWsvclEDestinoDoc() {
        return new WsvclEDestinoDoc();
    }

    public WsvclEDestinoTed createWsvclEDestinoTed() {
        return new WsvclEDestinoTed();
    }

    public WsvclEDestinoTev createWsvclEDestinoTev() {
        return new WsvclEDestinoTev();
    }

    public WsvclEDestinoCsn createWsvclEDestinoCsn() {
        return new WsvclEDestinoCsn();
    }

    @XmlElementDecl(namespace = "http://caixa.gov.br/siatr/limite/valida/req", name = "valida")
    public JAXBElement<ProgramInterfaceReq> createValida(ProgramInterfaceReq value) {
        return new JAXBElement<>(new QName("http://caixa.gov.br/siatr/limite/valida/req", "valida"), ProgramInterfaceReq.class, null, value);
    }

}
