package com.codeclan.example.courseManager;

import com.codeclan.example.courseManager.models.Booking;
import com.codeclan.example.courseManager.models.Course;
import com.codeclan.example.courseManager.models.Customer;
import com.codeclan.example.courseManager.repositories.BookingRepository;
import com.codeclan.example.courseManager.repositories.CourseRepository;
import com.codeclan.example.courseManager.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseManagerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void canFindCourseByRating(){
		Course java = new Course("Intro To Java", "Inverness", 4);
		courseRepository.save(java);
		assertEquals("Intro To Java", courseRepository.findCourseByRating(4).get(0).getName());
	}

	@Test
	public void canGetCustomersByCourse(){
		Customer bob = new Customer("Bob", "Stirling", 36);
		customerRepository.save(bob);
		Customer jeannie = new Customer("Jeannie", "Falkirk", 25);
		customerRepository.save(jeannie);
		Course java = new Course("Intro To Java", "Inverness", 4);
		courseRepository.save(java);
		Booking booking = new Booking("12/21", java, bob);
		bookingRepository.save(booking);
		Booking booking1 = new Booking("12/21", java, jeannie);
		bookingRepository.save(booking1);
		List<Booking> results = bookingRepository.findBookingsByCourseName("Intro To Java");
		assertEquals(2, results.size());
	}

}
