package com.tejovat.tims.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.SalesItem;
import com.tejovat.tims.repository.SalesItemRepository;
import com.tejovat.tims.service.SalesItemsService;

@Service
public class SalesItemServiceImpl implements SalesItemsService{
	
	@Autowired
	private SalesItemRepository repo;

	@Override
	public Iterable<SalesItem> getSalesItems() {
		return repo.findAll();
	}

	@Override
	public SalesItem saveSalesItem(SalesItem salesItem) {
		return repo.save(salesItem);
	}

	@Override
	public SalesItem updateSalesItem(SalesItem salesItem) {
		return repo.save(salesItem);
	}
	
	@Override
	public SalesItem getSalesItemDetails(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteSalesItem(Integer id) {
		SalesItem salesItems = getSalesItemDetails(id);
		if(salesItems!=null) {
			repo.delete(salesItems);
		}
	}

	@Override
	public List<SalesItem> getSalesItemBySO(Integer salesorderid) {
		return repo.findBySalesorderid(salesorderid);
	}

	@Override
	public void deleteSalesItemBySO(Integer salesorderid) {
		List<SalesItem> items = getSalesItemBySO(salesorderid);
		for(SalesItem item: items) {
			repo.delete(item);
		}
	}
	
}
