package com.tejovat.tims.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.assembler.SalesOrdersAssembler;
import com.tejovat.tims.dto.AutoNumberDto;
import com.tejovat.tims.dto.SalesOrderDto;
import com.tejovat.tims.model.SalesOrder;
import com.tejovat.tims.pdf.InvoicePdf;
import com.tejovat.tims.pdf.SalesOrderPdf;
import com.tejovat.tims.service.SalesItemsService;
import com.tejovat.tims.service.SalesOrderService;

@RestController
@RequestMapping("/salesorders")
public class SalesOrdersController {

	@Autowired
	private SalesOrderService salesOrdersService;

	@Autowired
	private SalesOrdersAssembler salesOrderAssmbler;

	@Autowired
	private SalesItemsService itemService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<SalesOrder> getAllSalesOrders() throws Exception{
		return salesOrdersService.getSalesOrders();
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SalesOrder> createOrUdpdateSalesOrder(@RequestBody SalesOrderDto salesOrderDto) throws Exception {
		Integer saleOrderId = salesOrderDto.getId();
		if(saleOrderId!=null && saleOrderId > 0) {
			itemService.deleteSalesItemBySO(saleOrderId);
		}
		SalesOrder salesOrder = salesOrderAssmbler.toSalesOrders(salesOrderDto);
		SalesOrder salesOrder2 = salesOrdersService.saveSalesOrder(salesOrder);
		salesOrderAssmbler.toSalesItem(salesOrder2.getId(), salesOrderDto.getSalesItemsCollection());
		return ResponseEntity.ok().body(salesOrder2);
	}

	@RequestMapping(value = "/printsalesorder/{id}", method = RequestMethod.GET)
	public Map<String, Boolean> printSalesOrder(@PathVariable("id") Integer id) throws MessagingException {
		Boolean isprint = true;
		String dir = "E://PDF//";
		String filename= "salesorder_"+id+".pdf";
		String location = dir+filename;
		SalesOrder salesOrder = salesOrdersService.getSalesOrderDetails(id);
		if(salesOrder!=null) {
			printAndEmailSalesOrder(salesOrder, location);
		}
		if(isprint) {
			return Collections.singletonMap("success", true);
		}else {
			return Collections.singletonMap("success", false);
		}
	}
	
	@RequestMapping(value = "/printinvoice/{id}", method = RequestMethod.GET)
	public Map<String, Boolean> printinvoice(@PathVariable("id") Integer id) throws MessagingException {
		Boolean isprint = true;
		String dir = "E://PDF//";
		String filename= "invoice_"+id+".pdf";
		String location = dir+filename;
		SalesOrder salesOrder = salesOrdersService.getSalesOrderDetails(id);
		if(salesOrder!=null) {
			printAndEmailInvoice(salesOrder, location);
		}
		if(isprint) {
			return Collections.singletonMap("success", true);
		}else {
			return Collections.singletonMap("success", false);
		}
	}
	
	public void printAndEmailInvoice(SalesOrder salesOrder, String location) {
		String IMAGE4 = "E://tejovat//tims-svn//trunk//tims-angular//src//assets//images//logo.png";
		try {
			new InvoicePdf().manipulatePdf(salesOrder,location, IMAGE4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printAndEmailSalesOrder(SalesOrder salesOrder, String location) {
		String IMAGE4 = "E://tejovat//tims-svn//trunk//tims-angular//src//assets//images//logo.png";
		try {
			new SalesOrderPdf().manipulatePdf(salesOrder,location, IMAGE4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/pdf/{fileName:.+}", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> download(@PathVariable("fileName") String fileName) throws IOException {
		System.out.println("Calling Download:- " + fileName);
		//String DEST = "E://Tools//sales_order.pdf";
		ClassPathResource pdfFile = new ClassPathResource("downloads/" + fileName);
		//ClassPathResource pdfFile = new ClassPathResource(DEST);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename=" + fileName);
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		headers.setContentLength(pdfFile.contentLength());
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public SalesOrder getProductDetailsById(@PathVariable("id") Integer id) throws Exception {
		SalesOrder salesOrder = salesOrdersService.getSalesOrderDetails(id);
		return salesOrder;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("id") Integer id) throws Exception {
		itemService.deleteSalesItemBySO(id);
		salesOrdersService.deleteSalesOrder(id);
	}

	@RequestMapping(value = "/nextsonumber", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ResponseEntity<AutoNumberDto> getNextSalesOrderNo() {
		AutoNumberDto autoNumberDto = new AutoNumberDto();
		String salesOrder = salesOrdersService.getNextSOnumber();
		autoNumberDto.setNextno(salesOrder);
		return ResponseEntity.ok().body(autoNumberDto);
	}
	
	@RequestMapping(value = "/nextinvoicenumber", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ResponseEntity<AutoNumberDto> getNextInvoiceNumber() {
		AutoNumberDto autoNumberDto = new AutoNumberDto();
		String salesOrder = salesOrdersService.getNextInvoiceNumber();
		autoNumberDto.setNextno(salesOrder);
		return ResponseEntity.ok().body(autoNumberDto);
	}
	
	@RequestMapping(value = "/createinvoice/{id}", method = RequestMethod.GET,consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<Boolean> checkUseremail(@PathVariable("id") Integer id, @RequestParam("invoiceno") String invoiceno) {
		SalesOrder salesOrder = salesOrdersService.getSalesOrderDetails(id);
	
		if(salesOrder!=null) {
			String dir = "E://Tools//";
			String filename= "invoice_"+invoiceno+".pdf";
			String location = dir+filename;
			salesOrder.setInvoiceno(invoiceno);
			salesOrdersService.saveSalesOrder(salesOrder);
			printAndEmailInvoice(salesOrder, location);
			return ResponseEntity.ok().body(true);
		}else {
			return ResponseEntity.ok().body(false);
		}
	}
}


