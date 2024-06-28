package com.example.gymnastic.bussiness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gymnastic.entities.Ejercicio;
import com.example.gymnastic.repositories.EjercicioRepository;

@SpringBootTest
public class ServicioEjerciciolmplTest {

	@Mock
    private EjercicioRepository repositorio;

    @InjectMocks
    private ServicioEjerciciolmpl servicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
     // Datos de prueba
        Ejercicio ejercicio1 = new Ejercicio();
        ejercicio1.setId(1);
        ejercicio1.setNombre("Flexiones");
        ejercicio1.setParteMuscular("Pectorales");
        ejercicio1.setSeries(3);
        ejercicio1.setRepeticiones(15);
        ejercicio1.setDescripcion("Ejercicio para fortalecer los músculos pectorales");

        Ejercicio ejercicio2 = new Ejercicio();
        ejercicio2.setId(2);
        ejercicio2.setNombre("Sentadillas");
        ejercicio2.setParteMuscular("Piernas");
        ejercicio2.setSeries(4);
        ejercicio2.setRepeticiones(12);
        ejercicio2.setDescripcion("Ejercicio para fortalecer las piernas");

        List<Ejercicio> ejercicios = Arrays.asList(ejercicio1, ejercicio2);

        // Configuración del comportamiento simulado del repositorio
        when(repositorio.findAll()).thenReturn(ejercicios);
    }

    @Test
    public void testObtenerTodosLosEjercicios() {
        
    	// Llamada al método del servicio
        List<Ejercicio> resultado = servicio.obtenerTodosLosEjercicios();

        // Verificaciones
        assertEquals(2, resultado.size());
        assertEquals("Flexiones", resultado.get(0).getNombre());
        assertEquals("Sentadillas", resultado.get(1).getNombre());

        // Verifica que el método findAll del repositorio se haya llamado exactamente una vez
        verify(repositorio, times(1)).findAll();
    }
}
