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
		String SQL = "INSERT INTO USUARIO(IDUSUARIO,USERNAME,PASSWORD,IDEMPLEADO,ENABLE) VALUES(NULL,?,?,?,?)";
		System.out.println(user.getIdempleado());
		return jdbcTemplate.update(SQL,user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),user.getIdempleado(),1);
	}
	@Override
	public Map<String, Object> datosUsuario(String username) {
		// TODO Auto-generated method stub
		String SQL = "select u.idusuario, r.idrol, r.detalle, u.username, e.nombres, e.apellidos from empleado e, usuario u, "
					+"usuario_rol ur, rol r where u.idusuario = ur.idusuario and r.idrol=ur.idrol and e.idempleado=u.idempleado and u.username=?";
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
	@Override
	public int update(Usuario user) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE usuario SET password=? WHERE idusuario=?";		
		return jdbcTemplate.update(SQL, new BCryptPasswordEncoder().encode(user.getPassword()), user.getIdusuario());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL ="DELETE FROM usuario WHERE idusuario=?";
		return jdbcTemplate.update(SQL, id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		String SQL ="SELECT *FROM usuario WHERE idusuario=?";
		return null;
	}
	@Override
	public int obtenerIdUsuario(String username) {
		// TODO Auto-generated method stub
		String SQL = "select u.idusuario from rol r, usuario u, usuario_rol ur"+
		" where r.idrol=ur.idrol and u.idusuario=ur.idusuario and u.username = ?";
		return this.jdbcTemplate.queryForObject(SQL, new Object[] {username}, Integer.class).intValue();
	}
	@Override
	public int obtenerIdRol(String username) {
		String SQL1 = "select r.idrol from rol r, usuario u, usuario_rol ur"+
				" where r.idrol=ur.idrol and u.idusuario=ur.idusuario and u.username = ?";
		return this.jdbcTemplate.queryForObject(SQL1, new Object[] {username}, Integer.class).intValue();
	}

}
