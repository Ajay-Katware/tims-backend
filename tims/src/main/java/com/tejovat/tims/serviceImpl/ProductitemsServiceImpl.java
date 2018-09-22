package com.tejovat.tims.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.ProductItem;
import com.tejovat.tims.repository.ProductItemRepository;
import com.tejovat.tims.service.ProductitemService;

@Service
public class ProductitemsServiceImpl implements ProductitemService{

	@Autowired
	private ProductItemRepository repo;

	@Override
	public List<ProductItem> getProductItems() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public ProductItem saveProductItem(ProductItem item) {
		return repo.save(item);
	}

	@Override
	public ProductItem updateProductItem(ProductItem item) {
		return repo.save(item);
	}

	@Override
	public void deleteProductItem(Integer id) {
		ProductItem productitem = getProductItemDetails(id);
		if(productitem!=null) {
			repo.delete(productitem);
		}
	}

	@Override
	public ProductItem getProductItemDetails(Integer id) {
		Optional<ProductItem> productitem = repo.findById(id);
		if(productitem.isPresent()) {
			return productitem.get();
		}
		return null;
	}

	@Override
	public void updateExcelsheet(List<ProductItem> items) {
		repo.saveAll(items);
	}

	@Override
	public Integer getCount() {
		return (int) repo.count();
	}
	
	

}
