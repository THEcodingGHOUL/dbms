package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TeacherdaoImpl implements Teacherdao {

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
	public List<Teacher> getall() {
		List<Teacher> list;
		String sql="select u.username,u.password,u.name,u.phone,u.age,u.email,u.address,t.subjectName from users u,users_roles r,teaching t where r.user=u.username and u.username=t.teacher and r.role='ROLE_TEACHER';";
		
		
		list=(List<Teacher>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Teacher.class));
		return list;
	
	}
	
	@Override
	public void addteacher(Teacher teacher)
	{
		String sql="insert into users(username,password,name,phone,age,email,address,enabled) values(?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sql,new Object[] {teacher.getUsername(),teacher.getPassword(),teacher.getName(),teacher.getPhone(),teacher.getAge(),teacher.getEmail(),teacher.getAddress(),1});
		
		sql="insert into users_roles(user,role) values(?,?);";
		jdbcTemplate.update(sql,new Object[] {teacher.getUsername(),"ROLE_TEACHER"});
		
		sql="insert into teaching(teacher,subjectName) values(?,?);";
		System.out.println(teacher.getSubjectName());
		jdbcTemplate.update(sql,new Object[] {teacher.getUsername(),teacher.getSubjectName()});
		
	}
	
	
}

