package com.tejovat.tims.dto;

public class CounterDto {

	private Integer salesOrderCount;
	private Integer packageCount;
	private Integer invoiceCount;
	private Integer userCount;
	private Integer shipmentCount;
	private Integer customerCount;
	private Integer productCount;
	
	public CounterDto() {
	}
	
	

	public CounterDto(Integer salesOrderCount, Integer packageCount, Integer invoiceCount, Integer userCount,
			Integer shipmentCount, Integer customerCount, Integer productCount) {
		this.salesOrderCount = salesOrderCount;
		this.packageCount = packageCount;
		this.invoiceCount = invoiceCount;
		this.userCount = userCount;
		this.shipmentCount = shipmentCount;
		this.customerCount = customerCount;
		this.productCount = productCount;
	}



	public Integer getSalesOrderCount() {
		return salesOrderCount;
	}
	public void setSalesOrderCount(Integer salesOrderCount) {
		this.salesOrderCount = salesOrderCount;
	}
	public Integer getPackageCount() {
		return packageCount;
	}
	public void setPackageCount(Integer packageCount) {
		this.packageCount = packageCount;
	}
	public Integer getInvoiceCount() {
		return invoiceCount;
	}
	public void setInvoiceCount(Integer invoiceCount) {
		this.invoiceCount = invoiceCount;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public Integer getShipmentCount() {
		return shipmentCount;
	}
	public void setShipmentCount(Integer shipmentCount) {
		this.shipmentCount = shipmentCount;
	}
	public Integer getCustomerCount() {
		return customerCount;
	}
	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
}
