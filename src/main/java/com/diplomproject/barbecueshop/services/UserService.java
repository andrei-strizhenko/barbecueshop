package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserService extends GenericService<User> {
    private final UserRepository repository;
    private  final RoleService roleService;

    public UserService(UserRepository repository, RoleService roleService) {
        super(repository);
        this.repository = repository;
        this.roleService = roleService;
    }

}
