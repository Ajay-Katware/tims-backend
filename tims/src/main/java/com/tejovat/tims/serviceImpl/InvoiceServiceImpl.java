package com.tejovat.tims.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.Invoice;
import com.tejovat.tims.repository.InvoiceRepository;
import com.tejovat.tims.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceRepository repo;

	@Override
	public List<Invoice> getList() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<Invoice> getActiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invoice> getDeactiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice save(Invoice invoice) {
		return repo.save(invoice);
	}

	@Override
	public Invoice update(Invoice invoice) {
		return repo.save(invoice);
	}
	

	@Override
	public Invoice get(Integer id) {
		Optional<Invoice> item = repo.findById(id);
		if(item.isPresent()) {
			return item.get();
		}else {
			return null;
		}
	}

	@Override
	public void remove(Integer id) {
		Invoice object = get(id);
		if(object!=null) {
			repo.delete(object);
		}
	}

	@Override
	public Integer getCount() {
		return (int) repo.count();
	}

}
