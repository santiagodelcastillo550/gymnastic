package com.example.gymnastic.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Ejercicio {

	@Id
	private int id;
	
	private String nombre;
	
	private String parteMuscular;
	
	private Integer series;
	
	private Integer repeticiones;
	
	private String descripcion;
	
	@ManyToMany
	@JoinTable(name = "rutina_ejercicios",
	        joinColumns = @JoinColumn(name="idEjercicio"),
	        inverseJoinColumns = @JoinColumn(name="idRutina"))
	private Set<Rutina> rutinas;

	public Ejercicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ejercicio(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	public String getParteMuscular() {
		return parteMuscular;
	}

	public void setParteMuscular(String parteMuscular) {
		this.parteMuscular = parteMuscular;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(Integer repeticiones) {
		this.repeticiones = repeticiones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(Set<Rutina> rutinas) {
		this.rutinas = rutinas;
	}
	
	
}
