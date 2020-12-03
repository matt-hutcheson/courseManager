package com.codeclan.example.courseManager.controllers;

import com.codeclan.example.courseManager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "customerName") String customerName,
            @RequestParam(required = false, name = "customerTown") String customerTown,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "courseName") String courseName
    ){
        if (customerName != null) {
            return new ResponseEntity(customerRepository.findCustomerByName(customerName), HttpStatus.OK);
        }
        if (customerTown != null) {
            return new ResponseEntity(customerRepository.findCustomerByTown(customerTown), HttpStatus.OK);
        }
        if (age != null) {
            return new ResponseEntity(customerRepository.findCustomerByAge(age), HttpStatus.OK);
        }
        if (courseName != null){
            return new ResponseEntity(customerRepository.findCustomerByBookingsCourseName(courseName), HttpStatus.OK);
        }
        if (courseName != null && customerTown != null){
            return new ResponseEntity(customerRepository.findCustomerByTownAndBookingsCourseName(customerTown, courseName), HttpStatus.OK);
        }
        if (courseName != null && customerTown != null && age != null){
            return new ResponseEntity(customerRepository.findCustomerByAgeGreaterThanAndTownAndBookingsCourseName(age, customerTown, courseName), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
