package com.rest.os.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rest.os.dao.*;
import com.rest.os.bean.Product;

public class ShoppingCart {
	PreparedStatement stmt;
	DBConnection dbcon = new DBConnection();
	Connection conn;
	
	//remove an item from the shopping cart
	public String removeCartItem(int cartid, int prodId){
		
		String result= null;
		String query = "delete from CartItem where cartid=? and prodid=?";
		conn = dbcon.getConnection();
		try{
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, cartid);
			stmt.setInt(2, prodId);
			int rc = stmt.executeUpdate();
			
			if(rc >0)
			{
			  result = "Sucessfully removed the item";	
			 // String query2 = "update "
			}else
			{
			   result = "Failure in deleting the item";	
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Error in database connection";
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
		
	}

	//add an item from the shopping cart
		public String addCartItem(CartItem item){
			
			String result= null;
			String query = "insert into onlinedb.CartItem(cartId, prodId, qty) values"+"(?,?,?)";
			conn = dbcon.getConnection();
			try{
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, item.getCartId());
				stmt.setInt(2, item.getProdId());
				stmt.setInt(3, item.getQuantity());
				int rc = stmt.executeUpdate();
				
				if(rc >0)
				{
				  result = "Sucessfully added the item to cart";	
				}else
				{
				   result = "Failure in adding the item";	
				}
				
			}catch (SQLException e) {
				System.out.println(e.getMessage());
				return "Error in database connection";
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return result;
			
		}

	
}
