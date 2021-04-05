package com.example.demo.dto;

import com.example.demo.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromRequestToStudentConverter implements Converter<Request, Student> {

    @Override
    public Student convert(Request request) {
        return Student.builder()
                .name(request.getName())
                .studentCardNumber(request.getStudentCardNumber())
                .active(request.getActive())
                .build();
    }
}
