package com.tejovat.tims.controller;

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

import com.tejovat.tims.model.ProductMaster;
import com.tejovat.tims.service.ProductmasterService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductmasterService productService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Iterable<ProductMaster> getAllProducts() throws Exception{
		return productService.getProducts();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductMaster> registerProduct(@RequestBody ProductMaster productmaster, HttpServletRequest request) throws Exception {
		ProductMaster productmaster2 = productService.saveProduct(productmaster);
		return ResponseEntity.ok().body(productmaster2);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ProductMaster getProductDetailsById(@PathVariable("id") Integer id) throws Exception {
		ProductMaster productmaster = productService.getProductDetails(id);
		return productmaster;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("id") Integer id) throws Exception {
		productService.deleteProduct(id);
	}

}
