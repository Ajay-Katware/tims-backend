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

/**
 *
 * @author YogeshLokare
 */
@Entity
@Table(name = "package_items")
public class PackageItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "itemid")
    private Integer itemid;
    @Column(name = "qtyordered")
    private Integer qtyordered;
    @Column(name = "qtypacked")
    private Integer qtypacked;
    @Column(name = "qtytopack")
    private Integer qtytopack;
    @Column(name = "packageid")
    private Integer packageid;
    @Column(name = "productname")
    private String productname;

    public PackageItem() {
    }

    public PackageItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getQtyordered() {
        return qtyordered;
    }

    public void setQtyordered(Integer qtyordered) {
        this.qtyordered = qtyordered;
    }

    public Integer getQtypacked() {
        return qtypacked;
    }

    public void setQtypacked(Integer qtypacked) {
        this.qtypacked = qtypacked;
    }

    public Integer getQtytopack() {
        return qtytopack;
    }

    public void setQtytopack(Integer qtytopack) {
        this.qtytopack = qtytopack;
    }

    public Integer getPackageid() {
		return packageid;
	}

	public void setPackageid(Integer packageid) {
		this.packageid = packageid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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
        if (!(object instanceof PackageItem)) {
            return false;
        }
        PackageItem other = (PackageItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "PackageItem [id=" + id + ", itemid=" + itemid + ", qtyordered=" + qtyordered + ", qtypacked="
				+ qtypacked + ", qtytopack=" + qtytopack + ", packageid=" + packageid + ", productname=" + productname
				+ "]";
	}
}
