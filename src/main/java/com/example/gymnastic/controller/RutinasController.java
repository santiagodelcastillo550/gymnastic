package com.example.gymnastic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gymnastic.bussiness.ServicioRutinalmpl;
import com.example.gymnastic.common.exceptions.ServicioException;
import com.example.gymnastic.entities.Rutina;

@Controller
@RequestMapping("/rutinas")
public class RutinasController {
	Logger log = LoggerFactory.getLogger(RutinasController.class);
	@Autowired
	ServicioRutinalmpl servicio;
	
	@GetMapping
    public String mostrarRutinas(Model model) throws ServicioException {
		log.info("mostrarRutinas:");
		
		servicio.mostrarEjercicios();
		List<Rutina> rutinas = servicio.listRutinas();
		model.addAttribute("rutinas", rutinas);		 
        return "rutinas";
    }
}
