package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RolService;
import com.example.demo.service.UsuarioService;
@CrossOrigin(origins = {"http:localhost:4200"})
@RestController
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private RolService rolService;
	@Autowired
	private UsuarioService usuarioService;
@Secured("ROLE_ADMIN")
@GetMapping("/datos1")
public Map<String,Object> getRol() {
	return rolService.readall();
}
@Secured("ROLE_GERENTE")
@GetMapping("/datos2")
public Map<String,Object> getUser() {
	return usuarioService.readAll();
}

}
