package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private RolService rolService;
	
@GetMapping
public Map<String,Object> getRol() {
	return rolService.readall();
}

}
