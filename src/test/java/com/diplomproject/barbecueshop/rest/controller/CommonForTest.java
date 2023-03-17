package com.diplomproject.barbecueshop.rest.controller;

import com.diplomproject.barbecueshop.dto.GenericDto;
import com.diplomproject.barbecueshop.security.JwtTokenUtil;
import com.diplomproject.barbecueshop.services.userDetails.CustomUserDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommonForTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public MockMvc mvc;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    public String tokenAdmin = "";
    public String tokenUser = "";
    public String tokenManager = "";
    public Long testId;
    HttpHeaders headers = new HttpHeaders();

    private String generateToken(String username) {
        return jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(username));
    }

    @BeforeAll
    public void prepare() {
        tokenAdmin = generateToken("admin");
        tokenUser = generateToken("user");
        tokenManager = generateToken("manager");
        //   headers.add("Authorization", "Bearer " + token);
    }


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends GenericDto> void setIdFromJsonString(String jsonString, Class<T> classType) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            T newObject = mapper.readValue(jsonString, classType);
            testId = newObject.getId();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
