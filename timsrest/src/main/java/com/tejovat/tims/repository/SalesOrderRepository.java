package com.tejovat.tims.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.SalesOrder;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Serializable> {
	public SalesOrder findFirstByOrderByIdDesc();
	public SalesOrder findFirstByOrderByInvoicenoDesc();
	
	public List<SalesOrder> findByInvoicenoIsNotNullOrderByInvoicenoDesc();
}
