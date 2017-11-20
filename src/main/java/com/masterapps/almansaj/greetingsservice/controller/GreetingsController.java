package com.masterapps.almansaj.greetingsservice.controller;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masterapps.almansaj.greetingsservice.model.Greeting;
import com.masterapps.almansaj.greetingsservice.service.GreetingsService;

@RestController
@RequestMapping("/api")
public class GreetingsController {
	
	@Autowired
	private GreetingsService service;
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="Unknown") String name) {
			return service.sayHi(name, new Timestamp(System.currentTimeMillis()));
	}
}
