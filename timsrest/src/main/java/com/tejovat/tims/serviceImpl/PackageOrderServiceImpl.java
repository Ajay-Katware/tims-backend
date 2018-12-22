package com.tejovat.tims.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.PackageOrder;
import com.tejovat.tims.repository.PackageOrderRepository;
import com.tejovat.tims.service.PackageOrderService;

@Service
public class PackageOrderServiceImpl implements PackageOrderService{

	@Autowired
	private PackageOrderRepository repo;

	@Override
	public List<PackageOrder> getList() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<PackageOrder> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackageOrder> getDeactiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PackageOrder save(PackageOrder packageOrder) {
		return repo.save(packageOrder);
	}

	@Override
	public PackageOrder update(PackageOrder packageOrder) {
		return repo.save(packageOrder);
	}

	@Override
	public PackageOrder get(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public void remove(Integer id) {
		PackageOrder packageOrder = get(id);
		if(packageOrder!=null) {
			repo.delete(packageOrder);
		}
	}

	@Override
	public String getNextPackageNumber() {
		PackageOrder packageOrder =  repo.findFirstByOrderByPackagenoDesc();
		if(packageOrder!=null) {
			String previousNo = packageOrder.getPackageno();
			String part_list[] = previousNo.split("-");
			return "PKG-"+(Integer.parseInt(part_list[1]) + 1);
		}else {
			return "PKG"+"-"+(1001);
		}
	}

	@Override
	public String getNextShipmentNumber() {
	PackageOrder packageOrder =  repo.findFirstByOrderByShipmentnoDesc();
		if(packageOrder!=null) {
			String previousNo = packageOrder.getShipmentno();
			String part_list[] = previousNo.split("-");
			return "SHP-"+(Integer.parseInt(part_list[1]) + 1);
		}else {
			return "SHP"+"-"+(1001);
		}
	}

	@Override
	public Integer getCount() {
		return (int) repo.count();
	}	
}
