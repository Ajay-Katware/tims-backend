package com.tejovat.tims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Integer>{

}
