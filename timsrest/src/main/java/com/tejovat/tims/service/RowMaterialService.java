package com.tejovat.tims.service;

import java.util.List;

import com.tejovat.tims.model.RowMaterial;

public interface RowMaterialService {
	
	public List<RowMaterial> getList();
	public RowMaterial saveRowMaterial(RowMaterial rowMaterial);
	public RowMaterial getRowMaterialById(Integer id);
	public void deleteRowMaterialById(Integer id);
}
