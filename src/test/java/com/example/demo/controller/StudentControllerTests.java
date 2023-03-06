package com.example.demo.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.classes.Student;
import com.example.demo.interfaces.IStudentService;


@ContextConfiguration(classes = StudentController.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTests {

    private static final Logger LOG = LoggerFactory.getLogger(StudentControllerTests.class);

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentService studentService;

    @Test
    void getAllStudentsTest() throws Exception {
        LOG.trace("This is a TRACE log");
        LOG.debug("This is a DEBUG log");
        LOG.info("This is an INFO log");
        LOG.error("This is an ERROR log");
        given(studentService.getAllStudents())
                .willReturn(Arrays.asList(new Student(
                        "Nik",
                        "Devou",
                        1234,
                        "Eden Villa")));
        mockMvc.perform(get("/api/students"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[*].studentId").value(1234));
                // .andDo(print());
        verify(studentService).getAllStudents();
    }

}
