package com.tejovat.tims.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.PackageOrder;

@Repository
public interface PackageOrderRepository extends JpaRepository<PackageOrder, Serializable>{
	
	public PackageOrder findFirstByOrderByPackagenoDesc();
	public PackageOrder findFirstByOrderByShipmentnoDesc();
	
	//public PackageOrder findFirstOrderByShipmentnoDesc();

}
