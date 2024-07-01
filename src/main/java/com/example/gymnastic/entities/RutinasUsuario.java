package com.example.gymnastic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RutinasUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean mcaFavorita;
	
	
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private DatosUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRutina")
    private Rutina rutina;
	
	public RutinasUsuario() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isMcaFavorita() {
		return mcaFavorita;
	}
	public void setMcaFavorita(boolean mcaFavorita) {
		this.mcaFavorita = mcaFavorita;
	}

	public DatosUsuario getUsuario() {
		if(usuario==null) usuario = new DatosUsuario();
		return usuario;
	}

	public void setUsuario(DatosUsuario usuario) {
		this.usuario = usuario;
	}

	public Rutina getRutina() {
		if(rutina==null) rutina = new Rutina();
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	
}
