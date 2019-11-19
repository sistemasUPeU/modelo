package com.example.demo.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OpcionesDao;
import com.example.demo.service.OpcionesService;

@Service
public class OpcionesServiceImp implements OpcionesService{

	@Autowired
	private OpcionesDao opcionesDao;
	
	@Override
	public Map<String, Object> listarOpciones(int idrol) {
		// TODO Auto-generated method stub
		return opcionesDao.listarOpciones(idrol);
	}

}
