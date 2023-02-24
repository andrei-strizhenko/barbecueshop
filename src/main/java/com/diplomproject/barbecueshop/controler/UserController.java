package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.UserDto;
import com.diplomproject.barbecueshop.mapper.UserMapper;
import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.security.JwtTokenUtil;
import com.diplomproject.barbecueshop.services.UserService;
import com.diplomproject.barbecueshop.services.userDetails.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/user")
public class UserController extends GenericController<User, UserDto> {

    private final JwtTokenUtil jwtTokenUtil;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserService service;
    protected UserController(UserService service, UserMapper mapper, JwtTokenUtil jwtTokenUtil, CustomUserDetailsService customUserDetailsService) {
        super(service, mapper);
        this.jwtTokenUtil = jwtTokenUtil;
        this.service = service;
        this.customUserDetailsService = customUserDetailsService;
    }

/*    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody LoginDto loginDto) {
        Map<String, Object> response = new HashMap<>();

        if(!service.checkPassword(loginDto)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user!\nWrongPassword");
        }
        UserDetails foundUser = customUserDetailsService.loadUserByUsername(loginDto.getLogin());
        String token = jwtTokenUtil.generateToken(foundUser);
        response.put("token", token);
        response.put("authorities", foundUser.getAuthorities());
        return ResponseEntity.ok().body(response);

    }*/
}

