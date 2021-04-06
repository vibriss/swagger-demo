package com.example.demo.controller;

import com.example.demo.dto.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql(scripts = "/prepare_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class StudentControllerImplTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private Request request = Request.builder().name("Test").studentCardNumber(123).active(true).build();

    @Test
    @Order(1)
    void givenRequest_whenAddNewStudent_thanReturnStudent() throws Exception {
            mvc.perform(post("/students").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    @Order(2)
    void givenNothing_whenGetAllStudents_thanReturnStatus204() throws Exception {
        mvc.perform(get("/students"))
                .andExpect(status().isNoContent());

    }
}
