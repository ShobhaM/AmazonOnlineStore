package com.rest.os.bean;

public class Product {
	
	public Product(){
		
	}
	
	
	private int prodId;
	private String name;
	private String desc;
	private String price;
	private String qty;
	
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	public String toString(){
		 String prod = new StringBuffer("Product Id:").append(this.prodId).
				 append(" name:").append(this.name).append(" desc:").
				 append(this.desc).append(" Price:").append(this.price).append("  Qty:").append(this.qty).toString();
		 
		 return prod;
	}
	

}
