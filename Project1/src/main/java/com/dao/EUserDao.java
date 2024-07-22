package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EUserBean;

@Repository
public class EUserDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void insertUser(EUserBean userBean) {
		
		stmt.update("insert into users (name,email,password,profilePicPath) values (?,?,?,?)",
				userBean.getName(),userBean.getEmail(),userBean.getPassword(),userBean.getProfilePicPath());
		
		
	}
	
	
	public EUserBean authenticate(String email , String password) {
		try {
			EUserBean user =  stmt.queryForObject("select * from users where email = ? and password = ?"
					,new BeanPropertyRowMapper<EUserBean>(EUserBean.class),new Object[] {email,password});	
			return user;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	
	public List<EUserBean> getAllUsers(){
		
		List<EUserBean> list = stmt.query("select * from users", 
				new BeanPropertyRowMapper<EUserBean>(EUserBean.class));
		
		return list;
	}
	
	public void deleteUser(int id) {
		
		stmt.update("delete from users where id = ?",id);
	}
}
