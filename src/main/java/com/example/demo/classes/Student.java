package com.example.demo.classes;


public class Student {

    private String firstName;

    private String lastName;

    private Integer studentId;

    private String address;

    public Student(String firstName, String lastName, Integer studentId, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
