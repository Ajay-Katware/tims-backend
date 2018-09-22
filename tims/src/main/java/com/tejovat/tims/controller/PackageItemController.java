package com.tejovat.tims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.model.PackageItem;
import com.tejovat.tims.service.PackageItemService;

@RestController
@RequestMapping("/packageitem")
public class PackageItemController {

	@Autowired
	private PackageItemService packageItemService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<PackageItem> getAll() throws Exception{
		return packageItemService.getList();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PackageItem> saveEntity(@RequestBody PackageItem packageItem, HttpServletRequest request) throws Exception {
		PackageItem packageItem2 = packageItemService.save(packageItem);
		return ResponseEntity.ok().body(packageItem2);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public  ResponseEntity<PackageItem> getById(@PathVariable("id") Integer id) throws Exception {
		PackageItem packageItem = packageItemService.get(id);
		return ResponseEntity.ok().body(packageItem);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeEntity(@PathVariable("id") Integer id) throws Exception {
		packageItemService.remove(id);
	}


}
