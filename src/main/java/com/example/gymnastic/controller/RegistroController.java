package com.example.gymnastic.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gymnastic.entities.Authorities;
import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.Users;
import com.example.gymnastic.repositories.DatosUsuarioRepository;
import com.example.gymnastic.repositories.UsuarioRepository;

@Controller
public class RegistroController {
	Logger log = LoggerFactory.getLogger(RegistroController.class);
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;

	@PostMapping("/register")
	public String registerUser(@RequestParam String nombre,
			@RequestParam String apellido,
			@RequestParam String email,
			@RequestParam String fecNacimiento,
			@RequestParam String username,
			@RequestParam String password,
			Model model) {
		log.info("registerUser");
		try {
			Users usuario = new Users();
			usuario.setUsername(username);
			usuario.setPassword(password);
			usuario.setEnabled(true);
			usuarioRepository.save(usuario);
			log.debug("insertamos usuario");
			
			Authorities autorizaciones = new Authorities();
			autorizaciones.setUsername(username);
			autorizaciones.setAuthority("ROL_ADMIN");
			log.debug("insertamos autorizacion");

			DatosUsuario datosUsuario = new DatosUsuario();
			datosUsuario.setNombre(nombre);
			datosUsuario.setApellidos(apellido);
			datosUsuario.setEmail(email);
			Date fechaNacimiento = java.sql.Date.valueOf(fecNacimiento);
			datosUsuario.setFecha_nac(fechaNacimiento);
			datosUsuarioRepository.save(datosUsuario);

			log.debug("insertamos datos de usuario");
			
			return "rutinas";
		} catch (Exception e) {
			log.error("Excepcion general",e);
			// TODO Auto-generated catch block
			 model.addAttribute("error", "Error al registrar el usuario. Por favor, inténtalo de nuevo.");
	         return "loginError";
		}
	}
}
