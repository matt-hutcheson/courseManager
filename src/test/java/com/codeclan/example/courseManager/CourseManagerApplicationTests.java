package com.codeclan.example.courseManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseManagerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating(){
		assertEquals("English", findCourseByRating(4).get(0).getName());
	}

}
