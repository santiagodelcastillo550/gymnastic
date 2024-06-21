package com.example.gymnastic.bussiness;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymnastic.entities.RutinasUsuario;
import com.example.gymnastic.entities.Users;
import com.example.gymnastic.repositories.RutinasUsuarioRepository;

@Service
public class ServicioRutinasUsuario {
	Logger log = LoggerFactory.getLogger(ServicioRutinasUsuario.class);
	
	@Autowired
	private RutinasUsuarioRepository repositorio;
	
	public RutinasUsuario marcarComoFavorita(Long idUsuario, int idRutina) {
        RutinasUsuario rutinasUsuario = repositorio.findByIdUsuarioAndIdRutina(idUsuario, idRutina);
        if (rutinasUsuario == null) {
            rutinasUsuario = new RutinasUsuario();
            rutinasUsuario.getUsuario().setId(idUsuario);
            rutinasUsuario.getRutina().setId(idRutina);
        }
        rutinasUsuario.setMcaFavorita(!rutinasUsuario.isMcaFavorita());
        return repositorio.save(rutinasUsuario);
    }

    public List<RutinasUsuario> obtenerRutinasFavoritas(Long idUsuario) {
        return repositorio.findFavoritasByIdUsuario(idUsuario);
    }
}
