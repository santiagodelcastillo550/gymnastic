package com.example.gymnastic.bussiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymnastic.common.exceptions.ServicioException;
import com.example.gymnastic.controller.LoginController;
import com.example.gymnastic.entities.Ejercicio;
import com.example.gymnastic.entities.Rutina;
import com.example.gymnastic.repositories.EjercicioRepository;
import com.example.gymnastic.repositories.RutinaRepository;

@Service
public class ServicioRutinalmpl implements ServicioRutina{
	Logger log = LoggerFactory.getLogger(ServicioRutinalmpl.class);
	
	@Autowired
	RutinaRepository rutinaRepositorio;

	@Autowired
	EjercicioRepository ejercicioRepositorio;
	
	@Override
	public List<Rutina> listRutinas() throws ServicioException {
		log.info("listRutinas()");
		List<Rutina> rutinas = rutinaRepositorio.findAll();
		return rutinas;
		
	}

	@Override
	public Rutina conseguirRutina(Integer idRutina) throws ServicioException {
		log.info("conseguirRutina");
		Optional<Rutina> rutinaOptional = rutinaRepositorio.findById(idRutina);
        if (rutinaOptional.isPresent()) {
            return rutinaOptional.get();
        } else {
            throw new ServicioException();
        }
	}

	@Override
	public Rutina grabarRutina(Rutina rutina) throws ServicioException {
		log.info("grabarRutina");
		return rutinaRepositorio.save(rutina);
	}

	@Override
	public void eliminarRutina(Integer idRutina) throws ServicioException {
		log.info("eliminarRutina");
		rutinaRepositorio.deleteById(idRutina);
		
	}

	 @Override
	 public void agregarEjerciciosARutina(Integer idRutina, List<Integer> idsEjercicios) throws ServicioException {
	     // Optional puede contener un dato o no
		 log.info("agregarEjerciciosARutina");
		 Optional<Rutina> rutinaOptional = rutinaRepositorio.findById(idRutina);
	     if (rutinaOptional.isPresent()) { // Comprueba si existe una rutina
	         Rutina rutina = rutinaOptional.get(); // Recoge la rutina que tenemos en el optional
	         Set<Ejercicio> ejercicios = rutina.getEjercicios(); // Obtiene el conjunto de ejercicios
	         log.info("ejercicios");
	         if (ejercicios == null) {
	             ejercicios = new HashSet<>(); // Si es nulo crea un nuevo conjunto de ejercicios
	         }
	         for (Integer idEjercicio : idsEjercicios) { // Itera sobre la lista de IDs de ejercicios proporcionados.
	        	 // Intenta encontrar un ejercicio en el repositorio utilizando el ID proporcionado. Se almacena en Optional
	        	 Optional<Ejercicio> ejercicioOptional = ejercicioRepositorio.findById(idEjercicio);
	             if (ejercicioOptional.isPresent()) {
	            	 // Agrega el ejercicio encontrado al conjunto de ejercicios asociados a la rutina.
	                 ejercicios.add(ejercicioOptional.get());
	             } else {
	                 throw new ServicioException("Error al cargar los ejercicios");
	             }
	         }
	         rutina.setEjercicios(ejercicios); // Tiene el conjunto de ejercicios actualizado
	         rutinaRepositorio.save(rutina); // Guarda los cambios en la rutina en el repositorio.
	     } else {
	         throw new ServicioException("Error al cargar las rutinas con los ejercicios");
	     }
	 }
	 
	 public void mostrarEjercicios() throws ServicioException {
		 log.info("mostrarEjercicios");
	        try {
				// RUTINA ESPALDA/BICEPS
				agregarEjerciciosARutina(1, Arrays.asList(1, 2, 3, 4, 9, 11));
				agregarEjerciciosARutina(2, Arrays.asList(5, 2, 3, 4, 7, 13));
				agregarEjerciciosARutina(3, Arrays.asList(6, 3, 2, 8, 10, 12));
				// RUTINA PECHO/HOMBRO 
				agregarEjerciciosARutina(4, Arrays.asList(14, 15, 21, 23, 20));
				agregarEjerciciosARutina(5, Arrays.asList(16, 17, 22, 24, 20, 19));
				agregarEjerciciosARutina(6, Arrays.asList(16, 18, 22, 24, 20, 19));
				// RUTINA PIERNA
				agregarEjerciciosARutina(7, Arrays.asList(25, 28, 29, 26, 30));
				agregarEjerciciosARutina(8, Arrays.asList(28, 29, 27, 25, 30, 31));
				agregarEjerciciosARutina(9, Arrays.asList(28, 29, 27, 32, 30, 31));
				// RUTINA GLUTEO
				agregarEjerciciosARutina(10, Arrays.asList(33, 34, 40, 36, 37));
				agregarEjerciciosARutina(11, Arrays.asList(33, 35, 40, 36, 37, 39));
				agregarEjerciciosARutina(12, Arrays.asList(33, 35, 38, 36, 37, 39));
			} catch (ServicioException e) {
				log.error("Error al mostrar ejercicios: " + e.getMessage());
				throw new ServicioException("Error al mostrar ejercicios");
			}
	    }
}