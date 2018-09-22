package com.tejovat.tims.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.SalesItem;

@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem, Serializable>{

	public List<SalesItem> findBySalesorderid(Integer salesorderid);
}	
