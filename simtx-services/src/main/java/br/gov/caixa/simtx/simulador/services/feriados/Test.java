package br.gov.caixa.simtx.simulador.services.feriados;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import com.google.gson.Gson;

import br.gov.caixa.simtx.simulador.util.data.DataUtil;

public class Test {
	
	public static void main(String[] args) throws IOException {
		Calendar data = recuperarProximoDiaUtil();
		System.out.println(data.getTime());
	}
	
	public static Calendar recuperarProximoDiaUtil() throws IOException {
//		logger.debug("Recuperando proximo dia util");
		
		SimpleDateFormat formatDateXml = new SimpleDateFormat(DataUtil.FORMATO_DATA_XML);
		
		String resposta = "{\"feriados\":[{\"codigo\":143762,\"nome\":\"NATAL\",\"data\":\"2020-12-25\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2009-07-01 10:42:29.138057\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209775,\"nome\":\"CONFRATERNIZACAO UNIVERSAL\",\"data\":\"2021-01-01\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:04:28.439626\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":999999,\"nome\":\"SIMULADO\",\"data\":\"{DATA_SIMULADA}\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2021-01-22 10:06:51.689121\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209776,\"nome\":\"CARNAVAL\",\"data\":\"2021-02-15\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:06:51.689121\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209777,\"nome\":\"CARNAVAL\",\"data\":\"2021-02-16\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:08:52.339091\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209777,\"nome\":\"CARNAVAL\",\"data\":\"2021-02-18\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:08:52.339091\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209777,\"nome\":\"CARNAVAL\",\"data\":\"2021-02-19\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:08:52.339091\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209777,\"nome\":\"CARNAVAL\",\"data\":\"2021-02-22\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:08:52.339091\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209777,\"nome\":\"CARNAVAL\",\"data\":\"2021-02-23\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:08:52.339091\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209778,\"nome\":\"PAIXAO DE CRISTO\",\"data\":\"2021-04-02\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:12:51.076609\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209779,\"nome\":\"TIRADENTES\",\"data\":\"2021-04-21\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:13:36.805827\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209780,\"nome\":\"DIA DO TRABALHO\",\"data\":\"2021-05-01\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:14:20.937978\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209781,\"nome\":\"CORPUS CHRISTI\",\"data\":\"2021-06-03\",\"modalidade\":\"CALCULADO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:16:30.572859\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209782,\"nome\":\"INDEPENDENCIA DO BRASIL\",\"data\":\"2021-09-07\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:17:30.893880\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209783,\"nome\":\"NOSSA SENHORA APARECIDA\",\"data\":\"2021-10-12\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:20:09.652505\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209784,\"nome\":\"FINADOS\",\"data\":\"2021-11-02\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:20:58.687552\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"},{\"codigo\":209785,\"nome\":\"PROCLAMACAO DA REPUBLICA\",\"data\":\"2021-11-15\",\"modalidade\":\"FIXO\",\"origem\":\"MANUAL\",\"data_hora_inclusao\":\"2014-02-12 13:21:48.121939\",\"pais\":10,\"localidade\":0,\"abrangencia_geografica\":\"NACIONAL\"}]}";
		
		FeriadosVO feriados = new Gson().fromJson(resposta, FeriadosVO.class);
		
		Calendar dataUtil = DataUtil.getHojeSemHorario();
		
		Iterator<Feriados> iterator = feriados.getFeriados().iterator();
	    while (iterator.hasNext()) {
	    	String dataUtilFormatada = formatDateXml.format(dataUtil.getTime());
	    	
	    	if(verificarFinalDeSemana(dataUtil)) {
	    		dataUtil.add(Calendar.DAY_OF_MONTH, 1);
	    	}
	    	else {
	    		Feriados customer = iterator.next();
	    		if (dataUtilFormatada.equals(customer.getData())) {
	    			dataUtil.add(Calendar.DAY_OF_MONTH, 1);
	    		}
	    	}
	    }
		
//		while(Iterables.tryFind(feriados.getFeriados(), new Predicate<Feriados>() {
//			public boolean apply(Feriados feriado) {
//				return dataUtilFormatada.equals(feriado.getData());
//			}
//		}).orNull() != null) {
//			dataUtil.add(Calendar.DAY_OF_MONTH, 1);
//		}
//		
//		while(verificarFinalDeSemana(dataUtil)) {
//			dataUtil.add(Calendar.DAY_OF_MONTH, 1);
//			final String dataUtilFormat = formatDateXml.format(dataUtil.getTime());
//			
//			if(Iterables.tryFind(feriados.getFeriados(), new Predicate<Feriados>() {
//				public boolean apply(Feriados feriado) {
//					return dataUtilFormat.equals(feriado.getData());
//				}
//			}).orNull() != null) {
//				dataUtil.add(Calendar.DAY_OF_MONTH, 1);
//			}
//		}
		return dataUtil;
	}
	
	public static boolean verificarFinalDeSemana(Calendar data) {
		return data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
	}

}
