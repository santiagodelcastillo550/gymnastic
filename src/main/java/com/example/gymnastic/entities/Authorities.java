package com.example.gymnastic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Authorities {
	@Id
	private String username;
	private String authority;
	
	public Authorities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
