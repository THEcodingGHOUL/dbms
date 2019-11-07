package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BlogcommentsdaoImpl implements Blogcommentsdao {
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
	public List<Blogcomments> getall() {
		List<Blogcomments> list;
		String sql="select * from blogcomments; ";
		
		
		list=(List<Blogcomments>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Blogcomments.class));
		return list;
	
	}
	
	@Override
	public List<Blogcomments> getallbybid(int bid)
	{
		List<Blogcomments> list;
		String sql="select b.id,b.content,b.blogId,b.username from blogcomments b where b.blogId= "+bid;
		
		
		list=(List<Blogcomments>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Blogcomments.class));
		return list;
	}
	
	
	@Override
	public void addblogcomment(Blogcomments sr,int blogid)
	{
		String sql="INSERT into blogcomments(content,blogId,username) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[] {sr.getContent(),blogid,sr.getUsername()});
	}
	
	
	
}

