package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SubjectdaoImpl implements Subjectdao {
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
	public List<Subject> getall() {
		List<Subject> list;
		String sql="select * from subject;";
		
		
		list=(List<Subject>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Subject.class));
		return list;
	
	}
	
	@Override
	public List<Subject> getsubjectsbystudentid(String uname)
	{
		List<Subject> list;
		
		String sql="select s.subjectName,s.timetable from subject s, studentenroll se where s.courseName=se.courseName and se.username='"+uname+"'";
		list=(List<Subject>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Subject.class));
		return list;
		
	}
	
	
	
	
	
	@Override
	public void addsubject(Subject sub)
	{
		String sql="insert into subject(subjectName,timetable,courseName) values(?,?,?);";
		System.out.println(sub.getCourseName());
		jdbcTemplate.update(sql,new Object[] {sub.getSubjectName(),sub.getTimetable(),sub.getCourseName()});
		
	}
	
	@Override
	public Subject getbyteacher(String user)
	{
		String sql="select s.subjectName,s.timetable,s.courseName from subject s,teaching t where s.subjectname =t.subjectName and t.teacher='"+user+"' ";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Subject.class));
	}
	
	

	
	
}
