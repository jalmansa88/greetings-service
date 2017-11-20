package com.masterapps.almansaj.greetingsservice.service;

import java.sql.Timestamp;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterapps.almansaj.greetingsservice.dao.entity.User;
import com.masterapps.almansaj.greetingsservice.dao.repository.UserRepository;
import com.masterapps.almansaj.greetingsservice.model.Greeting;

@Service
public class GreetingsService {
	
	private static final String WELCOME_MSG = "¡Bienvenido, {0}! Eres el visitante nº {1}";
	private static final String WELCOME_BACK_MSG = "¡Bienvenido de nuevo, {0}! ¡qué bien verte de nuevo por aquí!. Te recuerdo que eres el visitante {1} de {2}.";
	
	@Autowired
	private UserRepository userRepo;
	
	public Greeting sayHi(String username, Timestamp time){
		User user = userRepo.findOne(username);
		Long totalUsers = userRepo.count();
		
		if (user != null){
			return new Greeting(user.getId(),
					MessageFormat.format(WELCOME_BACK_MSG, user.getName(), user.getId(), totalUsers),
					user.getRegisterTime());
		} else {
			User newUser = new User(username, time);
			newUser = userRepo.saveAndFlush(newUser);
			
			return new Greeting(newUser.getId(), 
					MessageFormat.format(WELCOME_MSG, username, newUser.getId()),
					time);
		}
	}
	
}
