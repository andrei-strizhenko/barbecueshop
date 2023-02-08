package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.UserDto;
import com.diplomproject.barbecueshop.mapper.UserMapper;
import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.services.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/user")
public class UserController extends GenericController<User, UserDto> {

    protected UserController(GenericService<User> service, UserMapper userMapper) {
        super(service, userMapper);
    }
}
