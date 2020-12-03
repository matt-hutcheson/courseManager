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
        Course java = new Course("intro to java", "inverness", 2);
        courseRepository.save(java);
        Course javaScript = new Course("advanced javascript", "edinburgh", 4);
        courseRepository.save(javaScript);
        Course python = new Course("hellish python", "glasgow", 3);
        courseRepository.save(python);

        Customer arnie = new Customer("arnie", "inverness", 36);
        customerRepository.save(arnie);
        Customer sally = new Customer("sally", "edinburgh", 25);
        customerRepository.save(sally);
        Customer chuck = new Customer("chuck", "Glasgow", 45);
        customerRepository.save(chuck);
        Customer jeannie = new Customer("jeannie", "edinburgh", 28);
        customerRepository.save(jeannie);
        Customer bruce = new Customer("bruce", "glasgow", 32);
        customerRepository.save(bruce);

        Booking booking1 = new Booking("12/21", java, arnie);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("11/19", java, jeannie);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("10/20", javaScript, sally);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("09/19", python, chuck);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking("10/18", python, bruce);
        bookingRepository.save(booking5);
    }
}
