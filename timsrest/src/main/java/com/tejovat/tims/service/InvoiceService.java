package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.Invoice;

public interface InvoiceService {
	
	public List<Invoice> getList();
	
	public List<Invoice> getActiveList();
	
	public List<Invoice> getDeactiveList();
	
	public Invoice save(Invoice invoice);
	
	public Invoice update(Invoice invoice);
	
	public Invoice get(Integer id);
	
	public void remove(Integer id);

	public Integer getCount();
	
	
}
