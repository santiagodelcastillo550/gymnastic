package com.example.gymnastic.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Rutina {

	@Id
	private int id;
	private String nombre;
	private Integer nivel;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "rutina_ejercicios",
	        joinColumns = @JoinColumn(name="idRutina"),
	        inverseJoinColumns = @JoinColumn(name="idEjercicio"))
	private Set<Ejercicio> ejercicios;
	
	public Rutina() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Set<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(Set<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
}
