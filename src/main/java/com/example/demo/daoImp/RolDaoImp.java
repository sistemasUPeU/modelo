package com.example.demo.daoImp;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.RolDao;
import com.example.demo.entity.Rol;

import oracle.jdbc.OracleTypes;
@Repository
public class RolDaoImp implements RolDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public List<GrantedAuthority> readAll(int iduser) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> autores = new ArrayList<>();
		String SQL = "select u.idusuario, r.idrol, r.nombre from rol r, usuario u, usuario_rol ur where "
				+"r.idrol=ur.idrol and ur.idusuario= u.idusuario and u.idusuario=?";
		List<Rol> roles = jdbcTemplate.query(SQL, new Object[]{iduser}, new BeanPropertyRowMapper<Rol>(Rol.class));		
		for(int i=0;i<roles.size();i++) {
			autores.add(new SimpleGrantedAuthority(roles.get(i).getNombre()));
		}
		return autores;
	}
	@Override
	public int create(Rol rol) {
		// TODO Auto-generated method stub
		String SQL= "INSERT INTO ROL (IDROL,NOMROL) VALUES(NULL,?)";
		return jdbcTemplate.update(SQL,rol.getNombre());
	}
	@Override
	public int update(Rol rol) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call SP_EDITAR_ROL(?,?)",rol.getIdrol(),rol.getNombre());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call SP_ELIMINAR_ROL(?)",id);
	}
	@Override
	public Rol read(int id) {//flata realizar el SP 2
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_READ_ROL").declareParameters(new SqlOutParameter("cat",OracleTypes
				.CURSOR,new ColumnMapRowMapper()), new SqlParameter("idc", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("idc", id);
		Map<String, Object> out = simpleJdbcCall.execute(in);
		Rol r = new Rol();
		r.setIdrol((Integer)out.get("IDCATEGORIA"));
		r.setNombre((String)out.get("NOMROL"));
		return r;
	}
	@Override
	public Map<String, Object> readall() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("sp_listar_rol")
				.declareParameters(new SqlOutParameter("roles",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return (Map<String, Object>) simpleJdbcCall.execute();
	}

}
