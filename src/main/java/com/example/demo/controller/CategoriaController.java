package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
    private CategoriaService categoriaService;
	@GetMapping
	public List<Categoria> get(){
		return categoriaService.lista();
	}
	@PostMapping("/add")
	public int save(@RequestBody Categoria categoria) {		
		return categoriaService.create(categoria);		
	}
	@DeleteMapping("/{id}")
	public int delete1(@PathVariable int id) {		
		return categoriaService.delete(id);
	}
	@GetMapping("/{id}")
	public Categoria read1(@PathVariable int id) {		
		return categoriaService.read(id);
	}
	@PutMapping("/{id}")
	public int update1(@RequestBody Categoria cat, @PathVariable int id) {
		cat.setIdcategoria(id);
		return categoriaService.edit(cat);
	}
}
