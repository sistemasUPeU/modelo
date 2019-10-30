package com.example.demo.dao;

import com.example.demo.entity.Usuario;

public interface UsuarioDao {
	Usuario validarUsuario(String username);
	int create(Usuario user);
}
