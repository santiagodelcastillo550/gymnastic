package com.example.gymnastic.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gymnastic.entities.DatosUsuario;

import jakarta.transaction.Transactional;

public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Long>{

	@Transactional
    @Modifying
    @Query(value = "INSERT INTO datos_usuario (nombre, apellidos, email, fecha_nac, id) VALUES (:nombre, :apellidos, :email, :fecha_nac, :id)", nativeQuery = true)
    void insertDatosUsuario(@Param("nombre") String nombre, 
                            @Param("apellidos") String apellidos, 
                            @Param("email") String email, 
                            @Param("fecha_nac") Date fechaNac,
                            @Param("id") int id);
	

}
