package com.care.service;

import java.util.List;

import com.care.domain.UserOrder;
import com.care.mybatis.bean.Order;
import com.care.mybatis.bean.OrderItem;

public interface OrderService {

	public abstract void saveOrder(UserOrder order, List<OrderItem> items);

}