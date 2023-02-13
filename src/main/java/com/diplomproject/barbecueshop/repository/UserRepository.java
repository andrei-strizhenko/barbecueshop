package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends GenericRepository<User> {
    Set<User> findAllByIdIn(Set<Long> ids);
}
