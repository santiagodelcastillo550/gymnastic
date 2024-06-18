package com.example.gymnastic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DatosUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String username;
    private String nombre;
    private String apellidos;
    private String email; 
   
	/*
	 * @Column
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) private LocalDate fechaNacimiento;
	 */
    
	/*
	 * @OneToOne private Users user;
	 */
    
	public DatosUsuario() {
		
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	/*
	 * public LocalDate getFechaNacimiento() { return fechaNacimiento; }
	 * 
	 * public void setFechaNacimiento(LocalDate fechaNacimiento) {
	 * this.fechaNacimiento = fechaNacimiento; }
	 */
	@Override
	public String toString() {
		return "DatosUsuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email +  "]";
	}

	/*
	 * public String getUsername() { return this.user != null ?
	 * this.user.getUsername() : null; }
	 * 
	 * public void setUser(Users user) { this.user = user; }
	 */
    
    
}
