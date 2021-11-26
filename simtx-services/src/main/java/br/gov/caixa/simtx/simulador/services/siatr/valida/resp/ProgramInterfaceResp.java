package br.gov.caixa.simtx.simulador.services.siatr.valida.resp;
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
public class ProgramInterfaceResp {

    @XmlElement(name = "ws_atrwsvcl", required = true)
    protected WsAtrwsvclResp wsAtrwsvcl;

    public WsAtrwsvclResp getWsAtrwsvcl() {
        return wsAtrwsvcl;
    }

    public void setWsAtrwsvcl(WsAtrwsvclResp value) {
        this.wsAtrwsvcl = value;
    }

}
