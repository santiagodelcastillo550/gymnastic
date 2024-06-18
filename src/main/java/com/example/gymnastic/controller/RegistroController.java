package com.example.gymnastic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		Users users = new Users();
        //users.setDatosUsuario(new DatosUsuario());
        model.addAttribute("users", users);
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(Users user,DatosUsuario datosUsuario, Model model) {
	    log.info("registerUser");
	    log.info("user:"+ user.toString());
	    log.info("datosUsuario:" + datosUsuario.toString());
	    try {
	    	// Registrar el usuario usando el servicio
            servicioUsuario.registerUser(user, datosUsuario);

            model.addAttribute("message", "Usuario registrado con éxito");
	    } catch (Exception e) {
	        log.error("Error al registrar el usuario", e);
	        model.addAttribute("error", "Error al registrar el usuario. Por favor, inténtalo de nuevo.");
	        return "register";
	    }
	    return "login";
	}
}
