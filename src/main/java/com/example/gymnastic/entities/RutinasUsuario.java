package com.example.gymnastic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RutinasUsuario {

	@Id
	private int id;
	private boolean mcaFavorita;
	private int idUsuario;
	private int idRutina;
	
	public RutinasUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isMcaFavorita() {
		return mcaFavorita;
	}
	public void setMcaFavorita(boolean mcaFavorita) {
		this.mcaFavorita = mcaFavorita;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdRutina() {
		return idRutina;
	}

	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}
}
