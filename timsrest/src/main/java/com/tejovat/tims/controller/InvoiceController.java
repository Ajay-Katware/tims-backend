package com.tejovat.tims.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.model.Invoice;
import com.tejovat.tims.model.SalesOrder;
import com.tejovat.tims.service.InvoiceService;
import com.tejovat.tims.service.SalesOrderService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private SalesOrderService salesOrderService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<SalesOrder> getAll() throws Exception{
		return salesOrderService.getInvoices();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Invoice> saveEntity(@RequestBody Invoice packageItem, HttpServletRequest request) throws Exception {
		Invoice packageItem2 = invoiceService.save(packageItem);
		return ResponseEntity.ok().body(packageItem2);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public  ResponseEntity<Invoice> getById(@PathVariable("id") Integer id) throws Exception {
		Invoice packageItem = invoiceService.get(id);
		return ResponseEntity.ok().body(packageItem);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeEntity(@PathVariable("id") Integer id) throws Exception {
		invoiceService.remove(id);
	}
	
	@RequestMapping(value = "/get/pdf", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile()
	        throws IOException {

	    ClassPathResource pdfFile = new ClassPathResource("invoice.pdf");

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");

	    return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentLength(pdfFile.contentLength())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(new InputStreamResource(pdfFile.getInputStream()));
	}
}
