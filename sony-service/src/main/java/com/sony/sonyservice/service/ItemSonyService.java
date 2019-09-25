package com.sony.sonyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.sonyservice.dao.ItemSonyRepository;
import com.sony.sonyservice.model.entities.ItemSony;
import java.util.Optional;

@Service
public class ItemSonyService {
	
	@Autowired
	ItemSonyRepository itemRepo;
	
	public ItemSony getItemById(String id) {
		return itemRepo.findById(id).get();
    }

}
