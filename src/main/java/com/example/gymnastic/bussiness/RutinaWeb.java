package com.example.gymnastic.bussiness;

import org.springframework.stereotype.Component;

@Component
public class RutinaWeb {
	private int id;
	private String nombre;
	private Integer nivel;
	private boolean favorita;
	public RutinaWeb() {
		super();
		// TODO Auto-generated constructor stub
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
	public boolean isFavorita() {
		return favorita;
	}
	public void setFavorita(boolean favorita) {
		this.favorita = favorita;
	}
	
	
	
}
