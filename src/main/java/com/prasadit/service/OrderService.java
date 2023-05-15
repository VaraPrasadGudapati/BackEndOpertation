package com.prasadit.service;

import java.util.List;

import com.prasadit.model.OrderEntity;
 
public interface OrderService {
	 boolean saveData(OrderEntity orderentity);
	 boolean deleteData(Integer id);
	public List<OrderEntity>getDetails();
	 boolean editdata(OrderEntity orderentity);
	 List<OrderEntity> getDetailsById(Integer id);
	 
}
