package com.example.gymnastic.bussiness;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymnastic.entities.DatosUsuario;
import com.example.gymnastic.entities.Rutina;
import com.example.gymnastic.entities.RutinasUsuario;
import com.example.gymnastic.repositories.RutinasUsuarioRepository;

@Service
public class ServicioRutinasUsuario {
	Logger log = LoggerFactory.getLogger(ServicioRutinasUsuario.class);
	
	@Autowired
	private RutinasUsuarioRepository repositorio;
	
	public RutinasUsuario marcarComoFavorita(Long idUsuario, int idRutina) {
		log.info("marcarComoFavorita");
        RutinasUsuario rutinasUsuario = repositorio.findByIdUsuarioAndIdRutina(idUsuario, idRutina);
        if (rutinasUsuario == null) 
        	rutinasUsuario = crearRutinaUsuario(idUsuario, idRutina);
       
        rutinasUsuario.setMcaFavorita(!rutinasUsuario.isMcaFavorita());
        return repositorio.save(rutinasUsuario);
    }
	

    public List<RutinasUsuario> obtenerRutinasFavoritas(Long idUsuario) {
    	log.info("obtenerRutinasFavoritas");
        return repositorio.findFavoritasByIdUsuario(idUsuario);
    }
    
    public List<RutinasUsuario> buscarRutinasPorNombre(Long idUsuario, String nombre) {
        log.info("buscarRutinasPorNombre");
        return repositorio.findByNombreRutinaUsuario(idUsuario, nombre);
    }
    
    private RutinasUsuario crearRutinaUsuario(Long idUsuario, int idRutina) {
    	log.debug("crearRutinaUsuario");
		RutinasUsuario rutinasUsuario;
		rutinasUsuario = new RutinasUsuario();
		DatosUsuario usuario = new DatosUsuario();
		usuario.setId(idUsuario);
		Rutina rutina = new Rutina();
		rutina.setId(idRutina);
		rutinasUsuario.setUsuario(usuario);
		rutinasUsuario.setRutina(rutina);
		return rutinasUsuario;
	}
}
