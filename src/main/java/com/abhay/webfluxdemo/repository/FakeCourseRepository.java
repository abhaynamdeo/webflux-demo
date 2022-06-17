package com.abhay.webfluxdemo.repository;

import com.abhay.webfluxdemo.model.Author;
import com.abhay.webfluxdemo.model.Course;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FakeCourseRepository implements CourseRepository{


    List<Course> courses = Arrays.asList(new Course(0, "Java for beginners", new Author(1, "New", "Bee")),
            new Course(1, "java", new Author(2, "Pro", "Bee")),
            new Course(2, "Java for all", new Author(3, "ALL", "Bee")),
            new Course(3, "Java for beginners", new Author(4,"New", "Bee"))
    );

    @Override
    public Flux<Course> findAll() {
        return Flux.fromIterable(courses);
    }

    @Override
    public void save(Course nueCourse) {
        courses.add(nueCourse);
    }


    @Override
    public void saveAll(List<Course> nueCourses) {
        courses.addAll(nueCourses);
    }

    @Override
    public Flux<Course> findCourseByTitleContaining(String phrase) {
        return Flux.fromIterable(courses.stream().filter(c -> c.getTitle().contains(phrase)).collect(Collectors.toList()));
    }

    @Override
    public Mono<Course> findCourseByTitle(String title) {
        return Mono.justOrEmpty(courses.stream().filter(c -> c.getTitle().contains(title)).findFirst());
    }
}
