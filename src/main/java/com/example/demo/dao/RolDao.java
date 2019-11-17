package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.entity.Rol;


public interface RolDao {
	List<GrantedAuthority> readAll(int iduser);
	int create(Rol rol);
	int update(Rol rol);
	int delete(int id);
	Map<String, Object> read(int id);
	public Map<String, Object> readall();
}
