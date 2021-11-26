
package br.gov.caixa.simtx.simulador.services.siatr.valida.req;

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
    protected WsAtrwsvclReq wsAtrwsvcl;

    public WsAtrwsvclReq getWsAtrwsvcl() {
        return wsAtrwsvcl;
    }

    public void setWsAtrwsvcl(WsAtrwsvclReq value) {
        this.wsAtrwsvcl = value;
    }

}
