package com.diplomproject.barbecueshop.rest.controller;

import com.diplomproject.barbecueshop.dto.ProductDto;
import com.diplomproject.barbecueshop.dto.ProductUpdateDto;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class ProductControllerTest extends CommonForTest {

    @Autowired
    ProductRepository productRepository;

    private final ProductDto productDto = new ProductDto("MANAGER","Тестовый шашлык", "Тестовый шашлык", 10.0,6.0,"www",2L,0L, new ArrayList<>(1), new HashSet<Long>(1));
    private final ProductUpdateDto productUpdateDto = new ProductUpdateDto("UpdateTitle");

    @Order(3)
    @Test
    void getProductList() throws Exception {
        String result = mvc.perform(get("/rest/product/list").headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

    @Order(1) //очередность выполнения
    @Test
    void createProduct() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);

        String result = mvc.perform(
                post("/rest/product/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .headers(headers)
                        .content(asJsonString(productDto)))
            //                     .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        setIdFromJsonString(result, ProductDto.class);
        System.out.println(result);
    }

    @Order(2)
    @Test
    void updateProduct() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        mvc.perform(put("/rest/product/update/" + testId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .headers(headers)
                .content(asJsonString(productUpdateDto)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("UpdateTitle"));
    }


    @Order(4)
    @Test
    void getOneProduct() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        String result = mvc.perform(get("/rest/product/get-one/" + testId).headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

    @Test
    void deleteProduct() throws Exception {
        mvc.perform(delete("/rest/product/delete/" + testId).headers(headers))
                .andExpect(status().is2xxSuccessful());
    }




}