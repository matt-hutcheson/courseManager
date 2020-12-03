package com.codeclan.example.courseManager.repositories;

import com.codeclan.example.courseManager.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByRating(Integer rating);
    List<Course> findCourseByName(String name);
    List<Course> findCourseByTown(String town);
}
