package com.example.gymnastic.bussiness;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymnastic.entities.Ejercicio;
import com.example.gymnastic.repositories.EjercicioRepository;

@Service
public class ServicioEjerciciolmpl {
	 Logger log = LoggerFactory.getLogger(ServicioEjerciciolmpl.class);
	 
	 @Autowired
	 private EjercicioRepository ejercicioRepository;

	 public List<Ejercicio> obtenerTodosLosEjercicios(){
		 log.info("obtenerTodosLosEjercicios");
	     return ejercicioRepository.findAll();
	 }
}
