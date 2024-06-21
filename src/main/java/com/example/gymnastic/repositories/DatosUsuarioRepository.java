package com.example.gymnastic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gymnastic.entities.DatosUsuario;

public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Long>{
	
	@Query("select d from DatosUsuario d where d.username=:username")
	public DatosUsuario findDatosUsuarioByUsername(String username);

}
