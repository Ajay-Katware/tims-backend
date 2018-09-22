package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.SalesItem;

public interface SalesItemsService {
	public Iterable<SalesItem> getSalesItems();
	public SalesItem saveSalesItem(SalesItem salesItem);
	public SalesItem updateSalesItem(SalesItem salesItem);
	public SalesItem getSalesItemDetails(Integer id);
	public void deleteSalesItem(Integer id);
	
	public List<SalesItem> getSalesItemBySO(Integer salesorderid);
	public void deleteSalesItemBySO(Integer salesorderid);

}
