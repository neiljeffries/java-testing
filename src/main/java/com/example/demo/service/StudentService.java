package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.classes.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

}
