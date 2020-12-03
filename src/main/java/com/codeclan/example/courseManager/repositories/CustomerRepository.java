package com.codeclan.example.courseManager.repositories;

import com.codeclan.example.courseManager.models.Course;
import com.codeclan.example.courseManager.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByBookingsCourseName(String name);
    List<Customer> findCustomerByTownAndBookingsCourseName(String town, String courseName);
}
