package com.tejovat.tims.service;

import com.tejovat.tims.model.ProductMaster;

public interface ProductmasterService {
	public Iterable<ProductMaster> getProducts();
	public ProductMaster saveProduct(ProductMaster product);
	public ProductMaster updateProduct(ProductMaster product);
	public void deleteProduct(Integer id);
	public ProductMaster getProductDetails(Integer id);

}
