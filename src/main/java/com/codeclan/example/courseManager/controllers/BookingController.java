package com.codeclan.example.courseManager.controllers;

import com.codeclan.example.courseManager.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity getAllBookingsAndFilters(
            @RequestParam(required = false, name = "customerId") Long customerId,
            @RequestParam(required = false, name = "courseId") Long courseId,
            @RequestParam(required = false, name = "date") String date
    ){
        if (customerId != null) {
            return new ResponseEntity(bookingRepository.findBookingsByCustomerId(customerId), HttpStatus.OK);
        }
        if (courseId != null) {
            return new ResponseEntity(bookingRepository.findBookingsByCourseId(courseId), HttpStatus.OK);
        }
        if (date != null) {
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }
}
