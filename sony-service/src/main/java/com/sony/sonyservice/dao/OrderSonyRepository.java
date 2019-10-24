package com.sony.sonyservice.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sony.sonyservice.model.entities.ItemSony;
import com.sony.sonyservice.model.entities.OrderSony;

@Repository
public interface OrderSonyRepository extends CrudRepository<OrderSony, String>{

	@Transactional
    @Modifying
	@Query(value="UPDATE order_sony SET estado = 'Y',fecha_revision = ?2 WHERE id = ?1", nativeQuery = true)
	int aprobarOrden(String idOrden, Date fechaRevision);
	
	@Transactional
    @Modifying
	@Query(value="UPDATE order_sony SET estado = 'N',fecha_revision = ?1 WHERE estado = 'P'", nativeQuery = true)
	void inactivarTodasOrdPend(Date fechaRevision);
	
}
