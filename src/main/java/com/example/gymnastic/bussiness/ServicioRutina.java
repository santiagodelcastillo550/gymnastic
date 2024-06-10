package com.example.gymnastic.bussiness;

import java.util.List;

import com.example.gymnastic.common.exceptions.ServicioException;
import com.example.gymnastic.entities.Ejercicio;
import com.example.gymnastic.entities.Rutina;

public interface ServicioRutina {

	List<Rutina> listRutinas() throws ServicioException;
	//List<RutinaWeb> listaRutinas() throws ServicioException;
	Rutina conseguirRutina(Integer idRutina) throws ServicioException;
	
	Rutina grabarRutina(Rutina rutina) throws ServicioException;
	
	void eliminarRutina(Integer idRutina) throws ServicioException;
	void agregarEjerciciosARutina(Integer idRutina, List<Integer> idsEjercicios) throws ServicioException;
}
