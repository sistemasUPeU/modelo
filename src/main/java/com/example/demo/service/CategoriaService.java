package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Categoria;


public interface CategoriaService {
	public int create(Categoria categoria);
	public int edit(Categoria categoria);
	public int delete(int id);
	public Categoria read(int id);
	public List<Categoria> lista();
}
