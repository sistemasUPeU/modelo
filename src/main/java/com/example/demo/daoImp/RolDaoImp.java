package com.example.demo.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.RolDao;
import com.example.demo.entity.Rol;
@Repository
public class RolDaoImp implements RolDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GrantedAuthority> readAll() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> autores = new ArrayList<>();
		String SQL = "select *from rol";
		List<Rol> roles = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<Rol>(Rol.class));
		for(int i=0;i<roles.size();i++) {
			autores.add(new SimpleGrantedAuthority(roles.get(i).getNomrol()));
		}
		return autores;
	}
	@Override
	public int create(Rol rol) {
		// TODO Auto-generated method stub
		return 0;
	}

}
