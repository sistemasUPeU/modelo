package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpcionesService;

@CrossOrigin(origins = {"http:localhost:4200"})
@RestController
@RequestMapping("/opciones")
public class OpcionesController {

	@Autowired
	private OpcionesService opcionesService;
	
	@GetMapping("/{idrol}")
	public Map<String,Object> readOptions(@PathVariable int idrol){
		return opcionesService.listarOpciones(idrol);
	}
	
}
