package com.example.demo.dto;

import com.example.demo.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromStudentToResponseConverter implements Converter<Student, Response> {

    @Override
    public Response convert(Student student) {
        return Response.builder()
                .id(student.getId())
                .name(student.getName())
                .studentCardNumber(student.getStudentCardNumber())
                .active(student.getActive())
                .build();
    }
}
