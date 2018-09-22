package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.PackageOrder;

public interface PackageOrderService {
	
public List<PackageOrder> getList();
	
	public List<PackageOrder> getActiveList();
	
	public List<PackageOrder> getDeactiveList();
	
	public PackageOrder save(PackageOrder packageOrder);
	
	public PackageOrder update(PackageOrder packageOrder);
	
	public PackageOrder get(Integer id);
	
	public void remove(Integer id);
	
	public String getNextPackageNumber();
	
	public String getNextShipmentNumber();

	public Integer getCount();
	
}
