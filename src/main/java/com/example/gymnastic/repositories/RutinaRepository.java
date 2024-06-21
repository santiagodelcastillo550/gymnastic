package com.example.gymnastic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gymnastic.entities.Rutina;

public interface RutinaRepository extends JpaRepository<Rutina, Integer>{

	@Query("Select r from Rutina r, RutinasUsuario ru where r.id=ru.rutina.id and ru.usuario.id=:id")
	List<Rutina> findRutinasUsuario(@Param("id")Integer idUsuario);
	
	@Query("Select r from Rutina r, RutinasUsuario ru where r.id=ru.rutina.id and ru.mcaFavorita =true and ru.usuario.id=:id")
	List<Rutina> findRutinasFavoritasUsuario(@Param("id")Integer idUsuario);
	
	@Query("Select distinct r from Rutina r, RutinasUsuario ru where r.id=ru.rutina.id and ru.mcaFavorita =true")
	List<Rutina> findRutinasFavoritas();

}
