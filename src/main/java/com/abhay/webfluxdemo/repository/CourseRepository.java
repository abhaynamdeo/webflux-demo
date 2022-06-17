package com.abhay.webfluxdemo.repository;

import com.abhay.webfluxdemo.model.Course;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CourseRepository{
    Flux<Course> findAll();

    void save(Course nueCourse);

    void saveAll(List<Course> nueCourses);

    Flux<Course> findCourseByTitleContaining(String phrase);
    Mono<Course> findCourseByTitle(String title);
}
