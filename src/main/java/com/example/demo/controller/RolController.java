package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rol;
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


@Secured("ROLE_ADMIN")
@GetMapping("/{id}")
public ResponseEntity<?> getUserId(@PathVariable Integer id) {
	Map<String, Object> map = new HashMap<>();

	try {
		map = rolService.read(id);
	} catch (DataAccessException e) {
		map.put("mensaje", "Error en la consulta");
		map.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_FOUND);
	}
	if(map.size()==0) {
		map.put("mensaje", "El rol ID: ".concat(id.toString().concat(" No existe en la base de datos")));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
}
}
