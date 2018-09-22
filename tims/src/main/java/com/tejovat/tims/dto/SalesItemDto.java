package com.tejovat.tims.dto;

import com.tejovat.tims.model.ProductItem;

public class SalesItemDto {
	private Integer id;
	private ProductItem itemid;
	private String barcode;
	private String productname;
	private Integer productid;
	private Integer quantity;
	private Double rate;
	private Double discount;
	private Double amount;
	private Integer salesorderid;
	
	public SalesItemDto() {
	}

	public SalesItemDto(Integer id, ProductItem itemid, String barcode, String productname, Integer productid,
			Integer quantity, Double rate, Double discount, Double amount, Integer salesorderid) {
		this.id = id;
		this.itemid = itemid;
		this.barcode = barcode;
		this.productname = productname;
		this.productid = productid;
		this.quantity = quantity;
		this.rate = rate;
		this.discount = discount;
		this.amount = amount;
		this.salesorderid = salesorderid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductItem getItemid() {
		return itemid;
	}

	public void setItemid(ProductItem itemid) {
		this.itemid = itemid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(Integer salesorderid) {
		this.salesorderid = salesorderid;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Override
	public String toString() {
		return "SalesItemDto [id=" + id + ", itemid=" + itemid + ", barcode=" + barcode + ", productname=" + productname
				+ ", productid=" + productid + ", quantity=" + quantity + ", rate=" + rate + ", discount=" + discount
				+ ", amount=" + amount + ", salesorderid=" + salesorderid + "]";
	}

}
