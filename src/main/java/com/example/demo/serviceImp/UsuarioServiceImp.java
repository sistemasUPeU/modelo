package com.example.demo.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;
@Service
public class UsuarioServiceImp implements UsuarioService{
	@Autowired
	private UsuarioDao usuarioDao;
	@Override
	public Usuario validarUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Usuario user) {
		// TODO Auto-generated method stub
		return usuarioDao.create(user);
	}

	@Override
	public Map<String, Object> datosUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.datosUsuario(username);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return usuarioDao.readAll();
	}

}
