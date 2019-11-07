package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Rol;

public interface RolService {
	int create(Rol rol);
	int update(Rol rol);
	int delete(int id);
	Rol read(int id);
	public Map<String, Object> readall();
}
