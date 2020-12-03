package com.codeclan.example.courseManager.repositories;

import com.codeclan.example.courseManager.models.Booking;
import com.codeclan.example.courseManager.models.Customer;
import com.codeclan.example.courseManager.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Rating, Long> {

}
