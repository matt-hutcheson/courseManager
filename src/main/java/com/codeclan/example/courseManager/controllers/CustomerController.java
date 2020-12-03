package com.codeclan.example.courseManager.controllers;

import com.codeclan.example.courseManager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

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
        if (courseName != null && customerTown != null && age != null){
            return new ResponseEntity(customerRepository.findCustomerByAgeGreaterThanAndTownAndBookingsCourseName(age, customerTown, courseName), HttpStatus.OK);
        }
        if (courseName != null && customerTown != null){
            String lowerCaseName = courseName.toLowerCase();
            String lowerCaseTown = customerTown.toLowerCase();
            return new ResponseEntity(customerRepository.findCustomerByTownAndBookingsCourseName(lowerCaseTown, lowerCaseName), HttpStatus.OK);
        }
        if (courseName != null){
            String lowerCaseName = courseName.toLowerCase();
            return new ResponseEntity(customerRepository.findCustomerByBookingsCourseName(lowerCaseName), HttpStatus.OK);
        }
        if (customerName != null) {
            String lowerCaseName = customerName.toLowerCase();
            return new ResponseEntity(customerRepository.findCustomerByName(lowerCaseName), HttpStatus.OK);
        }
        if (customerTown != null) {
            String lowerCaseTown = customerTown.toLowerCase();
            return new ResponseEntity(customerRepository.findCustomerByTown(lowerCaseTown), HttpStatus.OK);
        }
        if (age != null) {
            return new ResponseEntity(customerRepository.findCustomerByAge(age), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
