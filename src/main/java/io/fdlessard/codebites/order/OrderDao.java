package io.fdlessard.codebites.order;

import java.util.List;

public interface OrderDao {

	public Order getOrderById(String id);
	
	public List<Order> getAllOrders();	
	
}
