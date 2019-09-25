package com.sony.sonyservice.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sony.sonyservice.model.entities.ItemSony;

@Repository
public interface ItemSonyRepository extends CrudRepository<ItemSony, String>{
	
	
	
}
