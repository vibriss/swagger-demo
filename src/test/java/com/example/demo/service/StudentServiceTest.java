package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.quality.Strictness;

public class StudentServiceTest {

    private Student testStudent;

    private Student expectedStudent;

    private MockitoSession mockitoSession;

    @InjectMocks
    private  StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void initMocks() {
        mockitoSession = Mockito.mockitoSession()
                .initMocks(this)
                .strictness(Strictness.STRICT_STUBS)
                .startMocking();
    }

    @AfterEach
    void finishMocking() {
        mockitoSession.finishMocking();
    }

    @Test
    void givenNothing_whenSaveStudent_thenReturnStudent() {}
}
