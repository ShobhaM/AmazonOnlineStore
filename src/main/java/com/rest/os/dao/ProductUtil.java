package com.rest.os.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rest.os.bean.*;
import com.rest.os.dao.*;

public class ProductUtil {
	
	private DBConnection dbcon = new DBConnection();
	private Connection conn;
	private PreparedStatement stmt;
	
	public Product[] getProductList(){
		System.out.println("inside get product list");
		Product[] prodArray = null;
		ArrayList<Product> tempList = new ArrayList<Product>();
		String query = "select * from Product where qty>0";
		conn = dbcon.getConnection();
		System.out.println(" successfully connected!!");
		try{
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			System.out.println("successfully retrieved the prods");
			if(rs!=null){
				System.out.println("there is a catalog of products");
				while(rs.next()){
					Product prod= new Product();
					System.out.println(rs.getInt("id"));
					prod.setProdId(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					prod.setName(rs.getString("name"));
					System.out.println(rs.getString("desc"));
					prod.setDesc(rs.getString("desc"));
					prod.setPrice(rs.getString("price"));
					prod.setQty(rs.getString("qty"));
					
					tempList.add(prod);	
				}
				prodArray = new Product[tempList.size()];
				for(int i=0; i< tempList.size(); i++)
				{
					prodArray[i] = tempList.get(i);
				}
				
			}

		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
         }
		
		return prodArray;
		
	}
	
	

}
