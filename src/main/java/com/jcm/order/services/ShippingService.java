package com.jcm.order.services;

import org.springframework.stereotype.Service;

import com.jcm.order.entities.Order;

@Service
public class ShippingService {
		
	public Double shipping(Order order) {
		if(order.getBasic() < 100) {
			return 20.00;
		}else if(order.getBasic() > 200) {
			return 0.00;
		}
		return 12.00;
	}
}
