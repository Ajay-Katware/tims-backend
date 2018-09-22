/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejovat.tims.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author YogeshLokare
 */
@Entity
@Table(name = "sales_items")
public class SalesItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name = "id")
	private Integer id;
	@JoinColumn(name = "itemid", referencedColumnName = "id")
	@ManyToOne
	private ProductItem itemid;
	@Column(name = "productid")
	private Integer productid;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "rate")
	private Double rate;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "salesorderid")
	private Integer salesorderid;
	@Column(name = "productname")
	private String productname;

	public SalesItem() {
	}

	public SalesItem(Integer id, ProductItem itemid, Integer productid, Integer quantity, Double rate, Double discount,
			Double amount, Integer salesorderid, String productname) {
		this.id = id;
		this.itemid = itemid;
		this.productid = productid;
		this.quantity = quantity;
		this.rate = rate;
		this.discount = discount;
		this.amount = amount;
		this.salesorderid = salesorderid;
		this.productname = productname;
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String string) {
		this.productname = string;
	}

	@Override
	public String toString() {
		return "SalesItems [id=" + id + ", itemid=" + itemid + ", productid=" + productid + ", quantity=" + quantity
				+ ", rate=" + rate + ", discount=" + discount + ", amount=" + amount + ", salesorderid=" + salesorderid
				+ "]";
	}

}
