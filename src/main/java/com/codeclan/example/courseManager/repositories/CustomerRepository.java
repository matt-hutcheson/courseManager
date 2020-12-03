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
    List<Customer>findCustomerByName(String name);
    List<Customer>findCustomerByTown(String town);
    List<Customer>findCustomerByAge(int age);
//    Get all customers over a certain age in a given town for a given course
    List<Customer> findCustomerByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String courseName);
}
