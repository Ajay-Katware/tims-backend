package com.tejovat.tims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.dto.CounterDto;
import com.tejovat.tims.service.CustomerService;
import com.tejovat.tims.service.PackageOrderService;
import com.tejovat.tims.service.ProductitemService;
import com.tejovat.tims.service.SalesOrderService;
import com.tejovat.tims.service.MyUserService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private MyUserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PackageOrderService packageService;
	
	@Autowired
	private SalesOrderService salesOrderService;
	
	@Autowired
	private ProductitemService productService;
	
	
	@RequestMapping(value = "/counters", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public  ResponseEntity<CounterDto> getDashboardCounters() throws Exception {
		Integer userCount = userService.getCount();
		Integer customerCount = customerService.getCount();
		Integer salesOrderCount = salesOrderService.getCount();
		Integer packageCount = packageService.getCount();
		Integer invoiceCount = salesOrderService.getInvoiceCount();
		Integer productCount = productService.getCount();
		CounterDto dto = new CounterDto();
		dto.setUserCount(userCount);
		dto.setCustomerCount(customerCount);
		dto.setSalesOrderCount(salesOrderCount);
		dto.setPackageCount(packageCount);
		dto.setInvoiceCount(invoiceCount);
		dto.setShipmentCount(0);
		dto.setProductCount(productCount);
		return ResponseEntity.ok().body(dto);
	}

}
