package com.example.demo.dao;

import java.util.Map;

import com.example.demo.entity.Usuario;

public interface UsuarioDao {
	Usuario validarUsuario(String username);
	int create(Usuario user);
	Map<String, Object> datosUsuario(String username);
	Map<String, Object> readAll();
	int update(Usuario user);
	int delete(int id);
	Map<String, Object> read(int id);
	int obtenerIdUsuario(String username);
	int obtenerIdRol(String username);
}
