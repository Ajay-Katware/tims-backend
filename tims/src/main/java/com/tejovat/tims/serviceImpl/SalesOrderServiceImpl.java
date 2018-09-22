package com.tejovat.tims.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.SalesOrder;
import com.tejovat.tims.repository.SalesOrderRepository;
import com.tejovat.tims.service.SalesOrderService;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{

	@Autowired
	private SalesOrderRepository repo;

	@Override
	public List<SalesOrder> getSalesOrders() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public SalesOrder saveSalesOrder(SalesOrder salesOrder) {
		return repo.save(salesOrder);
	}

	@Override
	public SalesOrder updateSalesOrder(SalesOrder salesOrder) {
		return repo.save(salesOrder);
	}

	@Override
	public SalesOrder getSalesOrderDetails(Integer id) {
		Optional<SalesOrder> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteSalesOrder(Integer id) {
		SalesOrder salesOrder = getSalesOrderDetails(id);
		if(salesOrder!=null) {
			repo.delete(salesOrder);
		}
	}

	@Override
	public String getNextSOnumber() {
		SalesOrder salesOrder =  repo.findFirstByOrderByIdDesc();
		if(salesOrder!=null) {
			String previousNo = salesOrder.getSalesorderno();
			String part_list[] = previousNo.split("-");
			return "SO-"+(Integer.parseInt(part_list[1]) + 1);
		}else {
			return "SO"+"-"+(1001);
		}
	}

	@Override
	public Integer getCount() {
		return (int) repo.count();
	}

	@Override
	public String getNextInvoiceNumber() {
		SalesOrder salesOrder =  repo.findFirstByOrderByInvoicenoDesc();
		if(salesOrder!=null) {
			String previousNo = salesOrder.getInvoiceno();
			String part_list[] = previousNo.split("-");
			return "INV-"+(Integer.parseInt(part_list[1]) + 1);
		}else {
			return "INV"+"-"+(1001);
		}
	}

	@Override
	public List<SalesOrder> getInvoices() {
		return repo.findByInvoicenoIsNotNullOrderByInvoicenoDesc();
	}

	@Override
	public Integer getInvoiceCount() {
		 List<SalesOrder> list = repo.findByInvoicenoIsNotNullOrderByInvoicenoDesc();
		 if(list.size()>0) {
			 return list.size();
		 }else {
			 return 0;
		 }
		 
	}
}
