package com.example.demo.entity;

public class Usuario {
	private int idusuario;
	private String username;
	private String password;
	private int idempleado;
	private int enable;
	
	public Usuario() {
	}

	public Usuario(int idusuario, String username, String password, int idempleado, int enable) {
		super();
		this.idusuario = idusuario;
		this.username = username;
		this.password = password;
		this.idempleado = idempleado;
		this.enable = enable;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	
	
}
