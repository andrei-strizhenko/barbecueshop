package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.Provider;
import com.diplomproject.barbecueshop.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ProviderRepository extends GenericRepository<Provider> {


        Set<Provider> findAllByIdIn(Set<Long> ids);


}
