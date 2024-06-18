package com.example.gymnastic.bussiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gymnastic.entities.Authorities;
import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.Users;
import com.example.gymnastic.repositories.AuthoritiesRepository;
import com.example.gymnastic.repositories.DatosUsuarioRepository;
import com.example.gymnastic.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicioUsuario {
	Logger log = LoggerFactory.getLogger(ServicioUsuario.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;

	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	@Transactional
	public void registerUser(Users user, DatosUsuario datosUsuario) throws Exception {
		log.info("registerUser");
		log.debug("user:", user);
		log.debug("datosUsuario:", datosUsuario);
		// Vincular usuarios con DatosUsuarios
		// users.setDatosUsuario(datosUsuario);
		// datosUsuario.setUser(users);
		try {
			// Guardar el usuario (se guarda también datosUsuario por cascade =
			// CascadeType.ALL)
			user.setPassword(passwordEncoder().encode(user.getPassword()));
			usuarioRepository.save(user);

			// Asignar rol (autoridad) al usuario
			Authorities authorities = new Authorities();
			authorities.setUsername(user.getUsername());
			authorities.setAuthority("ROLE_USER");

			// Guardar la autoridad en la base de datos
			authoritiesRepository.save(authorities);

			log.debug("authorities:", authorities);

			// datosUsuario.setUsername(user.getUsername());

			datosUsuarioRepository.save(datosUsuario);

			log.info("Usuario {} registrado con rol ROLE_USER", user.getUsername());
		} catch (Exception e) {
			log.error("Error registro", e);

		}
		
	}
	public PasswordEncoder passwordEncoder() { return new
			  BCryptPasswordEncoder(); }
}
