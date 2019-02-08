package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.CustomerMaster;
import com.tejovat.tims.model.Customers;

public interface CustomerService {
	
	public Iterable<CustomerMaster> getAllCustomers();
	public CustomerMaster getCustomerDetails(Integer id);
	public CustomerMaster saveCustomer(CustomerMaster customerMaster);
	public CustomerMaster updateCustomer(CustomerMaster customerMaster);
	public void deleteCustomer(Integer id);
	public Integer getCount();
	
	List<Customers> getCustomers();

}
