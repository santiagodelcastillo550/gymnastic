package com.example.gymnastic.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gymnastic.bussiness.ServicioRutinalmpl;
import com.example.gymnastic.bussiness.ServicioRutinasUsuario;
import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.RutinasUsuario;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@SpringBootTest
public class FavoritasControllerTest {

	@Mock
    private ServicioRutinalmpl servicioRutina;

    @Mock
    private ServicioRutinasUsuario servicioRu;

    @Mock
    private HttpSession session;

    @Mock
    private org.springframework.ui.Model model;

    @Mock
    private DatosUsuario usuario;

    @InjectMocks
    private FavoritasController favoritasController;

    @Test
    public void testMostrarPaginaFavoritas() {
        // Datos de prueba
        List<RutinasUsuario> rutinasUsuarioList = new ArrayList<>();
        RutinasUsuario rutina1 = new RutinasUsuario();
        rutina1.setId(1L);
        rutina1.setMcaFavorita(true);
        rutinasUsuarioList.add(rutina1);

        // Configuración de comportamiento simulado
        when(session.getAttribute("usuario")).thenReturn(usuario);
        when(usuario.getId()).thenReturn(1L);
        when(servicioRu.obtenerRutinasFavoritas(1L)).thenReturn(rutinasUsuarioList);

        // Llamada al método del controlador
        String viewName = favoritasController.mostrarPaginaFavoritas(model, session);

        // Verificaciones
        assertEquals("favoritas", viewName); // Verifica que la vista devuelta sea "favoritas"
        verify(model, times(1)).addAttribute("favoritas", rutinasUsuarioList); // Verifica que se añadan las rutinas favoritas al modelo
    }

    @Test
    public void testMarcarComoFavorita() {
        // Datos de prueba
        int idRutina = 1;
        when(session.getAttribute("usuario")).thenReturn(usuario);
        when(usuario.getId()).thenReturn(1L);

        // Llamada al método del controlador
        String viewName = favoritasController.marcarComoFavorita(idRutina, session);

        // Verificaciones
        assertEquals("redirect:/rutinas", viewName); // Verifica que se redirija correctamente
        verify(servicioRu, times(1)).marcarComoFavorita(1L, idRutina); // Verifica que se llame al método del servicio para marcar como favorita
    }
}
