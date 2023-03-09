package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.classes.Student;
import com.example.demo.interfaces.IStudentService;

public class StudentControllerTests {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test get all students")
    void testGetAllStudents() {
        // Mock data
        List<Student> studentList = Arrays.asList(
                new Student("John", "McClane", 1123, "123 St, Nyc"),
                new Student("Sarah", "Connor", 1124, "456 St, LA"));

        // Mock service method
        when(studentService.getAllStudents()).thenReturn(studentList);

        // Call controller method
        ResponseEntity<List<Student>> responseEntity = studentController.getAllStudents();

        // Verify response status
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verify response body
        List<Student> responseBody = responseEntity.getBody();
        assertEquals(studentList.size(), responseBody.size());
        assertEquals(studentList.get(0).getFirstName(), responseBody.get(0).getFirstName());
        assertEquals(studentList.get(0).getLastName(), responseBody.get(0).getLastName());
        assertEquals(studentList.get(0).getStudentId(), responseBody.get(0).getStudentId());
        assertEquals(studentList.get(0).getAddress(), responseBody.get(0).getAddress());
        assertEquals(studentList.get(1).getFirstName(), responseBody.get(1).getFirstName());
        assertEquals(studentList.get(1).getLastName(), responseBody.get(1).getLastName());
        assertEquals(studentList.get(1).getStudentId(), responseBody.get(1).getStudentId());
        assertEquals(studentList.get(1).getAddress(), responseBody.get(1).getAddress());
    }
}
