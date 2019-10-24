package com.sony.sonyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.sonyservice.dao.DetailOrdersonyRepository;
import com.sony.sonyservice.model.entities.DetailOrderSony;

@Service
public class DetailOrderSonyService {
	
	@Autowired
	DetailOrdersonyRepository detailRepo;
	
	public void InsertarDetalle(DetailOrderSony detalle) {
		detailRepo.save(detalle);
	}

}
