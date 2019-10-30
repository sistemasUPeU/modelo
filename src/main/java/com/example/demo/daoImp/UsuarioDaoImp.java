package com.example.demo.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Usuario;
@Repository
public class UsuarioDaoImp implements UsuarioDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Override
	public Usuario validarUsuario(String username) {
		// TODO Auto-generated method stub
		String SQL = "select *from usuario where nomuser =?";
		Usuario user = new Usuario();
		user = (Usuario)jdbcTemplate.queryForObject(SQL, new Object[]{username}, BeanPropertyRowMapper.newInstance(Usuario.class));
		return user;
	}
	@Override
	public int create(Usuario user) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO USUARIO(IDUSUARIO,NOMUSER,CLAVE) VALUES(NULL,?,?)";
		String nomuser = bcryptPasswordEncoder.encode(user.getClave());
		return jdbcTemplate.update(SQL,user.getNomuser(),nomuser);
	}

}
