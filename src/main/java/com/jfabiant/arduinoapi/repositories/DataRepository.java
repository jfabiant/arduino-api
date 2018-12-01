package com.jfabiant.arduinoapi.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jfabiant.arduinoapi.models.Data;

@Repository
public class DataRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(DataRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Data> listar(){
		logger.info("call listar()");
		
		String sql = "select * from data";
		
		List<Data> datos = jdbcTemplate.query(sql, new RowMapper<Data>() {
			public Data  mapRow(ResultSet rs, int rowNum) throws SQLException {
				Data data = new Data();
				data.setId(rs.getInt("id"));
				data.setHumedad(rs.getString("humedad"));
				data.setTemperatura(rs.getString("temperatura"));
				data.setRayos_v(rs.getString("rayos_v"));
				data.setSensor_lluvia(rs.getString("sensor_lluvia"));
				data.setCreated_at(rs.getDate("created_at"));
								
				return data;
			}
		});

		logger.info("datos: " + datos);
		
		return datos;
	}
	
}
