package com.diplomproject.barbecueshop.rest.controller;


import com.diplomproject.barbecueshop.dto.RoleDto;
import com.diplomproject.barbecueshop.dto.UserDto;
import com.diplomproject.barbecueshop.dto.UserUpdateDto;
import com.diplomproject.barbecueshop.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class UserControllerTest extends CommonForTest {

    @Autowired
    UserRepository userRepository;

    private final RoleDto roleDto = new RoleDto(2L, "user","user");
    private final UserDto userDto = new UserDto( roleDto, "testName", "testSurname", "testLogin2", "testPassword2",
            "testBirthDate","testEmail","testPhone","testAddress");
    private final UserUpdateDto userUpdateDto = new UserUpdateDto("testLogin2","testPassword2");


    @Order(3)
    @Test
    void getUserList() throws Exception {
        String result = mvc.perform(get("/rest/user/list").headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

    @Order(1) //очередность выполнения
    @Test
    void createUser() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);

        String result = mvc.perform(
                post("/rest/user/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .headers(headers)
                        .content(asJsonString(userDto)))
       //                 .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        setIdFromJsonString(result, UserDto.class);
        System.out.println(result);
    }

    @Order(2)
    @Test
    void updateUser() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        mvc.perform(put("/rest/user/update/" + testId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .headers(headers)
                .content(asJsonString(userUpdateDto)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("testLogin2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("testPassword2"));
            //    .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("new@yandex.ru"));
    }


    @Order(4)
    @Test
    void getOneUser() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        String result = mvc.perform(get("/rest/user/get-one/" + testId).headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

    @Test
    void deleteUser() throws Exception {
        mvc.perform(delete("/rest/user/delete/" + testId).headers(headers))
                .andExpect(status().is2xxSuccessful());
    }




}
