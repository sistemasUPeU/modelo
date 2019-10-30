package com.example.demo.dao;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.entity.Rol;


public interface RolDao {
	List<GrantedAuthority> readAll();
	int create(Rol rol);
}
