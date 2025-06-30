package com.krakedev.persistencia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Convertidor {
	private static final Logger LOGGER=LogManager.getLogger(Convertidor.class);
	private static final String FORMATO_FECHA="yyyy/MM/dd";
	private static final String FORMATO_HORA="hh:mm";
	
	public static Date convertirFecha(String fechaStr) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat(FORMATO_FECHA) ;
		Date fechaDate=null;
		try {
			LOGGER.trace("Convitiendo Fecha"+fechaStr);
			fechaDate=sdf.parse(fechaStr);
			LOGGER.trace("Fecha convertida"+fechaDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("La fecha no tiene el formato correcto",e);
			throw new Exception("La fecha no tiene el formato correcto");
		}
		return fechaDate;
	}
	
	public static Date convertirHora(String HoraStr) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat(FORMATO_HORA) ;
		Date HoraDate=null;
		try {
			HoraDate=sdf.parse(HoraStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("La fecha no tiene el formato correcto",e);
			throw new Exception("La fecha no tiene el formato correcto"+HoraStr);
		}
		return HoraDate;
	}
}
