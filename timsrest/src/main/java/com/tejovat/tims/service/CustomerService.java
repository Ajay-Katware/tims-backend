package com.tejovat.tims.service;

import com.tejovat.tims.model.CustomerMaster;

public interface CustomerService {
	
	public Iterable<CustomerMaster> getAllCustomers();
	public CustomerMaster getCustomerDetails(Integer id);
	public CustomerMaster saveCustomer(CustomerMaster customerMaster);
	public CustomerMaster updateCustomer(CustomerMaster customerMaster);
	public void deleteCustomer(Integer id);
	public Integer getCount();

}
