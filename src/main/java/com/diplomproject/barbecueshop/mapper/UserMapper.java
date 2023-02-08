package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.UserDto;
import com.diplomproject.barbecueshop.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends GenericMapper<User, UserDto>{

    protected UserMapper(ModelMapper mapper) {
        super(mapper, User.class, UserDto.class);
    }
}
