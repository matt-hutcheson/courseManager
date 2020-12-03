package com.codeclan.example.courseManager.components;

import com.codeclan.example.courseManager.models.Booking;
import com.codeclan.example.courseManager.models.Course;
import com.codeclan.example.courseManager.models.Customer;
import com.codeclan.example.courseManager.repositories.BookingRepository;
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

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("Intro To Java", "Inverness", 2);
        courseRepository.save(course1);
        Course java = new Course("Professional Software Development", "Edinburgh", 4);
        courseRepository.save(java);
        Customer bob = new Customer("Bob", "Stirling", 36);
        customerRepository.save(bob);
        Customer jeannie = new Customer("Jeannie", "Falkirk", 25);
        customerRepository.save(jeannie);
        Booking booking = new Booking("12/21", java, bob);
        bookingRepository.save(booking);
        Booking booking1 = new Booking("11/21", java, jeannie);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("11/19", course1, jeannie);
        bookingRepository.save(booking2);
    }
}
