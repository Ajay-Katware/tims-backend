package com.tejovat.tims.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.ProductMaster;

@Repository
public interface ProductRepository extends CrudRepository<ProductMaster, Integer>{

}
