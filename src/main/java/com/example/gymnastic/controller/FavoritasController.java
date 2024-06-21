package com.example.gymnastic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gymnastic.bussiness.ServicioRutinalmpl;
import com.example.gymnastic.bussiness.ServicioRutinasUsuario;
import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.RutinasUsuario;
import com.example.gymnastic.entities.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class FavoritasController {
	Logger log = LoggerFactory.getLogger(FavoritasController.class);
	
	@Autowired
	private ServicioRutinalmpl servicioRutina;
	
	@Autowired
	private ServicioRutinasUsuario servicioRu;
	
	 @GetMapping("/favoritas")
	    public String mostrarPaginaFavoritas(Model model,HttpSession session) {
		 	log.info("mostrarPaginaFavoritas:");
		 	DatosUsuario usuario = (DatosUsuario) session.getAttribute("usuario");
		 	log.info("DatosUsuario:"+ usuario.toString());
	        List<RutinasUsuario> favoritas = servicioRu.obtenerRutinasFavoritas(usuario.getId());
	        model.addAttribute("favoritas", favoritas);
	        return "favoritas";
	    }

	    @PostMapping("/rutina/{id}/favorita")
	    public String marcarComoFavorita(@PathVariable("id") int idRutina,HttpSession session) {
	    	log.info("marcarComoFavorita:");
	    	DatosUsuario usuario = (DatosUsuario) session.getAttribute("usuario");
		 	log.info("DatosUsuario:"+ usuario.toString());
	    	servicioRu.marcarComoFavorita(usuario.getId(), idRutina);
	        return "redirect:/rutinas";
	    }
}
