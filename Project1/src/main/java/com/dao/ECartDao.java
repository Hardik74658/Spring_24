package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ECartBean;
import com.bean.EProductBean;

@Repository
public class ECartDao {

	@Autowired
	JdbcTemplate stmt;
	
	
	public void addTocart(ECartBean cartBean) {
		stmt.update("insert into cart (userId,productId) values (?,?)",cartBean.getUserId(),cartBean.getProductId());
	}
	
	public List<EProductBean> myCart(Integer userId){
		
		List<EProductBean> products = stmt.query("select * from cart c left join products p on c.productId = p.productId where userId = ?", 
				new BeanPropertyRowMapper<EProductBean>(EProductBean.class),new Object[] {userId});;
		
		return products;
	}
	
	public void removeProductFromCart(Integer productId) {
		stmt.update("delete from cart where productId = ?",productId);
	}
	
}
