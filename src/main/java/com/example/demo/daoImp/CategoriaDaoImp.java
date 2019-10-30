package com.example.demo.daoImp;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CategoriaDao;
import com.example.demo.entity.Categoria;

import oracle.jdbc.OracleTypes;
@Repository
public class CategoriaDaoImp implements CategoriaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> lista() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("sp_listar_categoria")
		.declareParameters(new SqlOutParameter("cat",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return (List<Categoria>) simpleJdbcCall.execute();
	}

	@Override
	public int create(Categoria categoria) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call SP_CREAR_CATEGORIA(?)",categoria.getNombre());
	}

	@Override
	public int edit(Categoria categoria) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call SP_EDITAR_CATEGORIA(?,?)",categoria.getIdcategoria(),categoria.getNombre());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call SP_ELIMINAR_CATEGORIA(?)",id);
	}

	@Override
	public Categoria read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_READ_CATEGORIA").declareParameters(new SqlOutParameter("cat",OracleTypes
				.CURSOR,new ColumnMapRowMapper()), new SqlParameter("idc", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("idc", id);
		Map<String, Object> out = simpleJdbcCall.execute(in);
		Categoria ca = new Categoria();
		ca.setIdcategoria((Integer)out.get("IDCATEGORIA"));
		ca.setNombre((String)out.get("NOMBRE"));
		return ca;
	}

}
