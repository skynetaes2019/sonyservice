package com.sony.sonyservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sony.sonyservice.model.entities.DetailOrderSony;
import com.sony.sonyservice.model.entities.OrderSony;

@Repository
public interface DetailOrdersonyRepository extends CrudRepository<DetailOrderSony, String>{
	
	

}
