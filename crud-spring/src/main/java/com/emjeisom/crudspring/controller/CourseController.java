package com.emjeisom.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emjeisom.crudspring.model.Course;
import com.emjeisom.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    
    private final CourseRepository courseRepository;

    // O lombok cria o construtor através da anatação @AllArgsConstructor
    // public CourseController(CourseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // }

    @GetMapping("/")
    public List<Course> list(){
        return courseRepository.findAll();
    }




}
