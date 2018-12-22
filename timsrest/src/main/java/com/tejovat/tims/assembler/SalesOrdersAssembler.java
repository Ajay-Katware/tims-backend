package com.tejovat.tims.assembler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tejovat.tims.dto.SalesItemDto;
import com.tejovat.tims.dto.SalesOrderDto;
import com.tejovat.tims.model.SalesItem;
import com.tejovat.tims.model.SalesOrder;
import com.tejovat.tims.service.CustomerService;
import com.tejovat.tims.service.SalesItemsService;

@Component
public class SalesOrdersAssembler {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private SalesItemsService salesItemsService;

	public SalesOrder toSalesOrders(SalesOrderDto salesOrderDto) { 
		SalesOrder salesOrder =  new SalesOrder();
		if(salesOrderDto.getId() != null && salesOrderDto.getId() > 0) {
			salesOrder.setId(salesOrderDto.getId());
		}
		salesOrder.setCustomerid(customerService.getCustomerDetails(salesOrderDto.getCustomerid()));
		salesOrder.setExpecteddate(salesOrderDto.getExpecteddate());
		salesOrder.setNotes(salesOrderDto.getNotes());
		salesOrder.setOrderdate(salesOrderDto.getOrderdate());
		salesOrder.setReference(salesOrderDto.getReference());
		salesOrder.setSalesorderno(salesOrderDto.getSalesorderno());
		salesOrder.setSalesperson(salesOrderDto.getSalesperson());
		salesOrder.setShipvia(salesOrderDto.getShipvia());
		salesOrder.setStatus(salesOrderDto.getStatus());
		salesOrder.setSubtotal(salesOrderDto.getSubtotal());
		salesOrder.setTax(salesOrderDto.getTax());
		salesOrder.setTerms(salesOrderDto.getTerms());
		salesOrder.setTotal(salesOrderDto.getTotal());
		return salesOrder;
	}

	public SalesOrderDto toDto(SalesOrder salesOrder) {
		SalesOrderDto salesOrderDto = new SalesOrderDto();
		salesOrderDto.setId(salesOrder.getId());
		salesOrderDto.setOrderdate(salesOrder.getOrderdate());
		salesOrderDto.setExpecteddate(salesOrder.getExpecteddate());
		salesOrderDto.setNotes(salesOrder.getNotes());
		salesOrderDto.setReference(salesOrder.getReference());
		salesOrderDto.setTotal(salesOrder.getTotal());
		salesOrderDto.setTerms(salesOrder.getTerms());
		salesOrderDto.setSubtotal(salesOrder.getSubtotal());
		salesOrderDto.setTax(salesOrder.getTax());
		salesOrderDto.setCustomerid(salesOrder.getCustomerid().getId());
		salesOrderDto.setSalesorderno(salesOrder.getSalesorderno());
		salesOrderDto.setStatus(salesOrder.getStatus());
		salesOrderDto.setShipvia(salesOrder.getShipvia());                                                                                                                                                                                                                                            
		return salesOrderDto;
	}

	public void toSalesItem(Integer salesOrderId, List<SalesItemDto> salesItemsCollection) {
		for(SalesItemDto dto:salesItemsCollection) {
			if(dto!=null && dto.getItemid()!=null) {
				SalesItem salesItem =  new SalesItem();
				salesItem.setId(dto.getId());
				salesItem.setItemid(dto.getItemid());
				salesItem.setProductid(dto.getProductid());
				salesItem.setProductname(dto.getProductname());
				salesItem.setQuantity(dto.getQuantity());
				salesItem.setRate(dto.getRate());
				salesItem.setDiscount(dto.getDiscount());
				salesItem.setAmount(dto.getAmount());
				salesItem.setSalesorderid(salesOrderId);
				salesItemsService.saveSalesItem(salesItem);
			}
		}
	}
}
