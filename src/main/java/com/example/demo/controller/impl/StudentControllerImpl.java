package com.example.demo.controller.impl;

import com.example.demo.controller.StudentController;
import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController{

    private final StudentService studentService;
    private final ConversionService conversionService;

    @Override
    public ResponseEntity<List<Response>> getAll() {
        List<Student> students= studentService.getAll();

        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<Response> listOfResponse = students
                .stream()
                .map(student -> conversionService.convert(student, Response.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listOfResponse);
    }

    @Override
    public ResponseEntity<Response> getByStudentCardNumber(Integer studentCardNumber) {

        if (!studentService.existsByStudentCardNumber(studentCardNumber)) {
            return ResponseEntity.notFound().build();
        }

        Student student = studentService.getByStudentCardNumber(studentCardNumber);

        Response response = conversionService.convert(student, Response.class);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> addNewStudent(Request request) {

        Student student = conversionService.convert(request, Student.class);

        if (studentService.existsByStudentCardNumber(student.getStudentCardNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Student createdStudent = studentService.save(student);

        Response response = conversionService.convert(createdStudent, Response.class);

        return ResponseEntity.ok(response);
    }
}
