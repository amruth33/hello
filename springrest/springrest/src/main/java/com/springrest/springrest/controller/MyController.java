package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class MyController {
	
	@Autowired
	private CourseService courseService;


	
	//get the courses
	
	@GetMapping("/courses")
	@ApiOperation(value = "Find all courses ",
	notes = "Provides all the courses drescription",
	response = Course.class)
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	@ApiOperation(value = "Find courses by id",
	notes = "Provides the courses drescription by an id",
	response = Course.class)
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	@PostMapping("/courses")
	@ApiOperation(value = "Adds new courses",
	notes = "Adds new course to the list",
	response = Course.class)
	public Course addCourse(@RequestBody Course course)
	{
		 return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	@ApiOperation(value = "Updates the courses",
	notes = "Updates the course in the list",
	response = Course.class)
	public Course updateCourse(Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	@ApiOperation(value = "Deletes the courses by id",
	notes = "Deletes the course in the list",
	response = Course.class)
	public ResponseEntity<HttpStatus> deleteCourse(@ApiParam(value = "Id value should be int", required = true)@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
