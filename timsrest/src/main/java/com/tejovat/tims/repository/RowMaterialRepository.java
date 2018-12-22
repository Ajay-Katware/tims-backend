package com.tejovat.tims.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.RowMaterial;

@Repository
public interface RowMaterialRepository extends JpaRepository<RowMaterial, Serializable> {
	
}
