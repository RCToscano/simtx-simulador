/*******************************************************************************
 * Copyright (C)  2017 - CAIXA Econômica Federal 
 * 
 * Todos os direitos reservados
 ******************************************************************************/
package br.gov.caixa.simtx.simulador.util.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class DataUtil {
	
	public static final String FORMATO_DATA_XML = "yyyy-MM-dd";
	public static final String FORMATO_DATA_PADRAO_BR = "dd/MM/yyyy";
	public static final String FORMATO_DATA_PADRAO_BR_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
	public static final String FORMATO_DATA_YYYY_MM_DD_HH_MM_TIME = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FORMATO_DATA_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String FORMATO_DATA_YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";
	public static final String FORMATO_DATA_YYYY_MM_DD = "yyyyMMdd";
	public static final String FORMATO_HORA_HH_MM_SS = "HH:mm:ss";
	public static final String FORMATO_HORA_HH_MM = "HH:mm";
	
	
	private DataUtil() throws IllegalAccessException {
		throw new IllegalAccessException("Class DataUtil");
	}
	
	public static Calendar getHojeCalendar() {
		Calendar hoje = Calendar.getInstance(TimeZone.getDefault());
		hoje.set(Calendar.HOUR_OF_DAY, 23);
		hoje.set(Calendar.MINUTE, 59);
		hoje.set(Calendar.SECOND, 59);
		return hoje;
	}


	public static SimpleDateFormat simpleDateFormat(String format) {
		return new SimpleDateFormat(format);
	}

	public static Timestamp getDataAtual() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * Retorna a data anterior à data de referência informada.
	 * 
	 */
	public static Timestamp getDataAnterior(Date dataReferencia) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataReferencia);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * Retorna a data posterior à data de referência informada.
	 * 
	 */
	public static Timestamp getDataPosterior(Date dataReferencia) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataReferencia);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 000);

		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * Retorna a da formatada no padrão brasileiro.
	 * 
	 */
	public static String getDataFormatadaPadraoBR(Date data) {

		return formatar(data, FORMATO_DATA_PADRAO_BR);
	}

	/**
	 * Formata a data para o formato informado.
	 * 
	 */
	public static String formatar(Date data, String formato) {

		DateFormat df = new SimpleDateFormat(formato);

		return df.format(data);
	}

	public static String obterDataFormatada(Date data, String pattern) {
		String dataFormatada = null;

		if (data != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;
	}

	public static Date obterDataFutura(int qtdDias) {
		Calendar dataFutura = Calendar.getInstance();
		return obterDataFutura(dataFutura, qtdDias);
	}
	
	public static Date obterDataFutura(Calendar dataBase, int qtdDias) {
		dataBase.add(Calendar.DAY_OF_MONTH, qtdDias);
		return dataBase.getTime();
	}

	public static Date formatStringData(String dateXml, String pattern) throws ParseException {
		Date result = null;
		if (null != dateXml) {
			DateFormat df = new SimpleDateFormat(pattern);
			result = df.parse(dateXml);
		}
		return result;
	}
	
	public static boolean dataEntradaEhDepoisDeDataHoje(Date dataEntrada) {
		boolean retorno = false;
		Calendar data = Calendar.getInstance(TimeZone.getDefault());
		data.setTime(dataEntrada);
		
		retorno = data.after(getHojeCalendar());
		return retorno;
	}
	
	public static boolean dataEntradaEhAntesDeDataHoje(Date dataEntrada) {
		boolean retorno = false;
		Calendar data = Calendar.getInstance(TimeZone.getDefault());
		data.setTime(dataEntrada);
		
		retorno = data.before(getHojeSemHorario());
		return retorno;
	}
	
	public static boolean horarioEhDepois(Date horarioLimite){
		Calendar calendarLimite = Calendar.getInstance();
		calendarLimite.setTime(horarioLimite);
		
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.set(Calendar.HOUR_OF_DAY, calendarLimite.get(Calendar.HOUR_OF_DAY));
		dataAtual.set(Calendar.MINUTE, calendarLimite.get(Calendar.MINUTE));
		dataAtual.set(Calendar.SECOND, calendarLimite.get(Calendar.SECOND));
		
		return Calendar.getInstance().getTime().after(dataAtual.getTime());
	}
	
	public static Calendar getHojeSemHorario() {
		Calendar hoje = Calendar.getInstance(TimeZone.getDefault());
		hoje.set(Calendar.HOUR_OF_DAY, 0);
		hoje.set(Calendar.MINUTE, 0);
		hoje.set(Calendar.SECOND, 0);
		hoje.set(Calendar.MILLISECOND, 0);
		return hoje;
	}
	
	public static Date ajustarHoraInicial(Date dataInicial) {
		if (dataInicial != null) {
			Calendar data = Calendar.getInstance();
			data.setTime(dataInicial);
			data.set(Calendar.HOUR_OF_DAY, 0);
			data.set(Calendar.MINUTE, 0);
			data.set(Calendar.SECOND, 0);
			return data.getTime();
		}
		return null;
	}

	public static Date ajustarHoraFinal(Date dataFinal) {
		if (dataFinal != null) {
			Calendar data = Calendar.getInstance();
			data.setTime(dataFinal);
			data.set(Calendar.HOUR_OF_DAY, 23);
			data.set(Calendar.MINUTE, 59);
			data.set(Calendar.SECOND, 59);
			return data.getTime();
		}
		return null;
	}
	
	public static Date dataAtual00h00m00s(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
	
	public static Date dataAtual23h59m59s(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
	
	public static XMLGregorianCalendar getXMLGregorianCalendar(Date date) {
	    XMLGregorianCalendar xmlCalender=null;
	    GregorianCalendar calender = new GregorianCalendar();
	    calender.setTime(date);
	    try {
			xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	    return xmlCalender;
	}
	
	public static String getDataFormatada(Date data, String fmt) {
		SimpleDateFormat formatador = new SimpleDateFormat(fmt);
		return formatador.format(data);
	}
	
	public static Date obterData(String dataString, String formato) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(formato);
		Date data = df.parse(dataString);
		return data;
	}	
}
