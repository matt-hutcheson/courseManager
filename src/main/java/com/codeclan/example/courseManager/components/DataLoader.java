package com.codeclan.example.courseManager.components;

import com.codeclan.example.courseManager.models.Course;
import com.codeclan.example.courseManager.models.Rating;
import com.codeclan.example.courseManager.repositories.CourseRepository;
import com.codeclan.example.courseManager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course course = new Course("Intro To Java", "Inverness", Rating.TWO);
        courseRepository.save(course);
    }
}
