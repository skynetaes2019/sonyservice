package com.sony.sonyservice.model;

public class ItemSony {
	
	private String id;
	private String desc;
	private long cost;
	
	
	public ItemSony() {
	}
	
	
	public ItemSony(String id, String desc, long cost) {
		this.id = id;
		this.desc = desc;
		this.cost = cost;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	
	

}
