package com.tejovat.tims.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author YogeshLokare
 */
@Entity
@Table(name = "vendor_master")
public class VendorMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "salutation")
    private String salutation;
    @Size(max = 70)
    @Column(name = "firstname")
    @NotBlank(message = "first name can't be blank")
    private String firstname;
    @Size(max = 70)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 45)
    @Column(name = "contactno")
    private String contactno;
    @Size(max = 45)
    @Column(name = "alternatecontact")
    private String alternatecontact;
    @Size(max = 45)
    @Column(name = "emailid", unique=true)
    private String emailid;
    @Size(max = 45)
    @Column(name = "faxno")
    private String faxno;
    @Size(max = 75)
    @Column(name = "billstreetno")
    private String billstreetno;
    @Size(max = 75)
    @Column(name = "billstreetname")
    private String billstreetname;
    @Size(max = 45)
    @Column(name = "billcity")
    private String billcity;
    @Size(max = 45)
    @Column(name = "billpostalcode")
    private String billpostalcode;
    @Size(max = 45)
    @Column(name = "billstate")
    private String billstate;
    @Size(max = 45)
    @Column(name = "billcountry")
    private String billcountry;
    @Size(max = 75)
    @Column(name = "shipstreetno")
    private String shipstreetno;
    @Size(max = 75)
    @Column(name = "shipstreetname")
    private String shipstreetname;
    @Size(max = 45)
    @Column(name = "shipcity")
    private String shipcity;
    @Size(max = 45)
    @Column(name = "shippostalcode")
    private String shippostalcode;
    @Size(max = 45)
    @Column(name = "shipstate")
    private String shipstate;
    @Size(max = 45)
    @Column(name = "shipcountry")
    private String shipcountry;

    public VendorMaster() {
    
    }

    public VendorMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAlternatecontact() {
        return alternatecontact;
    }

    public void setAlternatecontact(String alternatecontact) {
        this.alternatecontact = alternatecontact;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    public String getBillstreetno() {
        return billstreetno;
    }

    public void setBillstreetno(String billstreetno) {
        this.billstreetno = billstreetno;
    }

    public String getBillstreetname() {
        return billstreetname;
    }

    public void setBillstreetname(String billstreetname) {
        this.billstreetname = billstreetname;
    }

    public String getBillcity() {
        return billcity;
    }

    public void setBillcity(String billcity) {
        this.billcity = billcity;
    }

    public String getBillpostalcode() {
        return billpostalcode;
    }

    public void setBillpostalcode(String billpostalcode) {
        this.billpostalcode = billpostalcode;
    }

    public String getBillstate() {
        return billstate;
    }

    public void setBillstate(String billstate) {
        this.billstate = billstate;
    }

    public String getBillcountry() {
        return billcountry;
    }

    public void setBillcountry(String billcountry) {
        this.billcountry = billcountry;
    }

    public String getShipstreetno() {
        return shipstreetno;
    }

    public void setShipstreetno(String shipstreetno) {
        this.shipstreetno = shipstreetno;
    }

    public String getShipstreetname() {
        return shipstreetname;
    }

    public void setShipstreetname(String shipstreetname) {
        this.shipstreetname = shipstreetname;
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    public String getShippostalcode() {
        return shippostalcode;
    }

    public void setShippostalcode(String shippostalcode) {
        this.shippostalcode = shippostalcode;
    }

    public String getShipstate() {
        return shipstate;
    }

    public void setShipstate(String shipstate) {
        this.shipstate = shipstate;
    }

    public String getShipcountry() {
        return shipcountry;
    }

    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry;
    }

	@Override
	public String toString() {
		return "VendorMaster [id=" + id + ", salutation=" + salutation + ", firstname=" + firstname + ", lastname="
				+ lastname + ", contactno=" + contactno + ", alternatecontact=" + alternatecontact + ", emailid="
				+ emailid + ",  faxno=" + faxno + ", billstreetno=" + billstreetno
				+ ", billstreetname=" + billstreetname + ", billcity=" + billcity + ", billpostalcode=" + billpostalcode
				+ ", billstate=" + billstate + ", billcountry=" + billcountry + ", shipstreetno=" + shipstreetno
				+ ", shipstreetname=" + shipstreetname + ", shipcity=" + shipcity + ", shippostalcode=" + shippostalcode
				+ ", shipstate=" + shipstate + ", shipcountry=" + shipcountry + "]";
	}

   
}
