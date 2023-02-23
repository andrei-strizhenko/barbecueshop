package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends GenericRepository<Product> {
    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleOrDescriptionOrCost(String title, String description, double cost);

  // Set<Product> findAllByIdIn(Set<Long> usersIds);

    List<Product> findAllByIdIn(List<Long> ids);


}
