package com.abhay.webfluxdemo.service;

import com.abhay.webfluxdemo.model.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {
    Flux<Course> getCourses();

    Mono<Course> getCourse(String title);

    void save(Mono<Course> courseMono);

}
