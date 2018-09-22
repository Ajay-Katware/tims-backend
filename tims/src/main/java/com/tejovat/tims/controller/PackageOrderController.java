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

import com.tejovat.tims.dto.AutoNumberDto;
import com.tejovat.tims.model.PackageItem;
import com.tejovat.tims.model.PackageOrder;
import com.tejovat.tims.service.PackageItemService;
import com.tejovat.tims.service.PackageOrderService;

@RestController
@RequestMapping("/packageorder")
public class PackageOrderController {
	
	@Autowired
	private PackageOrderService packageOrderService;
	
	@Autowired
	private PackageItemService itemService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<PackageOrder> getAll() throws Exception{
		return packageOrderService.getList();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PackageOrder> saveEntity(@RequestBody PackageOrder packageOrder, HttpServletRequest request) throws Exception {
		PackageOrder packageOrder2 = packageOrderService.save(packageOrder);
		List<PackageItem> packageItems = packageOrder.getPackageItemsList();
		for(PackageItem item: packageItems) {
			item.setPackageid(packageOrder2.getId());
			itemService.save(item);
		}
		return ResponseEntity.ok().body(packageOrder2);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public  ResponseEntity<PackageOrder> getById(@PathVariable("id") Integer id) throws Exception {
		PackageOrder packageOrder = packageOrderService.get(id);
		return ResponseEntity.ok().body(packageOrder);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeEntity(@PathVariable("id") Integer id) throws Exception {
		packageOrderService.remove(id);
	}
	
	@RequestMapping(value = "/nextpkgnumber", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ResponseEntity<AutoNumberDto> getNextPackageNo() {
		AutoNumberDto autoNumberDto = new AutoNumberDto();
		String packageno = packageOrderService.getNextPackageNumber();
		autoNumberDto.setNextno(packageno);
		return ResponseEntity.ok().body(autoNumberDto);
	}
	
	@RequestMapping(value = "/nextshipnumber", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ResponseEntity<AutoNumberDto> getNextShipmentNo() {
		AutoNumberDto autoNumberDto = new AutoNumberDto();
		String shipmentno = packageOrderService.getNextShipmentNumber();
		autoNumberDto.setNextno(shipmentno);
		return ResponseEntity.ok().body(autoNumberDto);
	}

}
