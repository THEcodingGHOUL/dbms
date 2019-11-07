package com.robin;



import com.robin.*;

import org.springframework.security.core.Authentication;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentResultdaoImpl implements StudentResultdao {
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
	public void addresult(StudentResult sresult)
	{
		String sql = "INSERT INTO examresult(username,examId,marksObtained,totalmarks,percentile) VALUES (?,?,?,?,?);";
		jdbcTemplate.update(sql, sresult.getUsername(),sresult.getExamId(),sresult.getMarksObtained(),sresult.getTotalmarks(),sresult.getPercentile());

	}
	
	@Override
	public List<StudentResult> getexamresultbystudentid(String uname)
	{
		List<StudentResult> list;
		String sql="select * from examresult where username='"+uname+"'";
		
		
		list=(List<StudentResult>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(StudentResult.class));
		return list;
	}
	
	
}


