package com.abhay.webfluxdemo.cotroller;

import com.abhay.webfluxdemo.WebfluxDemoApplication;
import com.abhay.webfluxdemo.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = WebfluxDemoApplication.class
)
class CourseControllerTest {

//    @Autowired
//    private CourseController courseController;

    @Autowired
    WebTestClient webTestClient;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void getCourses() {
//        assertNotNull(courseController);
//        StepVerifier.create(courseController.getCourses())
//                .expectNextCount(4)
//                .verifyComplete();
//    }
//
//    @Test
//    void getCourse() {
//        StepVerifier.create(courseController.getCourse("Java for pro"))
//                .expectNextCount(1)
//                .verifyComplete();
//    }

    @Test
    void shouldGetCourse() {
        webTestClient
                // when
                .get()
                .uri("/courses")
                .exchange()

                // then
                .expectStatus()
                .isOk()
                .expectAll( responseSpec -> responseSpec.expectStatus().isOk(),
                            responseSpec -> responseSpec.expectBodyList(Course.class).hasSize(4)
                );
//                .expectBodyList(Course.class)
//                .hasSize(4);

    }

}