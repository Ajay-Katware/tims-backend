package com.tejovat.tims.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.ProductMaster;
import com.tejovat.tims.repository.ProductRepository;
import com.tejovat.tims.service.ProductmasterService;

@Service
public class ProductServiceImpl implements ProductmasterService{
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Iterable<ProductMaster> getProducts() {
		return repo.findAll();
	}

	@Override
	public ProductMaster saveProduct(ProductMaster product) {
		return repo.save(product);
	}

	@Override
	public ProductMaster updateProduct(ProductMaster product) {
		return repo.save(product);
	}
	
	@Override
	public ProductMaster getProductDetails(Integer id) {
		Optional<ProductMaster> productMaster = repo.findById(id);
		if(productMaster.isPresent()) {
			return productMaster.get();
		}
		return null;
	}

	@Override
	public void deleteProduct(Integer id) {
		ProductMaster productMaster = getProductDetails(id);
		if(productMaster!=null) {
			repo.delete(productMaster);
		}
	}

}
