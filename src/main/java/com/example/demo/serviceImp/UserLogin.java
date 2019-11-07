package com.example.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.RolDao;
import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Usuario;

@Service("userService")
public class UserLogin implements UserDetailsService{
	@Autowired
	private UsuarioDao userDao;
	@Autowired
	private RolDao rolDao;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario login = userDao.validarUsuario(username);
		UserDetails details = new User(login.getUsername(),login.getPassword(),rolDao.readAll(login.getIdusuario()));
		return details;
	}

}
