package com.diplomproject.barbecueshop.rest.controller;

import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.dto.OrderUpdateDto;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class OrderControllerTest extends CommonForTest {

    private static final ObjectMapper objectMapper =
            new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Autowired
    OrderRepository orderRepository;

    private final OrderDto orderDto = new OrderDto(0.0, "Дубова", new ArrayList<>());
    private final OrderUpdateDto orderUpdateDto = new OrderUpdateDto("Ерохин");

    @Order(3)
    @Test
    void getOrderList() throws Exception {
        String result = mvc.perform(get("/rest/order/list").headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

    @Order(1) //очередность выполнения
    @Test
    void createOrder() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);

        String result = mvc.perform(
                post("/rest/order/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .headers(headers)
                        .content(asJsonString(orderDto)))
                //                     .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        setIdFromJsonString(result, OrderDto.class);
        System.out.println(result);
    }

    @Order(2)
    @Test
    void updateOrder() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        mvc.perform(put("/rest/order/update/" + testId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .headers(headers)
                .content(asJsonString(orderUpdateDto)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Ерохин"));
          //      .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Дубова"))
         //       .andExpect(MockMvcResultMatchers.jsonPath("$.productsIds").value(null));
    }


    @Order(4)
    @Test
    void getOneOrder() throws Exception {
        headers.clear();
        headers.add("Authorization", "Bearer " + tokenAdmin);
        String result = mvc.perform(get("/rest/order/get-one/" + testId).headers(headers))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

//    @Test
//    void deleteOrder() throws Exception {
//        mvc.perform(delete("/rest/order/delete/" + testId).headers(headers))
//                .andExpect(status().is2xxSuccessful());
//    }




}