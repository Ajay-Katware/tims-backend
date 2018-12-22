package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.SalesOrder;

public interface SalesOrderService {
	
	public List<SalesOrder> getSalesOrders();
	
	public List<SalesOrder> getInvoices();
	
	public SalesOrder saveSalesOrder(SalesOrder salesOrder);
	
	public SalesOrder updateSalesOrder(SalesOrder salesOrder);
	
	public SalesOrder getSalesOrderDetails(Integer id);
	
	public void deleteSalesOrder(Integer id);
	
	public String getNextSOnumber();
	
	public String getNextInvoiceNumber();

	public Integer getCount();
	
	public Integer getInvoiceCount();

}
