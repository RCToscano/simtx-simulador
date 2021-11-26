
package br.gov.caixa.simtx.simulador.services.siatr.valida.resp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactoryResp {

    public ProgramInterfaceResp createProgramInterface() {
        return new ProgramInterfaceResp();
    }

    public WsAtrwsvclResp createWsAtrwsvcl() {
        return new WsAtrwsvclResp();
    }

    public WsvclSaida createProgramInterfaceWsAtrwsvclWsvclSaida() {
        return new WsvclSaida();
    }

    @XmlElementDecl(namespace = "http://caixa.gov.br/siatr/limite/valida/resp", name = "validaResponse")
    public JAXBElement<ProgramInterfaceResp> createValidaResponse(ProgramInterfaceResp value) {
        return new JAXBElement<>(new QName("http://caixa.gov.br/siatr/limite/valida/resp", "validaResponse"), ProgramInterfaceResp.class, null, value);
    }

}
