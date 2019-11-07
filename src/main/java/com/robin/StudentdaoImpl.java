package com.robin;

import java.util.List;

import javax.sql.DataSource;
import com.robin.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;




public class StudentdaoImpl implements Studentdao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Coursedao cdao;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Student> getall() {
		List<Student> list;
		String sql="select u.username,u.password,u.name,u.phone,u.age,u.email,u.address,g.guardianname,g.relation,g.contactInfo,e.admissionDate,c.courseName,c.batchYear from users u,guardian g,users_roles r,course c,studentenroll e where u.username=e.username and e.courseName=c.courseName and u.username=g.username and u.username=r.user and r.role='ROLE_USER'; ";
		
		
		list=(List<Student>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
		return list;
	}
	
	@Override
	public Student getbyid(String uname) {
		String sql="select u.username,u.password,u.name,u.phone,u.age,u.email,u.address,g.guardianname,g.relation,g.contactInfo,e.admissionDate,c.courseName,c.batchYear from users u,guardian g,users_roles r,course c,studentenroll e where u.username='"+uname+"' and u.username=e.username and e.courseName=c.courseName and u.username=g.username and u.username=r.user and r.role='ROLE_USER'; ";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Student.class));
		
		
	}
	
	@Override
	public void updateprofile(User user,String usr)
	{
		String sql="update users set name='"+user.getName()+"',password='"+user.getPassword()+"',phone='"+user.getPhone()+"',age="+user.getAge()+",email='"+user.getEmail()+"',address='"+user.getAddress()+"' where username='"+usr+"';";
		jdbcTemplate.update(sql);
	}
	
	@Override
	public void addstudent(Student student)
	{
		String sql="insert into users(username,password,name,phone,age,email,address,enabled) values(?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sql,new Object[] {student.getUsername(),student.getPassword(),student.getName(),student.getPhone(),student.getAge(),student.getEmail(),student.getAddress(),1});
		
		sql="insert into guardian(relation,contactInfo,username,guardianname) values(?,?,?,?);";
		jdbcTemplate.update(sql,new Object[] {student.getRelation(),student.getContactInfo(),student.getUsername(),student.getGuardianname()});
		
		sql="insert into users_roles(user,role) values(?,?);";
		jdbcTemplate.update(sql,new Object[] {student.getUsername(),"ROLE_USER"});
		
		
		
		
		sql="insert into studentenroll(username,courseName,admissionDate) values(?,?,?);";
		//Course c= cdao.getcourseid(student.getCourseName());
		jdbcTemplate.update(sql,new Object[] {student.getUsername(),student.getCourseName(),student.getAdmissionDate()});
		
		
		
	}
	
	
     @Override
     public void deletestudent(String uname)
     {
    	 String sql="delete from users where username='"+uname+"'";
 		jdbcTemplate.update(sql);
     }
     
     @Override
     public void editstudent(Student student)
     {
    	 String sql="update users_roles set user='"+student.getUsername()+"';  ";
  		jdbcTemplate.update(sql);
  		
  		sql="update users set name='"+student.getName()+"',password='"+student.getPassword()+"',phone='"+student.getPhone()+"',age="+student.getAge()+",email='"+student.getEmail()+"',address='"+student.getAddress()+"'";
 		jdbcTemplate.update(sql);
  		
  		sql="update guardian set relation='"+student.getRelation()+"',contactInfo='"+student.getContactInfo()+"', username=' "+student.getUsername()+"',guardianname='"+student.getGuardianname()+"'; ";
 		jdbcTemplate.update(sql);
 		
 		
 		
 		//Course c= cdao.getcourseid(student.getCourseName());
 		sql="update studentenroll set username='"+student.getUsername()+"',courseId='"+student.getCourseName()+"',admissionDate='"+student.getAdmissionDate()+"'  ";
 		jdbcTemplate.update(sql);
    	 
    	
 		
 		
 		
     }
     
     
     @Override
     public List<Student> getallbyexam(int examId)
     {
    	List<Student> list;
 		String sql="select se.username from studentenroll se,subject s,exam e where se.courseName=s.courseName and s.subjectName = e.subjectName and e.examId=" + examId;
 		
 		
 		list=(List<Student>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
 		return list;
     }

}
