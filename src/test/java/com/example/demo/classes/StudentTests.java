package com.example.demo.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTests {

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "McClane";
    private static final int ID = 1123;
    private static final String ADDRESS = "123 St, Nyc";

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student(FIRST_NAME, LAST_NAME, ID, ADDRESS);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(FIRST_NAME, student.getFirstName());
        assertEquals(LAST_NAME, student.getLastName());
        assertEquals(ID, student.getStudentId());
        assertEquals(ADDRESS, student.getAddress());
    }

    @Test
    public void testSetters() {
        String newFirstName = "Bruce";
        student.setFirstName(newFirstName);
        assertEquals(newFirstName, student.getFirstName());

        String newLastName = "Willis";
        student.setLastName(newLastName);
        assertEquals(newLastName, student.getLastName());

        int newId = 999;
        student.setStudentId(newId);
        assertEquals(newId, student.getStudentId());

        String newAddress = "456 St, LA";
        student.setAddress(newAddress);
        assertEquals(newAddress, student.getAddress());
    }

    @Test
    public void testNullValues() {
        Student student = new Student(null, null, null, null);

        assertNull(student.getFirstName());
        assertNull(student.getLastName());
        assertNull(student.getStudentId());
        assertNull(student.getAddress());
    }
}

