package com.diplomproject.barbecueshop.repository;


import com.diplomproject.barbecueshop.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> {

}

