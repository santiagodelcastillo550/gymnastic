package com.example.gymnastic.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gymnastic.entities.DatosUsuario;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class DatosUsuarioRepositoryTest {

	@Autowired
    private DatosUsuarioRepository datosUsuarioRepository;

    @Test
    public void testFindDatosUsuarioByUsername() {
        // Crear y guardar un usuario
        DatosUsuario usuario = new DatosUsuario();
        usuario.setUsername("testuser");
        usuario.setNombre("Test User");
        datosUsuarioRepository.save(usuario);

        // Buscar el usuario por nombre de usuario
        DatosUsuario foundUsuario = datosUsuarioRepository.findDatosUsuarioByUsername("testuser");

        // Verificaciones
        assertNotNull(foundUsuario);
        assertEquals("testuser", foundUsuario.getUsername());
        assertEquals("Test User", foundUsuario.getNombre());
    }

    @Test
    public void testFindDatosUsuarioByUsername_NotFound() {
        // Intentar buscar un usuario que no existe
        DatosUsuario foundUsuario = datosUsuarioRepository.findDatosUsuarioByUsername("nonexistentuser");

        // Verificación
        assertNull(foundUsuario);
    }
}
