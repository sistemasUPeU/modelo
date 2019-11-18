package com.example.demo.daoImp;

import java.sql.Types;
import java.util.ArrayList;
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

import com.example.demo.dao.OpcionesDao;

import oracle.jdbc.OracleTypes;
@Repository
public class OpcionesDaoImp implements OpcionesDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public Map<String, Object> listarOpciones( int idrol) {
		// TODO Auto-generated method stub
		System.out.println(idrol);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_LISTAR_OPCIONES_LOGIN")
				.declareParameters(new SqlOutParameter("opc",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("idr", Types.INTEGER), new SqlParameter("username", Types.VARCHAR));
		SqlParameterSource in = new MapSqlParameterSource().addValue("idr", idrol);
		Map<String, Object> out = simpleJdbcCall.execute(in);
		return out;

	}

}
