package com.example.gymnastic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymnastic.entities.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>{

}
