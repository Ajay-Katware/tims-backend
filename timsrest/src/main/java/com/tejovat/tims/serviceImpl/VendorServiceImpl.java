package com.tejovat.tims.serviceImpl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.VendorMaster;
import com.tejovat.tims.repository.VendorRepository;
import com.tejovat.tims.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepository repo;

	@Override
	public List<VendorMaster> getAllVendors() {
		return repo.findAll();
	}

	@Override
	public VendorMaster getVendorDetails(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public VendorMaster saveVendor(VendorMaster vendorMaster) {
		VendorMaster vendor = repo.save(vendorMaster);
		return vendor;
	}

	@Override
	public VendorMaster updateVendor(VendorMaster vendorMaster) {
		return repo.save(vendorMaster);
	}

	@Override
	public void deleteVendor(Integer id) {
		VendorMaster vendor = getVendorDetails(id);
		if(vendor!=null) {
			repo.delete(vendor);
		}
	}

	@Override
	public Integer getCount() {
		return (int) repo.count();
	}
}
