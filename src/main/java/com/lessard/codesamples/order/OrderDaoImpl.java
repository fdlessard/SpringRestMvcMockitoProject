package com.lessard.codesamples.order;

import java.util.ArrayList;
import java.util.List;

import com.lessard.codesamples.order.Order;
import com.lessard.codesamples.order.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Override
	public Order getOrderById(String id) {
		
		return new Order("0", "Order " + id);
	}

	@Override
	public List<Order> getAllOrders() {
		
		List<Order> orderList = new ArrayList<Order>();
		
		orderList.add(new Order("0", "Order 0"));
		orderList.add(new Order("1", "Order 1"));
		orderList.add(new Order("2", "Order 2"));
		
		return orderList;
	}

}
