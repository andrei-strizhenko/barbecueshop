package com.diplomproject.barbecueshop.rest.controller;

import com.diplomproject.barbecueshop.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class RoleControllerTest extends CommonForTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    void getRoleList() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        String result = mvc.perform(get("/role/list").headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }
}