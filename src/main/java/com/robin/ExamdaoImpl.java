package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ExamdaoImpl implements Examdao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Subjectdao sdao;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
		
		
		@Override
		public List<Exam> getall() {
			List<Exam> list;
			String sql="select e.examID,s.subjectName,e.examDate,e.time,e.venue from subject s,exam e where e.subjectName=s.subjectName;";
			
			
			list=(List<Exam>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Exam.class));
			return list;
		
		}
		
		@Override
		public List<Exam> getexambystudentid(String uname)
		{
			List<Exam> list;
			String sql="select s.subjectName,e.venue,e.examId,e.examDate,e.time from exam e,studentenroll se, subject s where se.courseName=s.courseName and s.subjectName=e.subjectName and se.username='"+uname+"';";
			
			
			list=(List<Exam>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Exam.class));
			return list;
		}
		
		@Override
		public void addexam(Exam exm)
		{
			String sql="insert into exam(venue,subjectName,examDate,time) values(?,?,?,?);";
			//Subject s= sdao.getsubjectid(exm.getSubjectName());
			jdbcTemplate.update(sql,new Object[] {exm.getVenue(),exm.getSubjectName(),exm.getExamDate(),exm.getTime()});
		}
		
		
}





