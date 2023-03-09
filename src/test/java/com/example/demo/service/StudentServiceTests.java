package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.classes.Student;
import com.example.demo.dao.StudentDao;

public class StudentServiceTests {

    @Mock
    private StudentDao studentDao;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        Student student = new Student("John", "McClane", 1123, "123 St, Nyc");
        List<Student> expected = Arrays.asList(student);
        when(studentDao.getAllStudents()).thenReturn(expected);

        List<Student> actual = studentService.getAllStudents();
        assertEquals(expected, actual);
    }
}
