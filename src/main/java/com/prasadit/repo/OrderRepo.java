package com.prasadit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasadit.model.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
