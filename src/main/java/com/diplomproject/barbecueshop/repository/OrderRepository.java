package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends GenericRepository<Order> {

List<Order> findOrderByProductId(Long productId);
    List<Product> find(Long productId);


}
