package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.PackageItem;

public interface PackageItemService {

	public List<PackageItem> getList();
	
	public List<PackageItem> getActiveList();
	
	public List<PackageItem> getDeactiveList();
	
	public PackageItem save(PackageItem invoice);
	
	public PackageItem update(PackageItem invoice);
	
	public PackageItem get(Integer id);
	
	public void remove(Integer id);
	
}
