package team12.stockist.controller;

import java.util.ArrayList;
import java.util.Date;

import team12.stockist.model.User;

public class Cart {
	
	int cartId;
	User user;
	ArrayList<CartItem> cartItemList;
	Date dateUsed;
	String customerName;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartId, User user, ArrayList<CartItem> cartItemList, Date dateUsed, String customerName) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.cartItemList = cartItemList;
		this.dateUsed = dateUsed;
		this.customerName = customerName;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(ArrayList<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	public Date getDateUsed() {
		return dateUsed;
	}
	public void setDateUsed(Date dateUsed) {
		this.dateUsed = dateUsed;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

	
	
	

}
