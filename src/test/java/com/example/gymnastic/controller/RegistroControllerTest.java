package com.example.gymnastic.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import com.example.gymnastic.bussiness.ServicioUsuario;
import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.Users;

@SpringBootTest
public class RegistroControllerTest {
	Logger log = LoggerFactory.getLogger(RegistroControllerTest.class);
	
	@Mock
    private ServicioUsuario servicioUsuario;

    @Mock
    private Model model;

    @InjectMocks
    private RegistroController registroController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testRegistro() {
        String viewName = registroController.registro(model);
        assertEquals("register", viewName);
        verify(model, times(1)).addAttribute(eq("users"), any(Users.class));
        verify(log, times(1)).info("Accediendo a la página de registro");
    }

    @Test
    public void testRegisterUser_success() throws Exception {
        Users user = new Users();
        DatosUsuario datosUsuario = new DatosUsuario();

        String viewName = registroController.registerUser(user, datosUsuario, model);
        assertEquals("login", viewName);
        verify(servicioUsuario, times(1)).registerUser(user, datosUsuario);
        verify(model, times(1)).addAttribute("message", "Usuario registrado con éxito");
        verify(log, times(1)).info("registerUser");
        verify(log, times(1)).info("user:" + user.toString());
        verify(log, times(1)).info("datosUsuario:" + datosUsuario.toString());
    }

    @Test
    public void testRegisterUser_failure() throws Exception {
        Users user = new Users();
        DatosUsuario datosUsuario = new DatosUsuario();
        doThrow(new Exception("Error")).when(servicioUsuario).registerUser(user, datosUsuario);

        String viewName = registroController.registerUser(user, datosUsuario, model);
        assertEquals("register", viewName);
        verify(servicioUsuario, times(1)).registerUser(user, datosUsuario);
        verify(model, times(1)).addAttribute("error", "Error al registrar el usuario. Por favor, inténtalo de nuevo.");
        verify(log, times(1)).error(eq("Error al registrar el usuario"), any(Exception.class));
    }
}
