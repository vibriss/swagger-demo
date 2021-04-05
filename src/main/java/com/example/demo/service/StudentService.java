package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Boolean existsByStudentCardNumber(Integer studentCardNumber) {
        return studentRepository.existsByStudentCardNumber(studentCardNumber);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getByStudentCardNumber(Integer studentCardNumber) {
        return studentRepository.findByStudentCardNumber(studentCardNumber);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
