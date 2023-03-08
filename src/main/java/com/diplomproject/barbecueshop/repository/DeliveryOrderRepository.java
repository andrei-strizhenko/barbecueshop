package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.DeliveryOrder;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DeliveryOrderRepository extends GenericRepository<DeliveryOrder> {

    Set<DeliveryOrder> findAllByIdIn(Set<Long> ids);
}

