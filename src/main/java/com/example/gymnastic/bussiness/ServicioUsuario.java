package com.example.gymnastic.bussiness;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	//    @Autowired
	//    private PasswordEncoder passwordEncoder;

	@Transactional
	public void registerUser(Users user, DatosUsuario datosUsuario) throws Exception {

		try {
			// Guardar usuario
			usuarioRepository.save(user);

			// Asociar y guardar datos de usuario
			datosUsuario.setUser(user);
			datosUsuarioRepository.save(datosUsuario);

			// Crear y guardar autoridad
			Authorities authority = new Authorities();
			authority.setUsername(user.getUsername());
			authority.setAuthority("ROLE_USER");
			authoritiesRepository.save(authority);

			log.info("Usuario registrado exitosamente: {}", user.getUsername());
		} catch (Exception e) {
			log.error("Error al registrar el usuario: {}", e.getMessage());
			throw new Exception("Error al registrar el usuario. Por favor, inténtalo de nuevo.", e);
		}
	}
}
