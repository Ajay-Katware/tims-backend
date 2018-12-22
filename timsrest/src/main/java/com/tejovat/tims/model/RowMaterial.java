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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author YogeshPC
 */
@Entity
@Table(name = "row_material")
public class RowMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_name")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "item_desc")
    private String itemDesc;
    @Basic(optional = false)
    @Column(name = "unit")
    private String unit;
    @Basic(optional = false)
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reorder_level")
    private int reorderLevel;

    public RowMaterial() {
    }

    public RowMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	@Override
    public String toString() {
        return "com.tejovat.tims.model.RowMaterial[ id=" + id + " ]";
    }
    
}
