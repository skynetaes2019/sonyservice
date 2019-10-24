package com.sony.sonyservice.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDER_SONY")
public class OrderSony {
	
	@Column(name = "ID")
    @Id
	private String id;	
	
	@Column(name = "CLIENTE", nullable = true, length = 20)
	private String cliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_RECEPCION")
	private Date fechaRecepcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REVISION")
	private Date fechaAprobacion;
	
	@Column(name = "ESTADO" ,length = 1)
	private String estado;
	
	@Column(name = "COSTO_TOTAL")
	private long costoTotal;
	
	

	public OrderSony() {
	}

	public OrderSony(String id, String cliente, Date fechaRecepcion, Date fechaAprobacion, String estado,
			long costoTotal) {
		this.id = id;
		this.cliente = cliente;
		this.fechaRecepcion = fechaRecepcion;
		this.fechaAprobacion = fechaAprobacion;
		this.estado = estado;
		this.costoTotal = costoTotal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(long costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
	
}
