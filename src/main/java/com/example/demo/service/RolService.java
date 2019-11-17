package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Rol;

public interface RolService {
	int create(Rol rol);
	int update(Rol rol);
	int delete(int id);
	Map<String, Object> read(int id);
	public Map<String, Object> readall();
}
