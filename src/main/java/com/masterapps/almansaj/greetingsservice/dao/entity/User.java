package com.masterapps.almansaj.greetingsservice.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private Timestamp registerTime;
	
	public User(){
		super();
	}

	public User(String name, Timestamp time){
		this.name = name;
		this.registerTime = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
}
