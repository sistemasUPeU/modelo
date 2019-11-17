package com.example.demo.daoImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Usuario;

import oracle.jdbc.OracleTypes;
@Repository
@Component
public class UsuarioDaoImp implements UsuarioDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	@Transactional(readOnly = true)
	public Usuario validarUsuario(String username) {
		// TODO Auto-generated method stub
		String SQL = "SELECT *FROM USUARIO WHERE USERNAME =?";
		Usuario user = new Usuario();
		user = (Usuario)jdbcTemplate.queryForObject(SQL, new Object[]{username}, BeanPropertyRowMapper.newInstance(Usuario.class));
		return user;
	}
	@Override
	public int create(Usuario user) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO USUARIO(IDUSUARIO,USERNAME,CLAVE,IDEMPLEADO,ENABLE) VALUES(NULL,?,?,?,?)";
		System.out.println(user.getIdempleado());
		return jdbcTemplate.update(SQL,user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),user.getIdempleado(),1);
	}
	@Override
	public Map<String, Object> datosUsuario(String username) {
		// TODO Auto-generated method stub
		String SQL = "select e.idempleado as idempleado, e.nombres as nombres, e.apellidos as apellidos from empleado e, usuario u "
					+"where e.idempleado=u.idempleado and u.username=?";
		Map<String, Object> map= jdbcTemplate.queryForMap(SQL, username);
		return map;
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_LISTAR_USUARIO")
				.declareParameters(new SqlOutParameter("uuser",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return (Map<String, Object>) simpleJdbcCall.execute();
	}

}
