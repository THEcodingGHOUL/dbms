package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class teachingdaoImpl implements teachingdao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public teaching getteacher(String subName)
	{
		String sql="select * from teaching where subjectName='"+subName+"';" ;
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(teaching.class));
	}
	
	
}





	
	

	


