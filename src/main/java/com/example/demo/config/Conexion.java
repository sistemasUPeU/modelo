package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class Conexion {
	@Bean
	  public DataSource dataSource() {
	      DriverManagerDataSource ds = new DriverManagerDataSource();
	      ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
	      ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	      ds.setUsername("lp2");
	      ds.setPassword("1234567");
	      return ds;
	  }
}
