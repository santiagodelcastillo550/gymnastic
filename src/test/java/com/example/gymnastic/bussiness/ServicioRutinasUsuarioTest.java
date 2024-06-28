package com.example.gymnastic.bussiness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.Rutina;
import com.example.gymnastic.entities.RutinasUsuario;
import com.example.gymnastic.repositories.RutinasUsuarioRepository;

@SpringBootTest
public class ServicioRutinasUsuarioTest {

	@Mock
	RutinasUsuarioRepository repositorio;

	@InjectMocks
	ServicioRutinasUsuario servicio;

	@Test
	public void testMarcarComoFavorita_rutinaExistente() {
		// Datos de prueba
		Long idUsuario = 1L;
		int idRutina = 1;

		// Objeto simulado de RutinasUsuario existente
		RutinasUsuario rutinaExistente = new RutinasUsuario();
		rutinaExistente.setId(1L);
		rutinaExistente.setUsuario(new DatosUsuario(idUsuario));
		rutinaExistente.setRutina(new Rutina(idRutina));
		rutinaExistente.setMcaFavorita(false);

		// Comportamiento simulado del repositorio
		when(repositorio.findByIdUsuarioAndIdRutina(idUsuario, idRutina)).thenReturn(rutinaExistente);
		when(repositorio.save(rutinaExistente)).thenReturn(rutinaExistente);

		// Llamada al método del servicio
		RutinasUsuario resultado = servicio.marcarComoFavorita(idUsuario, idRutina);

		// Verificaciones
		assertNotNull(resultado);
		assertEquals(idUsuario, resultado.getUsuario().getId());
		assertEquals(idRutina, resultado.getRutina().getId());
		assertEquals(true, resultado.isMcaFavorita()); // Debería ser verdadero ahora

		// Verifica que el método findByIdUsuarioAndIdRutina del repositorio se haya
		// llamado exactamente una vez
		verify(repositorio, times(1)).findByIdUsuarioAndIdRutina(idUsuario, idRutina);
		// Verifica que el método save del repositorio se haya llamado exactamente una
		// vez
		verify(repositorio, times(1)).save(resultado);
	}

	@Test
	public void testObtenerRutinasFavoritas() {
		// Datos de prueba
		Long idUsuario = 1L;

		// Lista simulada de rutinas favoritas
		List<RutinasUsuario> rutinasFavoritas = new ArrayList<>();
		rutinasFavoritas.add(new RutinasUsuario());
		rutinasFavoritas.add(new RutinasUsuario());

		// Comportamiento simulado del repositorio
		when(repositorio.findFavoritasByIdUsuario(idUsuario)).thenReturn(rutinasFavoritas);

		// Llamada al método del servicio
		List<RutinasUsuario> resultado = servicio.obtenerRutinasFavoritas(idUsuario);

		// Verificaciones
		assertNotNull(resultado);
		assertEquals(2, resultado.size());

		// Verifica que el método findFavoritasByIdUsuario del repositorio se haya
		// llamado exactamente una vez
		verify(repositorio, times(1)).findFavoritasByIdUsuario(idUsuario);
	}

}
