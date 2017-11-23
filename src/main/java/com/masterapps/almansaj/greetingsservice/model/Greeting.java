package com.masterapps.almansaj.greetingsservice.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private long id;
	@JsonProperty("Mensaje")
	private String mesage;
	@JsonProperty("Hora Registro")
	private String registerTime;
	@JsonProperty("Ultimo Login")
	private String lastLogin;

	public Greeting(long id, String mesage, Timestamp registerTime, Timestamp lastLogin) {
		this.id = id;
		this.mesage = mesage;
		this.registerTime = sdf.format(registerTime);
		this.lastLogin = sdf.format(lastLogin);
	}
	
	public Greeting(long id, String mesage, Timestamp registerTime) {
		this.id = id;
		this.mesage = mesage;
		this.registerTime = sdf.format(registerTime);
	}

	public long getId() {
		return id;
	}

	public String getMesage() {
		return mesage;
	}
	
	public String getRegisterTime(){
		return registerTime;
	}
	
	public Timestamp toTimestamp(String strTime) {
		try {
			return new Timestamp(sdf.parse(strTime).getTime());
		} catch (ParseException e) {
			return new Timestamp(new Date(0).getTime());
		}
	}
}
