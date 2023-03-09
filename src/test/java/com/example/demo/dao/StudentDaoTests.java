package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.classes.Student;

public class StudentDaoTests {

    private StudentDao studentDao;
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "McClane";
    private static final int ID = 1123;
    private static final String ADDRESS = "123 St, Nyc";

    @BeforeEach
    public void setUp() {
        studentDao = new StudentDao();
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentDao.getAllStudents();
        assertNotNull(students);
        assertEquals(1, students.size());

        Student student = students.get(0);
        assertNotNull(student);
        assertEquals(FIRST_NAME, student.getFirstName());
        assertEquals(LAST_NAME, student.getLastName());
        assertEquals(ID, student.getStudentId());
        assertEquals(ADDRESS, student.getAddress());
    }

    @Test
    public void testGetStudent() {
        Student student = StudentDao.getStudent();
        assertNotNull(student);
        assertEquals(FIRST_NAME, student.getFirstName());
        assertEquals(LAST_NAME, student.getLastName());
        assertEquals(ID, student.getStudentId());
        assertEquals(ADDRESS, student.getAddress());
    }

    @Test
    public void testSetStudent() {
        Student newStudent = mock(Student.class);
        when(newStudent.getFirstName()).thenReturn("Bruce");
        when(newStudent.getLastName()).thenReturn("Willis");
        when(newStudent.getStudentId()).thenReturn(999);
        when(newStudent.getAddress()).thenReturn("456 St, LA");

        StudentDao.setStudent(newStudent);

        Student student = StudentDao.getStudent();
        assertNotNull(student);
        assertEquals("Bruce", student.getFirstName());
        assertEquals("Willis", student.getLastName());
        assertEquals(999, student.getStudentId());
        assertEquals("456 St, LA", student.getAddress());
    }
}
