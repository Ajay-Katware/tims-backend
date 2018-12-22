package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.VendorMaster;

public interface VendorService {
	
	public List<VendorMaster> getAllVendors();
	public VendorMaster getVendorDetails(Integer id);
	public VendorMaster saveVendor(VendorMaster vendorMaster);
	public VendorMaster updateVendor(VendorMaster vendorMaster);
	public void deleteVendor(Integer id);
	public Integer getCount();

}