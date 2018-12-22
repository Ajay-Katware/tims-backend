/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejovat.tims.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author YogeshLokare
 */
@Entity
@Table(name = "package_order")
public class PackageOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "packageno")
    private String packageno;
    @Column(name = "packagedate")
    @Temporal(TemporalType.DATE)
    private Date packagedate;
    @Size(max = 150)
    @Column(name = "packagenotes")
    private String packagenotes;
    @Column(name = "totalqty")
    private Integer totalqty;
    @Size(max = 45)
    @Column(name = "shipmentno")
    private String shipmentno;
    @Column(name = "shipdate")
    @Temporal(TemporalType.DATE)
    private Date shipdate;
    @Size(max = 45)
    @Column(name = "carrier")
    private String carrier;
    @Size(max = 45)
    @Column(name = "tracking")
    private String tracking;
    @Size(max = 150)
    @Column(name = "shipnotes")
    private String shipnotes;
    @Column(name = "delivered")
    private Character delivered;
    @JoinColumn(name = "salesorderno", referencedColumnName = "id")
    @ManyToOne
    private SalesOrder salesorderid;
    @OneToMany(mappedBy = "packageid")
    private List<PackageItem> packageItemsList;

    public PackageOrder() {
    }

    public PackageOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageno() {
        return packageno;
    }

    public void setPackageno(String packageno) {
        this.packageno = packageno;
    }

    public Date getPackagedate() {
        return packagedate;
    }

    public void setPackagedate(Date packagedate) {
        this.packagedate = packagedate;
    }

    public String getPackagenotes() {
        return packagenotes;
    }

    public void setPackagenotes(String packagenotes) {
        this.packagenotes = packagenotes;
    }

    public Integer getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Integer totalqty) {
        this.totalqty = totalqty;
    }

    public String getShipmentno() {
        return shipmentno;
    }

    public void setShipmentno(String shipmentno) {
        this.shipmentno = shipmentno;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getShipnotes() {
        return shipnotes;
    }

    public void setShipnotes(String shipnotes) {
        this.shipnotes = shipnotes;
    }

    public Character getDelivered() {
        return delivered;
    }

    public void setDelivered(Character delivered) {
        this.delivered = delivered;
    }
    
	public SalesOrder getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(SalesOrder salesorderid) {
		this.salesorderid = salesorderid;
	}

	public List<PackageItem> getPackageItemsList() {
        return packageItemsList;
    }

    public void setPackageItemsList(List<PackageItem> packageItemsList) {
        this.packageItemsList = packageItemsList;
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
        if (!(object instanceof PackageOrder)) {
            return false;
        }
        PackageOrder other = (PackageOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "PackageOrder [id=" + id + ", packageno=" + packageno + ", packagedate=" + packagedate
				+ ", packagenotes=" + packagenotes + ", totalqty=" + totalqty + ", shipmentno=" + shipmentno
				+ ", shipdate=" + shipdate + ", carrier=" + carrier + ", tracking=" + tracking + ", shipnotes="
				+ shipnotes + ", delivered=" + delivered + ", salesorderid=" + salesorderid + ", packageItemsList="
				+ packageItemsList + "]";
	}
    
}
