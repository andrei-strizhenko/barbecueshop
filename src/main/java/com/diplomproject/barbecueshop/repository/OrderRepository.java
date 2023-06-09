package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends GenericRepository<Order> {

   List<Order> findAllByIdIn(List<Long> ids);

    Set<Order> findAllByIdIn(Set<Long> ids);


}
