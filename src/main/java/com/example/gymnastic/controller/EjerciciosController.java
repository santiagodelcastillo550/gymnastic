package com.example.gymnastic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymnastic.bussiness.ServicioEjerciciolmpl;
import com.example.gymnastic.entities.Ejercicio;

@RestController
@RequestMapping("/api/ejercicios")
public class EjerciciosController {
	Logger log = LoggerFactory.getLogger(EjerciciosController.class);
	
    @Autowired
    private ServicioEjerciciolmpl servicio;

    @GetMapping
    public List<Ejercicio> obtenerTodosLosEjercicios() {
    	log.info("obtenerTodosLosEjercicios");
        return servicio.obtenerTodosLosEjercicios();
    }
}

