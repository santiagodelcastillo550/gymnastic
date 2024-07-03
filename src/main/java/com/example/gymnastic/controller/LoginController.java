package com.example.gymnastic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/logout")
    public String irse() { // Parametro HttpSession session
		log.info("Fuera Sesion");
		//session.removeAttribute("usuario");
        return "index";
    }
	@GetMapping("/loginError")
    public String daerror() {
		log.info("daerror");
		
        return "loginError";
    }
	
	@GetMapping("/login")
    public String venirse() {
		log.info("Acceder");
		
        return "login";
    }
	
	@GetMapping("/index")
	public String iniciar() {
		log.info("Iniciar");
		return "index";
	}
}
