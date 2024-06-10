package com.example.gymnastic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymnastic.entities.Users;

public interface UsuarioRepository extends JpaRepository<Users, String>{

}
