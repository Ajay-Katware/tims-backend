package com.tejovat.tims.controller;

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

import com.tejovat.tims.model.SalesItem;
import com.tejovat.tims.service.SalesItemsService;

@RestController
@RequestMapping("/salesitems")
public class SalesItemsController {
	
	@Autowired
	private SalesItemsService itemsService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Iterable<SalesItem> getAllSalesItemss() throws Exception{
		return itemsService.getSalesItems();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SalesItem> registerProduct(@RequestBody SalesItem salesItem) throws Exception {
		SalesItem item = itemsService.saveSalesItem(salesItem);
		return ResponseEntity.ok().body(item);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public SalesItem getProductDetailsById(@PathVariable("id") Integer id) throws Exception {
		SalesItem salesOrder = itemsService.getSalesItemDetails(id);
		return salesOrder;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("id") Integer id) throws Exception {
		itemsService.deleteSalesItem(id);
	}

}
