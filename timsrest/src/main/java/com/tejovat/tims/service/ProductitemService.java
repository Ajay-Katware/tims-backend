package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.ProductItem;

public interface ProductitemService {
	
	public List<ProductItem> getProductItems();
	
	public void updateExcelsheet(List<ProductItem> items);
	
	public ProductItem saveProductItem(ProductItem item);
	
	public ProductItem updateProductItem(ProductItem item);
	
	public void deleteProductItem(Integer id);
	
	public ProductItem getProductItemDetails(Integer id);

	public Integer getCount();
}
