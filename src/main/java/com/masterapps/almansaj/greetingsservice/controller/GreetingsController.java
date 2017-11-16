package com.masterapps.almansaj.greetingsservice.controller;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masterapps.almansaj.greetingsservice.model.Greeting;

@RestController
public class GreetingsController {

    private static final String template = "Bienvenido, {0}! Eres el visitante nº {1}";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="nombre", defaultValue="Anónimo") String name) {
        return new Greeting(counter.incrementAndGet(),
        		MessageFormat.format(template, name, counter), 
        		new Timestamp(System.currentTimeMillis()));
    }
}
