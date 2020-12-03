package com.codeclan.example.courseManager;

import com.codeclan.example.courseManager.models.Course;
import com.codeclan.example.courseManager.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseManagerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void canFindCourseByRating(){
		Course java = new Course("Intro To Java", "Inverness", 4);
		courseRepository.save(java);
		assertEquals("Intro To Java", courseRepository.findCourseByRating(4).get(0).getName());
	}


}
