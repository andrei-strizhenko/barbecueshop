package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.Product;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends GenericRepository<Product> {
    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleOrDescriptionOrCost(String title, String description, double cost);

    Set<Product> findAllByIdIn(Set<Long> usersIds);
}
