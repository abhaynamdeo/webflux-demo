package com.abhay.webfluxdemo.cotroller;

import com.abhay.webfluxdemo.model.Course;
import com.abhay.webfluxdemo.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ReactiveController {

    private CourseService courseService;
    private ReactiveHandlers handlers;

    public ReactiveController(CourseService courseService, ReactiveHandlers handlers) {
        this.courseService = courseService;
        this.handlers = handlers;
    }

    @Bean
    RouterFunction<ServerResponse> getEmployeeByIdRoute() {
        return RouterFunctions.route()
        .GET("reative/course/{title}", accept(MediaType.APPLICATION_JSON), handlers::getCourseHandler)
        .GET("reative/courses", accept(MediaType.APPLICATION_JSON), handlers::getCoursesHandler)
        .build();

    }
}
