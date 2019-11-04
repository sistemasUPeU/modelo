package com.example.demo.entity;

public class Usuario {
	private int idusuario;
	private String nomuser;
	private String clave;
	private int idempleado;
	
	public Usuario() {
	}

	public Usuario(int idusuario, String nomuser, String clave, int idempleado) {
		this.idusuario = idusuario;
		this.nomuser = nomuser;
		this.clave = clave;
		this.idempleado = idempleado;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomuser() {
		return nomuser;
	}

	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	
	
}
