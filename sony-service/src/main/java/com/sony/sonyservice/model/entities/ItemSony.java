package com.sony.sonyservice.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_SONY")
public class ItemSony {
	
	@Column(name = "ID")
    @Id
	private String id;	
	
	@Column(name = "DESCRIPCION", nullable = true, length = 255)
	private String desc;
	
	@Column(name = "COSTO", nullable = true)
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
