package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.classes.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.interfaces.IStudentService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class StudentServiceTests {

    @MockBean
    StudentDao studentDao;

    @Autowired
    IStudentService studentService;

    @Configuration
    public static class Config {
        @Bean
        public IStudentService getStudentService() {
            return new StudentService();
        }
    }

    @Test
    void getAllStudentsTest() {
        Student student = new Student(
                "John",
                "Fury",
                4321,
                "RedView Towers");
        given(studentDao.getAllStudents()).willReturn(Arrays.asList(student));
        assertEquals(Arrays.asList(student), studentService.getAllStudents());
    }

}
