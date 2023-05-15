package com.prasadit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasadit.model.OrderEntity;
import com.prasadit.repo.OrderRepo;
@Service
public class Serviceimpl implements OrderService{
	@Autowired
	private OrderRepo orderrepo;

	@Override
	public boolean saveData(OrderEntity orderentity) {
		OrderEntity save = orderrepo.save(orderentity);
		return save.getProductid()!=null;
	}

	@Override
	public boolean deleteData(Integer id) {
		boolean status=false;
		try {
		orderrepo.deleteById(id);
		status=true;
		}catch(Exception e ) {e.printStackTrace();}
		return status;
	}

	@Override
	public List<OrderEntity> getDetails() {
		List<OrderEntity> findAll = orderrepo.findAll();
		return findAll;
	}

	@Override
	public boolean editdata(OrderEntity orderentity) {
		OrderEntity save = orderrepo.save(orderentity);
		return save.getProductid()!=null;
	}

	@Override
	public List<OrderEntity> getDetailsById(Integer id) {
		 Optional<OrderEntity> findById = orderrepo.findById(id);
		if(findById.isPresent()) findById.get();
		return null;
	}

}
