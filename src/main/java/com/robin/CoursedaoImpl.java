package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CoursedaoImpl implements Coursedao {
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
	public List<Course> getall() {
		List<Course> list;
		String sql="select * from course";
		
		
		list=(List<Course>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Course.class));
		return list;
	
	}
	
	
	
	@Override
	public void addcourse(Course course)
	{
		String sql="insert into course(courseName,batchYear) values(?,?);";
		jdbcTemplate.update(sql,new Object[] {course.getCourseName(),course.getBatchYear()});
	}
	
	
}
