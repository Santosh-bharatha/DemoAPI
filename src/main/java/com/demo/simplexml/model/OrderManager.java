package com.demo.simplexml.model;

import java.util.List;
import com.demo.simplexml.model.Order;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class OrderManager {

	    private final List<Order> orders;

	    public OrderManager(@ElementList(name="orders") List<Order> orders) {
	        this.orders = orders;
	    }

	    @ElementList(name="orders")
	    public List<Order> getOrders() {
	        return orders;
	    }
}
