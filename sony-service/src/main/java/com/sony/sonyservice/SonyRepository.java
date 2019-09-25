package com.sony.sonyservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.sony.sonyservice.model.ItemSony;


@Component
public class SonyRepository {

	private static final Map<String, ItemSony> items = new HashMap<>();

	@PostConstruct
	public void initData() {

		ItemSony item = new ItemSony("11111", "Plancha", 100000);
		items.put(item.getId(), item);
		item = new ItemSony("22222", "TV", 200000);
		items.put(item.getId(), item);
		item = new ItemSony("333333", "PS-VITA", 300000);
		items.put(item.getId(), item);
	}
	
	public ItemSony findItemSony(String id) {
		Assert.notNull(id, "The Item Id must not be null");
		return items.get(id);
	}

}
