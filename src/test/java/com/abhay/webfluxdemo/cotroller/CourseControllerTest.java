package com.abhay.webfluxdemo.cotroller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    private CourseController courseController;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCourses() {
        assertNotNull(courseController);
        StepVerifier.create(courseController.getCourses())
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void getCourse() {
        StepVerifier.create(courseController.getCourse("Java for pro"))
                .expectNextCount(1)
                .verifyComplete();
    }
}