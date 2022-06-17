package com.abhay.webfluxdemo.cotroller;

import com.abhay.webfluxdemo.model.Course;
import com.abhay.webfluxdemo.service.CourseServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;


@RestController
@RequestMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

    private CourseServiceImpl courseServiceImpl;

    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping
    public Flux<Course> getCourses(){
        return courseServiceImpl.getCourses();
    }

    @GetMapping(value = "/{title}")
    public Mono<Course> getCourse(@PathVariable String title) {
        return courseServiceImpl.getCourse(title);
    }

    @PostMapping(consumes =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCourse(@RequestBody Mono<Course> courseMono) {
        try {
            System.out.println("in post..");
            System.out.println("course " + courseMono.block());
            courseServiceImpl.save(courseMono);
            return ResponseEntity
                    .ok()
                    .body(courseMono);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new CourseNotValidException());
        }
    }

    @ExceptionHandler ({CourseNotValidException.class, IOException.class})
    public ResponseEntity handle(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
