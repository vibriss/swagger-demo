package com.example.demo.controller;


import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Tag(name = "Students", description = "Student-related endpoints")
@RequestMapping("/students")
public interface StudentController {
//
//    @GetMapping
//    ResponseEntity<List<Response>> getAll();

//    @GetMapping("/{number}")
//    ResponseEntity<Response> getByStudentCardNumber(@PathVariable("number") Integer studentCardNumber);
//
//    @PostMapping
//    ResponseEntity<Response> addNewStudent(@RequestBody Request request);















    @Operation(
            summary = "Get all students",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
                    @ApiResponse(responseCode = "204", description = "No content", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping
    ResponseEntity<List<Response>> getAll();

















    @Operation(
            summary = "Get information about student",
            responses =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Response.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Student not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{number}")
    ResponseEntity<Response> getByStudentCardNumber(
            @Parameter(name = "number", description = "Student card unique number", required = true)
            @PathVariable("number") Integer studentCardNumber);


















    @Operation(
            summary = "Add new student",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Response.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Already exists", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping
    ResponseEntity<Response> addNewStudent(
            @Parameter(
                    name = "add student request",
                    description = "student data in add request",
                    schema = @Schema(implementation =  Request.class),
                    required = true)
            @RequestBody Request request) throws Exception;




}
