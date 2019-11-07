package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class FeedbackdaoImpl implements  Feedbackdao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Subjectdao sd;
	
	@Autowired
	teachingdao td;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	
	
	@Override
	public List<Feedback> getall() {
		List<Feedback> list;
		String sql="select * from feedback;";
		
		
		list=(List<Feedback>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Feedback.class));
		return list;
	
	}
	
	
	@Override
	public void addfeedback(Feedback fd,String subjectName) {
		//List<Feedback> list;
		teaching teach = td.getteacher(subjectName);
		String sql="INSERT into feedback(content,teacher,date) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[] {fd.getContent(),teach.getTeacher(),fd.getDate()});
		
		
	
	}
	
	
	
	
	
}
