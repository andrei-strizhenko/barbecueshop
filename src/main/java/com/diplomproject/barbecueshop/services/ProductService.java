package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.repository.GenericRepository;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


@Service
public class ProductService extends GenericService<Product> {

    private final ProductRepository repository;

    protected ProductService(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Product> searchByTitle(String title) {
        return repository.findAllByTitle(title);
    }

  /*  public Page<Product> listAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);*/
    }


