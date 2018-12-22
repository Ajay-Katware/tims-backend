package com.tejovat.tims.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.PackageItem;
import com.tejovat.tims.repository.PackageItemRepository;
import com.tejovat.tims.service.PackageItemService;

@Service
public class PackageItemServiceImpl implements PackageItemService{
	
	@Autowired
	private PackageItemRepository repo;

	@Override
	public List<PackageItem> getList() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<PackageItem> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackageItem> getDeactiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PackageItem save(PackageItem invoice) {
		return repo.save(invoice);
	}

	@Override
	public PackageItem update(PackageItem invoice) {
		return repo.save(invoice);
	}

	@Override
	public PackageItem get(Integer id) {
		PackageItem item = repo.findOne(id);
	return item;
	}

	@Override
	public void remove(Integer id) {
		PackageItem  packageItem = get(id);
		if(packageItem!=null) {
			repo.delete(packageItem);
		}
	}

}
