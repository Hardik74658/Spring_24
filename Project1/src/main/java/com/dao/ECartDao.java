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
	
		
		ECartBean cart= null;
		try {
			
			cart = stmt.queryForObject("select * from cart where userId = ? and productID = ?",
					new BeanPropertyRowMapper<>(ECartBean.class),new Object[] {cartBean.getUserId(),cartBean.getProductId()});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(cart == null) {			
			stmt.update("insert into cart (userId,productId,qty) values (?,?,?)",cartBean.getUserId(),cartBean.getProductId(),cartBean.getQty());
		}
		else {
			stmt.update("update cart set qty = ? where userId= ? and productId=?",cart.getQty()+1,cart.getUserId(),cart.getProductId());
		}
	
	
	}
	
	public List<EProductBean> myCart(Integer userId){
		
		List<EProductBean> products = stmt.query("select c.productId, p.productName , p.productImagePath , p.price , c.qty "
				+ "from cart c left join products p on c.productId = p.productId where userId = ?", 
				new BeanPropertyRowMapper<EProductBean>(EProductBean.class),new Object[] {userId});;
		
		return products;
	}
	
	public void removeProductFromCart(Integer productId,Integer qty) {
		
		if(qty == 1) {			
			stmt.update("delete from cart where productId = ?",productId);
		}else{
			stmt.update("update cart set qty = ? where productId = ?",qty-1,productId);
		}
		
	}
	
	
	
}
