package com.example.gymnastic.bussiness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.gymnastic.common.exceptions.ServicioException;
import com.example.gymnastic.entities.Ejercicio;
import com.example.gymnastic.entities.Rutina;
import com.example.gymnastic.repositories.EjercicioRepository;
import com.example.gymnastic.repositories.RutinaRepository;

public class ServicioRutinalmplTest {

	@Mock
    private RutinaRepository repositorioRu;

    @Mock
    private EjercicioRepository repositorioEj;

    @InjectMocks
    private ServicioRutinalmpl servicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
     // Datos de prueba para rutinas
        Rutina rutina1 = new Rutina();
        rutina1.setId(1);
        rutina1.setNombre("Rutina 1");

        Rutina rutina2 = new Rutina();
        rutina2.setId(2);
        rutina2.setNombre("Rutina 2");

        // Configuración del comportamiento simulado del repositorio de rutinas
        when(repositorioRu.findAll()).thenReturn(Arrays.asList(rutina1, rutina2));
        when(repositorioRu.findById(1)).thenReturn(Optional.of(rutina1));

        // Configuración del comportamiento simulado del repositorio de ejercicios
        when(repositorioEj.findById(anyInt())).thenReturn(Optional.of(new Ejercicio()));
    }

    @Test
    public void testListRutinas() throws ServicioException {
    	// Llamada al método del servicio
        List<Rutina> resultado = servicio.listRutinas();

        // Verificaciones
        assertEquals(2, resultado.size());
        assertEquals("Rutina 1", resultado.get(0).getNombre());
        assertEquals("Rutina 2", resultado.get(1).getNombre());

        // Verifica que el método findAll del repositorio se haya llamado exactamente una vez
        verify(repositorioRu, times(1)).findAll();
    }

    @Test
    public void testConseguirRutina() throws ServicioException {
    	// Llamada al método del servicio
        Rutina resultado = servicio.conseguirRutina(1);

        // Verificaciones
        assertNotNull(resultado);
        assertEquals("Rutina 1", resultado.getNombre());

        // Verifica que el método findById del repositorio se haya llamado exactamente una vez con el id 1
        verify(repositorioRu, times(1)).findById(1);
    }

    @Test
    public void testGrabarRutina() throws ServicioException {
    	// Datos de prueba
        Rutina rutina = new Rutina();
        rutina.setId(3);
        rutina.setNombre("Nueva Rutina");

        // Configuración del comportamiento simulado del repositorio
        when(repositorioRu.save(rutina)).thenReturn(rutina);

        // Llamada al método del servicio
        Rutina resultado = servicio.grabarRutina(rutina);

        // Verificaciones
        assertNotNull(resultado);
        assertEquals("Nueva Rutina", resultado.getNombre());

        // Verifica que el método save del repositorio se haya llamado exactamente una vez con la rutina
        verify(repositorioRu, times(1)).save(rutina);
    }

    @Test
    public void testEliminarRutina() throws ServicioException {
    	// Llamada al método del servicio
        servicio.eliminarRutina(1);

        // Verifica que el método deleteById del repositorio se haya llamado exactamente una vez con el id 1
        verify(repositorioRu, times(1)).deleteById(1);
    }

    @Test
    public void testAgregarEjerciciosARutina() throws ServicioException {
    	// Datos de prueba
        Rutina rutina = new Rutina();
        rutina.setId(1);
        rutina.setNombre("Rutina de prueba");

        // Configuración del comportamiento simulado del repositorio
        when(repositorioRu.findById(1)).thenReturn(Optional.of(rutina));

        // Llamada al método del servicio
        servicio.agregarEjerciciosARutina(1, Arrays.asList(1, 2));

        // Verifica que el método findById del repositorio se haya llamado exactamente una vez con el id 1
        verify(repositorioRu, times(1)).findById(1);
        // Verifica que el método findById del repositorio de ejercicio se haya llamado exactamente dos veces
        verify(repositorioEj, times(2)).findById(anyInt());
        // Verifica que el método save del repositorio se haya llamado exactamente una vez con la rutina
        verify(repositorioRu, times(1)).save(rutina);
    }
}
