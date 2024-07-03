package com.example.gymnastic.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gymnastic.bussiness.ServicioEjerciciolmpl;
import com.example.gymnastic.entities.Ejercicio;

@SpringBootTest
public class EjerciciosControllerTest {

	@Mock
    private ServicioEjerciciolmpl servicioEjercicio;

    @InjectMocks
    private EjerciciosController ejerciciosController;

    @Test
    public void testObtenerTodosLosEjercicios() {
    	// Datos de prueba
        Ejercicio ejercicio1 = new Ejercicio(1, "Flexiones");
        Ejercicio ejercicio2 = new Ejercicio(2, "Sentadillas");
        List<Ejercicio> ejercicios = Arrays.asList(ejercicio1, ejercicio2);

        // Comportamiento simulado del servicio
        when(servicioEjercicio.obtenerTodosLosEjercicios()).thenReturn(ejercicios);

        // Llamada al controlador
        List<Ejercicio> resultado = ejerciciosController.obtenerTodosLosEjercicios();

        // Verificaciones
        assertEquals(2, resultado.size());
        assertEquals("Flexiones", resultado.get(0).getNombre());
        assertEquals("Sentadillas", resultado.get(1).getNombre());

        // Verifica que el método del servicio se haya llamado exactamente una vez
        verify(servicioEjercicio, times(1)).obtenerTodosLosEjercicios();
    }
}
