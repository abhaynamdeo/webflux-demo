package com.abhay.webfluxdemo.cotroller;

import com.abhay.webfluxdemo.model.Course;
import com.abhay.webfluxdemo.model.CourseValidator;
import com.abhay.webfluxdemo.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveHandlers {
    CourseService courseService;
    CourseValidator courseValidator;

    public ReactiveHandlers(CourseService courseService, CourseValidator courseValidator) {
        this.courseService = courseService;
        this.courseValidator = courseValidator;
    }

    Mono<ServerResponse> getCourseHandler(ServerRequest req) {
        return ServerResponse.ok().body(courseService.getCourse(req.pathVariable("title")), Course.class);
    }


    Mono<ServerResponse> getCoursesHandler(ServerRequest req) {
        return ServerResponse.ok().body(BodyInserters.fromProducer(courseService.getCourses(), Course.class));
//                Flux.just(courseService.getCourses()), Course.class);
    }
}
