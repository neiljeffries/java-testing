package com.example.demo.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.classes.Student;

@Component
public class StudentDao {

    private static Student student = new Student(
            "John",
            "McClane",
            1123,
            "123 St, Nyc");

    public List<Student> getAllStudents() {
        return Arrays.asList(student);
    }

}
