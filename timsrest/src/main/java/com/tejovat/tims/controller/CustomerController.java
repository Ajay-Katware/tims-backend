package com.tejovat.tims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.model.CustomerMaster;
import com.tejovat.tims.model.Customers;
import com.tejovat.tims.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Iterable<CustomerMaster> getAllCustomerMasters() throws Exception{
		return customerService.getAllCustomers();
	}
	
	 @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public ResponseEntity<List<Customers>> getAllEmployees() {

	        Iterable<Customers> employees = customerService.getCustomers();

	        List<Customers> target = new ArrayList<>();
	        employees.forEach(target::add);
	        return new ResponseEntity<>(target, HttpStatus.OK);

	    }
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<CustomerMaster> createCustomerMaster(@RequestBody CustomerMaster customerMaster, HttpServletRequest request) throws Exception {
		CustomerMaster createdCustomerMaster = customerService.saveCustomer(customerMaster);
		return ResponseEntity.ok().body(createdCustomerMaster);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public CustomerMaster getCustomerById(@PathVariable("id") Integer id) throws Exception {
		return customerService.getCustomerDetails(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	public void deleteCustomer(@PathVariable("id") Integer id) throws Exception {
		customerService.deleteCustomer(id);
	}

}
