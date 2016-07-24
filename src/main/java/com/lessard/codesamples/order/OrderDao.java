package com.lessard.codesamples.order;

import com.lessard.codesamples.order.Order;

import java.util.List;

public interface OrderDao {

	public Order getOrderById(String id);
	
	public List<Order> getAllOrders();	
	
}
