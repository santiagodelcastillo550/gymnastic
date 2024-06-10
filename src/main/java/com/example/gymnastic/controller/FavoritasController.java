package com.example.gymnastic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoritasController {
	Logger log = LoggerFactory.getLogger(FavoritasController.class);
	
	@GetMapping("/favoritas")
    public String mostrarPaginaFavoritas() {
		log.info("mostrarPaginaFavoritas");
        return "favoritas";
    }
}
