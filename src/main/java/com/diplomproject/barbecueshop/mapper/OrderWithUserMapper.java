package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.AddUserInOrderDto;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderWithUserMapper extends GenericMapper<Order, AddUserInOrderDto> {
    private final ModelMapper mapper;
      private final UserRepository userRepository;

    protected OrderWithUserMapper(ModelMapper mapper, UserRepository userRepository) {
        super(mapper, Order.class, AddUserInOrderDto.class);
        this.mapper = mapper;
        this.userRepository = userRepository;

    }
}

