package com.sony.sonyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.sonyservice.dao.OrderSonyRepository;
import com.sony.sonyservice.model.entities.OrderSony;

@Service
public class OrderSonyService {

	@Autowired
	OrderSonyRepository orderRepo;
	
	public OrderSony getOrderById(String id) {
		return orderRepo.findById(id).get();
	}
	
	
}
