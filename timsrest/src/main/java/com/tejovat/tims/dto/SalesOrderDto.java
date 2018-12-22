package com.tejovat.tims.dto;

import java.util.Date;
import java.util.List;

public class SalesOrderDto {
	private Integer id;
    private String salesorderno;
    private String reference;
    private Date orderdate;
    private Date expecteddate;
    private String salesperson;
    private String shipvia;
    private String status;
    private Double subtotal;
    private Double tax;
    private Double total;
    private String notes;
    private String terms;
    private Integer customerid;
    private List<SalesItemDto> salesItemsCollection;

	public SalesOrderDto() {
		
	}
	
	public SalesOrderDto(Integer id, String salesorderno, String reference, Date orderdate, Date expecteddate,
			String salesperson, String shipvia, String status, Double subtotal, Double tax, Double total, String notes,
			String terms, Integer customerid, List<SalesItemDto> salesItemsCollection) {
		this.id = id;
		this.salesorderno = salesorderno;
		this.reference = reference;
		this.orderdate = orderdate;
		this.expecteddate = expecteddate;
		this.salesperson = salesperson;
		this.shipvia = shipvia;
		this.status = status;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
		this.notes = notes;
		this.terms = terms;
		this.customerid = customerid;
		this.salesItemsCollection = salesItemsCollection;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSalesorderno() {
		return salesorderno;
	}
	public void setSalesorderno(String salesorderno) {
		this.salesorderno = salesorderno;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Date getExpecteddate() {
		return expecteddate;
	}
	public void setExpecteddate(Date expecteddate) {
		this.expecteddate = expecteddate;
	}
	public String getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
	public String getShipvia() {
		return shipvia;
	}
	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	
	
	
	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public List<SalesItemDto> getSalesItemsCollection() {
		return salesItemsCollection;
	}

	public void setSalesItemsCollection(List<SalesItemDto> salesItemsCollection) {
		this.salesItemsCollection = salesItemsCollection;
	}

	@Override
	public String toString() {
		return "SalesOrderDto [id=" + id + ", salesorderno=" + salesorderno + ", reference=" + reference
				+ ", orderdate=" + orderdate + ", expecteddate=" + expecteddate + ", salesperson=" + salesperson
				+ ", shipvia=" + shipvia + ", status=" + status + ", subtotal=" + subtotal + ", tax=" + tax + ", total="
				+ total + ", notes=" + notes + ", terms=" + terms + ", customerid=" + customerid
				+ ", salesItemsCollection=" + salesItemsCollection + "]";
	}
	
}
