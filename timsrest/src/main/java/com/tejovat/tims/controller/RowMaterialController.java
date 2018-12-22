package com.tejovat.tims.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.model.RowMaterial;
import com.tejovat.tims.service.RowMaterialService;

@RestController
@RequestMapping("/material")
public class RowMaterialController {
	
	@Autowired
	private RowMaterialService rowMaterialService;
	
	@GetMapping("")
	public List<RowMaterial> getList(){
		return rowMaterialService.getList();
	}
	
	@GetMapping("/{id}")
	public RowMaterial getRowMaterialById(@PathVariable Integer id) {
		return rowMaterialService.getRowMaterialById(id);
	}
	
	@PostMapping("")
	public RowMaterial saveRowMaterial(@RequestBody RowMaterial rowMaterial) {
		return rowMaterialService.saveRowMaterial(rowMaterial);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> removeRowMaterial(@PathVariable Integer id){
		RowMaterial rowMaterial = rowMaterialService.getRowMaterialById(id);
		if(rowMaterial!=null) {
			rowMaterialService.deleteRowMaterialById(id);
			return Collections.singletonMap("message", "row material deleted successfully");
		}else {
			return Collections.singletonMap("message", "Row Material Not found.");
		}
	}
}
