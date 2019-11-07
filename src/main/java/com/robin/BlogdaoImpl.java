package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BlogdaoImpl implements Blogdao{
	
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
	public List<Blog> getallbysid(String subName) {
		List<Blog> list;
		String sql="select b.blogId,b.content,b.date,b.subjectName from blog b where b.subjectName='"+subName+"'";
		
		
		list=(List<Blog>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Blog.class));
		return list;
	
	}
	
	@Override
	public void addblog(Blog blog,String subName)
	{
		String sql ="insert into blog(content,subjectName,date) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[] {blog.getContent(),blog.getSubjectName(),blog.getDate()});
	}

}
