package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Usuario;

public interface UsuarioService {
	Usuario validarUsuario(String username);
	int create(Usuario user);
	Map<String, Object> datosUsuario(String username);
	Map<String,Object> readAll();
}
