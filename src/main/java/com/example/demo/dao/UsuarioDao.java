package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Usuario;

public interface UsuarioDao {
	Usuario validarUsuario(String username);
	int create(Usuario user);
	String datosUsuario(String username);
	Map<String,Object> readAll();
}
