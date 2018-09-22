package com.tejovat.tims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tejovat.tims.model.ProductItem;
import com.tejovat.tims.service.ProductitemService;

@RestController
@RequestMapping("/productitems")
public class ProductItemController {

//	@Autowired
//	private ProductmasterService productService;

	@Autowired
	private ProductitemService productItemService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ProductItem> getAllProductItems() throws Exception{
		return productItemService.getProductItems();
	}

	@RequestMapping(value = "/excelsheet/{productid}", method = RequestMethod.POST)
	public String insertItemFromExcelsheet(@PathVariable("productid") Integer productid, @RequestParam("excelfile") MultipartFile excelfile) throws Exception{
		//ProductMaster product = productService.getProductDetails(productid);
		try {
			List<ProductItem> lstItems = new ArrayList<ProductItem>();
		/*	XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());

			XSSFSheet worksheet = workbook.getSheetAt(0);

			for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
				ProductItem productitem = new ProductItem();

				XSSFRow row = worksheet.getRow(i);

				productitem.setProductid(product);
				productitem.setItemCode(row.getCell(1).getStringCellValue());
				productitem.setSerialNo(row.getCell(2).getStringCellValue());
				productitem.setBarcode(productitem.getItemCode());
				lstItems.add(productitem);
			}
			workbook.close();*/
			productItemService.updateExcelsheet(lstItems);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "suceess";
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItem item, HttpServletRequest request) throws Exception {
		ProductItem productitem = productItemService.saveProductItem(item);
		return ResponseEntity.ok().body(productitem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public ProductItem getProductItemDetailsById(@PathVariable("id") Integer id) throws Exception {
		ProductItem productitem = productItemService.getProductItemDetails(id);
		return productitem;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductItem(@PathVariable("id") Integer id) throws Exception {
		productItemService.deleteProductItem(id);
	}

}
