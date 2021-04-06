package com.example.demo.controller;


import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/students")
public interface StudentController {

    @GetMapping
    ResponseEntity<List<Response>> getAll();

    @GetMapping("/{number}")
    ResponseEntity<Response> getByStudentCardNumber(@PathVariable("number") Integer studentCardNumber);

    @PostMapping
    ResponseEntity<Response> addNewStudent(@RequestBody Request request);
}
