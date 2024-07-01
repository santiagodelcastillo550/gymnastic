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
import org.springframework.ui.Model;

import com.example.gymnastic.bussiness.ServicioRutinalmpl;
import com.example.gymnastic.common.exceptions.ServicioException;
import com.example.gymnastic.entities.Rutina;

public class RutinasControllerTest {

	@Mock
    private ServicioRutinalmpl servicio;

    @Mock
    private Model model;

    @InjectMocks
    private RutinasController rutinasController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMostrarRutinas() throws ServicioException {
        // Datos de prueba
        List<Rutina> rutinas = new ArrayList<>();
        Rutina rutina1 = new Rutina();
        rutina1.setId(1);
        rutina1.setNombre("Rutina 1");
        Rutina rutina2 = new Rutina();
        rutina2.setId(2);
        rutina2.setNombre("Rutina 2");
        rutinas.add(rutina1);
        rutinas.add(rutina2);

        // Comportamiento simulado del servicio
        when(servicio.listRutinas()).thenReturn(rutinas);

        // Llamada al método del controlador
        String viewName = rutinasController.mostrarRutinas(model);

        // Verificaciones
        assertEquals("rutinas", viewName); // Verifica que la vista devuelta sea "rutinas"
        verify(model, times(1)).addAttribute("rutinas", rutinas); // Verifica que se añadan las rutinas al modelo
    }
}
