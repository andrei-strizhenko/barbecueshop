package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.model.Role;
import com.diplomproject.barbecueshop.services.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/role") //localhost:9092/role
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/list") //localhost:9092/role/list
    public List<Role> list() {
        return service.getList();
    }

}



