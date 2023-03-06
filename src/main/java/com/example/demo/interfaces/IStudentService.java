package com.example.demo.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.classes.Student;

@Service
public interface IStudentService {

    List<Student> getAllStudents();

}
