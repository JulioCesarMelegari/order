package com.jcm.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcm.order.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	ShippingService shippingService;
	
	public Double total(Order order) {
		Double vDiscount = order.getBasic() * order.getDiscount()/100;
		Double delivery = shippingService.shipping(order);
		Double vFinal = order.getBasic() - vDiscount + delivery;
		return vFinal;	
	}
}
