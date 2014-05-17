package com.care.domain;

public class ShoppingCartItem {
	private int id;
	private String name;
	private float price;
	private String desc;
	private int count;
	
	
	public ShoppingCartItem(int id, String name, float price, String desc,
			int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.count = count;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		ShoppingCartItem other = (ShoppingCartItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void incrCount() {
		this.count += 1;
		
	}
	
	
}
