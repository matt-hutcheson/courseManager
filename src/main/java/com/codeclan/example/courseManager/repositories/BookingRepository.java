package com.codeclan.example.courseManager.repositories;

import com.codeclan.example.courseManager.models.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> findBookingsByCustomerName(String name);
}
