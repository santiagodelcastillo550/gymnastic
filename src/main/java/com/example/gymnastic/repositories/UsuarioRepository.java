package com.example.gymnastic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gymnastic.entities.Users;

import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Users, String>{

//	@Transactional
//	@Modifying
//	@Query(value = "INSERT INTO users (username, password, enabled) VALUES (:username, :password, :enabled)", nativeQuery = true)
//	void insertUser(@Param("username") String username, @Param("password") String password, @Param("enabled") boolean enabled);

}
