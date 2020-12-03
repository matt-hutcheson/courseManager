package com.codeclan.example.courseManager.controllers;

import com.codeclan.example.courseManager.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

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
        if (customerName != null) {
            String lowerCaseName = customerName.toLowerCase();
            return new ResponseEntity(courseRepository.findCourseByBookingsCustomerName(lowerCaseName), HttpStatus.OK);
        }
        if (courseName != null) {
            String lowerCaseName = courseName.toLowerCase();
            return new ResponseEntity(courseRepository.findCourseByName(lowerCaseName), HttpStatus.OK);
        }
        if (courseTown != null) {
            String lowerCaseTown = courseTown.toLowerCase();
            return new ResponseEntity(courseRepository.findCourseByTown(lowerCaseTown), HttpStatus.OK);
        }
        if (rating != null) {
            return new ResponseEntity(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }

        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }
}
