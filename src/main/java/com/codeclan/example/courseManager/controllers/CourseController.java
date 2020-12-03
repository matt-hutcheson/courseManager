package com.codeclan.example.courseManager.controllers;

import com.codeclan.example.courseManager.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @GetMapping(value = "/courses")
    public ResponseEntity getAllCoursesAndFilters(
            @RequestParam(required = false, name = "courseName")String courseName,
            @RequestParam(required = false, name = "town")String courseTown,
            @RequestParam(required = false, name = "rating")Integer rating,
            @RequestParam(required = false, name = "customerName")String customerName
    ){
        if (courseName != null) {
            return new ResponseEntity(courseRepository.findCourseByName(courseName), HttpStatus.OK);
        }
        if (courseTown != null) {
            return new ResponseEntity(courseRepository.findCourseByTown(courseTown), HttpStatus.OK);
        }
        if (rating != null) {
            return new ResponseEntity(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }
        if (rating != null) {
            return new ResponseEntity(courseRepository.findCourseByBookingsCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }
}
