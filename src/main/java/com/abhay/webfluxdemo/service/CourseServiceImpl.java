package com.abhay.webfluxdemo.service;

import com.abhay.webfluxdemo.model.Author;
import com.abhay.webfluxdemo.model.Course;
import com.abhay.webfluxdemo.repository.CourseRepository;
import com.abhay.webfluxdemo.repository.FakeCourseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Flux<Course> getCourses(){
        return courseRepository.findAll();
    }

    @Override
    public Mono<Course> getCourse(String title) {
        return courseRepository.findCourseByTitle(title);
    }

    @Override
    public void save(Mono<Course> course) {
        courseRepository.save(course.block());
    }


}
