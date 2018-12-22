/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejovat.tims.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author YogeshLokare
 */
@Entity
@Table(name = "sales_order")
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Id @GeneratedValue(strategy=IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "salesorderno")
    private String salesorderno;
    @Column(name = "reference")
    private String reference;
    @Column(name = "orderdate")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "expecteddate")
    @Temporal(TemporalType.DATE)
    private Date expecteddate;
    @Column(name = "salesperson")
    private String salesperson;
    @Column(name = "shipvia")
    private String shipvia;
    @Column(name = "status")
    private String status;
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "total")
    private Double total;
    @Column(name = "notes")
    private String notes;
    @Column(name = "terms")
    private String terms;
    @Column(name = "packaged")
    private String packaged;
    @Column(name = "shiped")
    private String shiped;
    @Column(name = "invoiceno")
    private String invoiceno;
    @OneToMany(mappedBy = "salesorderid")
    private List<SalesItem> salesItemsCollection;
    @JoinColumn(name = "customerid", referencedColumnName = "id")
    @ManyToOne
    private CustomerMaster customerid;
    
    @Column(name="filename")
    private String filename;
    @Column(name="filetype")
    private String filetype;
    @Lob
    @Column(name="filedata")
	private byte[] filedata;

    public SalesOrder() {
    }

    public SalesOrder(Integer id) {
        this.id = id;
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

    public String getPackaged() {
		return packaged;
	}

	public void setPackaged(String packaged) {
		this.packaged = packaged;
	}

	public String getShiped() {
		return shiped;
	}

	public void setShiped(String shiped) {
		this.shiped = shiped;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public List<SalesItem> getSalesItemsCollection() {
		return salesItemsCollection;
	}

	public void setSalesItemsCollection(List<SalesItem> salesItemsCollection) {
		this.salesItemsCollection = salesItemsCollection;
	}

	public CustomerMaster getCustomerid() {
        return customerid;
    }

    public void setCustomerid(CustomerMaster customerid) {
        this.customerid = customerid;
    }

    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", salesorderno=" + salesorderno + ", reference=" + reference + ", orderdate="
				+ orderdate + ", expecteddate=" + expecteddate + ", salesperson=" + salesperson + ", shipvia=" + shipvia
				+ ", status=" + status + ", subtotal=" + subtotal + ", tax=" + tax + ", total=" + total + ", notes="
				+ notes + ", terms=" + terms + ", packaged=" + packaged + ", shiped=" + shiped + ", invoiceno="
				+ invoiceno + ", salesItemsCollection=" + salesItemsCollection + ", customerid=" + customerid + "]";
	}
    
}
