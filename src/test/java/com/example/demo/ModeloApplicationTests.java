package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dao.CategoriaDao;
import com.example.demo.dao.RolDao;
import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.serviceImp.UserLogin;

@SpringBootTest
class ModeloApplicationTests {
    @Autowired
    CategoriaDao categoriDao;
    @Autowired
    UsuarioDao userDao;
    @Autowired
    RolDao rolDao;
    @Autowired
    UserLogin userLogin;
    /*
	@Test
	void registrarCategoria() {
		Categoria cat = new Categoria();
		cat.setNombre("Pastas");
		assertTrue(categoriDao.create(cat)==0);
	}

	@Test
	void validarUser() {
		Usuario u = userDao.validarUsuario("dreyna");
		assertTrue(u.getClave()!="dreyna");
	}
	
	@Test
	void createUser() {
		Usuario user = new Usuario(0, "jonasg", "12345", 20);
		assertTrue(userDao.create(user)>0);
		
	}
	
	
	
    @Test
	void autentificarUser() {
		UserDetails details= userLogin.loadUserByUsername("dreyna");
		assertTrue(details.getUsername().equals("dreyna"));
	}
	

    @Test
   	void createRol() {
    	Rol r = new Rol();
    	r.setNomrol("karla");
   		assertTrue(rolDao.create(r)>=0);
   	}

    @Test
	void listRol() {
		assertTrue(rolDao.readall()!=null);
		
	}
	*/
    @Test
   	void eliminartRol() {
   		assertTrue(rolDao.delete(23)>=0);
   		
   	}
}
