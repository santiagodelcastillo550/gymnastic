package com.example.gymnastic.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gymnastic.bussiness.ServicioUsuario;
import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.Users;

@Controller
public class RegistroController {
	Logger log = LoggerFactory.getLogger(RegistroController.class);

	@Autowired
	private ServicioUsuario servicioUsuario;

	@GetMapping("/register")
	public String registro(Model model) {
		log.info("Accediendo a la página de registro");
		model.addAttribute("users", new Users());
		model.addAttribute("datosUsuario", new DatosUsuario());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("users") Users users,
	        @ModelAttribute("datosUsuario") DatosUsuario datosUsuario,
	        Model model) {
	    log.info("Registrando usuario: {}", users.getUsername());
	    try {
	        // Asignar el usuario a DatosUsuario y viceversa
	        datosUsuario.setUser(users);
	        users.setDatosUsuario(datosUsuario);

	        // Registrar el usuario usando el servicio
	        servicioUsuario.registerUser(users, datosUsuario);

	        model.addAttribute("message", "Usuario registrado con éxito");
	    } catch (Exception e) {
	        log.error("Error al registrar el usuario", e);
	        model.addAttribute("error", "Error al registrar el usuario. Por favor, inténtalo de nuevo.");
	        return "register"; // Retornar la vista del formulario de registro
	    }
	    return "register";
	}
}
