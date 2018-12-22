package com.tejovat.tims.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.model.VendorMaster;
import com.tejovat.tims.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping("")
	private List<VendorMaster> getList(){
		return vendorService.getAllVendors();
	}
	
	@GetMapping("/{id}")
	private VendorMaster getVendorById(@PathVariable Integer id) {
		return vendorService.getVendorDetails(id);	
	}
	
	@PostMapping("")
	private VendorMaster saveVendor(@RequestBody VendorMaster vendorMaster) {
		return vendorService.saveVendor(vendorMaster);
	}
	
	@DeleteMapping("/{id}")
	private Map<String, String> removeVendor(@PathVariable Integer id){
		VendorMaster vendor = getVendorById(id);
		if(vendor!=null) {
			vendorService.deleteVendor(id);
			return Collections.singletonMap("message", "Vendor successfully deleted.");
		}else {
			return Collections.singletonMap("message", "Vendor not found.");
		}
	}
}
