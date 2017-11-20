package com.masterapps.almansaj.greetingsservice.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Id;

public class Greeting {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
    private final long id;
    private final String mensaje;
    private final String horaEntrada;

    public Greeting(long id, String mensaje, Timestamp horaEntrada) {
        this.id = id;
        this.mensaje = mensaje;
        this.horaEntrada = sdf.format(horaEntrada);
    }

	public long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public String getHoraEntrada(){
    	return horaEntrada;
    }
    
    public Timestamp toHoraEntradaAsTimestamp() {
    	try {
			return new Timestamp(sdf.parse(horaEntrada).getTime());
		} catch (ParseException e) {
			return new Timestamp(new Date(0).getTime());
		}
    }
}
