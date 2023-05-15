package com.prasadit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prasadit.model.OrderEntity;
import com.prasadit.service.Serviceimpl;

@RestController
@CrossOrigin
public class OrderRestCont {
	@Autowired
	private Serviceimpl orderservice;
	@GetMapping("/home")
	public ResponseEntity<String>getMsg(){
		String msg="KnotSolutions";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}			
	@PostMapping("/order")
	public ResponseEntity<String>saveOrder(@RequestBody OrderEntity orderentity){
		String str="";
		boolean saveData = orderservice.saveData(orderentity);	
	if(saveData)str="plansaved";else str="plan is not saved";
	return new ResponseEntity<>(str,HttpStatus.CREATED);	
	}
	@GetMapping("/orders")
	public ResponseEntity<List<OrderEntity>>getOrderDetails(){
		List<OrderEntity> details = orderservice.getDetails();
		return new ResponseEntity<>(details,HttpStatus.OK);
	}
	@PutMapping("/orders/{id}")
	public ResponseEntity<String>updateOrder(@RequestBody OrderEntity orderentity){
		boolean editdata = orderservice.editdata(orderentity);
		String msg="";
		if(editdata)msg="order is edited"; else msg="order is not edited";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<String>deleteProduct(@PathVariable Integer id){
		String msg="";
		boolean deleteData = orderservice.deleteData(id);
		
		if(deleteData)msg="record is delete"; else msg="record is not delete";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@GetMapping("/orders/{id}")
	public ResponseEntity<List<OrderEntity>>getFindById(@PathVariable Integer id){
		List<OrderEntity> detailsByName = orderservice.getDetailsById(id);
	return new ResponseEntity<>(detailsByName,HttpStatus.OK);
	}
	
}
