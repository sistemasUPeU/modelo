package com.example.demo.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RolDao;
import com.example.demo.entity.Rol;
import com.example.demo.service.RolService;
@Service
public class RolServiceImp implements RolService{
	@Autowired
	private RolDao rolDao;
	@Override
	public int create(Rol rol) {
		// TODO Auto-generated method stub
		return rolDao.create(rol);
	}

	@Override
	public int update(Rol rol) {
		// TODO Auto-generated method stub
		return rolDao.update(rol);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return rolDao.delete(id);
	}

	@Override
	public Rol read(int id) {
		// TODO Auto-generated method stub
		return rolDao.read(id);
	}

	@Override
	public Map<String, Object> readall() {
		// TODO Auto-generated method stub
		return rolDao.readall();
	}

}
