package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends GenericRepository<Order> {

Set<Order> findAllByIdIn(Set<Long> ids);



}
