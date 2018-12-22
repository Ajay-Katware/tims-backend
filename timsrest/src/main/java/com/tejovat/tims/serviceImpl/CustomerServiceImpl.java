package com.tejovat.tims.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.CustomerMaster;
import com.tejovat.tims.repository.CustomerRepository;
import com.tejovat.tims.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Iterable<CustomerMaster> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public CustomerMaster getCustomerDetails(Integer id) {
		CustomerMaster customerMaster = customerRepo.findOne(id);
		return customerMaster;
	}

	@Override
	public CustomerMaster saveCustomer(CustomerMaster customerMaster) {
		return customerRepo.save(customerMaster);
	}

	@Override
	public CustomerMaster updateCustomer(CustomerMaster customerMaster) {
		return customerRepo.save(customerMaster);
	}

	@Override
	public void deleteCustomer(Integer id) {
		CustomerMaster customerMaster =  getCustomerDetails(id);
		if(customerMaster!=null) {
			customerRepo.delete(customerMaster);
		}
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return (int) customerRepo.count();
	}

}
