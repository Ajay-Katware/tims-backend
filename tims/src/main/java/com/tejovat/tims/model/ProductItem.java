/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejovat.tims.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author YogeshLokare
 */
@Entity
@Table(name = "productitems")
public class ProductItem implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
	@Size(max = 45)
	@Column(name = "serial_no")
	private String serialNo;
	@Size(max = 45)
	@Column(name = "item_code")
	private String itemCode;
	@Size(max = 45)
	@Column(name = "barcode")
	private String barcode;
	@JoinColumn(name = "productid", referencedColumnName = "id")
	@ManyToOne
	private ProductMaster productid;


	public ProductItem() {
	}

	public ProductItem(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public ProductMaster getProductid() {
		return productid;
	}

	public void setProductid(ProductMaster productid) {
		this.productid = productid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ProductItem)) {
			return false;
		}
		ProductItem other = (ProductItem) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Productitems [id=" + id + ", serialNo=" + serialNo + ", itemCode=" + itemCode + ", barcode=" + barcode
				+ ", productid=" + productid + "]";
	}

}
