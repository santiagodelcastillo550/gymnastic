package com.example.gymnastic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gymnastic.entities.RutinasUsuario;

public interface RutinasUsuarioRepository extends JpaRepository<RutinasUsuario, Integer>{

	@Query("SELECT ru FROM RutinasUsuario ru WHERE ru.usuario.id = :idUsuario")
    List<RutinasUsuario> findByIdUsuario(@Param("idUsuario") Long idUsuario);
    
    @Query("SELECT ru FROM RutinasUsuario ru WHERE ru.usuario.id = :idUsuario AND ru.mcaFavorita = true")
    List<RutinasUsuario> findFavoritasByIdUsuario(@Param("idUsuario") Long idUsuario);
    
    @Query("SELECT ru FROM RutinasUsuario ru WHERE ru.usuario.id = :idUsuario AND ru.rutina.id = :idRutina")
    RutinasUsuario findByIdUsuarioAndIdRutina(@Param("idUsuario") Long idUsuario, @Param("idRutina") Integer idRutina);

}
