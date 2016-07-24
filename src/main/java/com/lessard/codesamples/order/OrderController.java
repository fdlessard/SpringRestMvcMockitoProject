package com.lessard.codesamples.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	public OrderController() {
	}

	public OrderController(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Autowired
	private OrderDao orderDao;

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> hello() {
		 return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}
    
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = "application/json")    
    public ResponseEntity<Order> get(@PathVariable String id) {
    	
    	Order order = orderDao.getOrderById(id);
    	
    	return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")  
    public ResponseEntity<List<Order>> getAll() {
    	
    	List<Order> orders = orderDao.getAllOrders();
    	
    	return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

}
