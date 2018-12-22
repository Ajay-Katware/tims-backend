package com.tejovat.tims.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.RowMaterial;
import com.tejovat.tims.repository.RowMaterialRepository;
import com.tejovat.tims.service.RowMaterialService;

@Service
public class RowMaterialServiceImpl implements RowMaterialService{

	@Autowired
	private RowMaterialRepository repo;
	
	@Override
	public List<RowMaterial> getList() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public RowMaterial saveRowMaterial(RowMaterial rowMaterial) {
		return repo.save(rowMaterial);
	}

	@Override
	public RowMaterial getRowMaterialById(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteRowMaterialById(Integer id) {
		repo.delete(id);
	}

}
