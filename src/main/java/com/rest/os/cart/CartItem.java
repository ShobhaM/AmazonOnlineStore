package com.rest.os.cart;

public class CartItem {
	
	private int cartId;
	private int prodId;
	private int quantity;
	
	public CartItem(){
	}
	
	public CartItem(int cartId, int prodId, int qty){
		this.cartId = cartId;
		this.prodId = prodId;
		this.quantity = qty;
		
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" CartId : ").append(this.cartId)
				.append(" prodId : ").append(this.prodId)
				.append("Quantity : ").append(this.quantity).toString();
	}
	
	

}
