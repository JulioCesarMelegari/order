package com.jcm.order;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jcm.order.entities.Order;
import com.jcm.order.services.OrderService;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner  {
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc  = new Scanner(System.in);
		Order order = new Order();
		
		System.out.print("Código do pedido:");
		order.setCode(Integer.parseInt(sc.nextLine()));
		System.out.print("Valor do pedido:");
		order.setBasic(Double.parseDouble(sc.nextLine()));
		System.out.print("% de desconto:");
		order.setDiscount(Double.parseDouble(sc.nextLine()));
		
		Double vFinal = orderService.total(order);
		
		System.out.println("Pedido código "+ order.getCode());
		System.out.printf("Valor total: "+ vFinal);
	    sc.close();
	}
}
