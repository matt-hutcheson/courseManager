package com.codeclan.example.courseManager.repositories;

import com.codeclan.example.courseManager.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingsByCustomerName(String name);
    List<Booking> findBookingsByCourseName(String name);
    List<Booking> findBookingsByDate(String date);
    List<Booking> findBookingsByCustomerId(Long customerId);
    List<Booking> findBookingsByCourseId(Long courseId);
    List<Booking> findByDate(String date);
}
