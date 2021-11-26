package br.gov.caixa.simtx.simulador.services.sitax.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsvclESegmentoCon"
})
public class WsvclEDestinoCsn {

	@XmlElement(name = "wsvcl_e_segmento_con")
    protected int wsvclESegmentoCon;

	public int getWsvclESegmentoCon() {
		return wsvclESegmentoCon;
	}

	public void setWsvclESegmentoCon(int wsvclESegmentoCon) {
		this.wsvclESegmentoCon = wsvclESegmentoCon;
	}
	
}
