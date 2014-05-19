package com.care.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.care.mybatis.bean.AutoWidget;
import com.care.mybatis.bean.OrderItem;
import com.care.mybatis.bean.Orders;
import com.care.mybatis.bean.User;
import com.care.mybatis.bean.UserAddress;

public class UserOrder {
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	private Orders Orders;
	private List<OrderItem> orderItems;
	private User user;
	private List<UserAddress> userAddress;
	private float totalPrice;

	public float getTotalPrice() {
		this.totalPrice = 0;
		for (OrderItem item : orderItems) {
			this.totalPrice += item.getpPrice();
		}
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserOrder(User user) {
		this.user = user;
		orderItems = new LinkedList<OrderItem>();
		Orders = new Orders();
	}

	public Orders getOrders() {
		return Orders;
	}

	public void setOrders(Orders Orders) {
		this.Orders = Orders;
	}

	public List<OrderItem> getorderItems() {
		return orderItems;
	}

	public void setorderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void add(AutoWidget widget, int count) {
		OrderItem item = new OrderItem();
		item.setpName(widget.getName());
		item.setpPrice(widget.getPrice());
		item.setpQuantity(count);
		item.setpId(widget.getId());
		item.setpNo(widget.getNo());
		orderItems.add(item);
	}

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

	public void remove(int pid) {
		for (Iterator<OrderItem> ite = orderItems.iterator();; ite.hasNext()) {
			if (ite.next().getpId() == pid) {
				ite.remove();
			}
		}
	}

}
