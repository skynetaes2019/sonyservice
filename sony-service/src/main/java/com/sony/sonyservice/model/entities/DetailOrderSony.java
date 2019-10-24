package com.sony.sonyservice.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "DETAIL_ORDER_SONY")
@IdClass(DetailOrderSony.class)
public class DetailOrderSony implements Serializable {
	@Column(name = "ID_DETALLE")
    @Id
	private int idDetalle;
	
	@Column(name = "ID_ORDER")
	@Id
	private String idOrden;
	
	@Column(name = "ID_ITEM")
	private String idItem;
	
	@Column(name = "CANT_ITEM")
	private int cantItem;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public int getCantItem() {
		return cantItem;
	}

	public void setCantItem(int cantItem) {
		this.cantItem = cantItem;
	}
	
	
}
