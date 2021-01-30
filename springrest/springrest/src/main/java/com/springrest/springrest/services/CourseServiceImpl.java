package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() 
	{
		list=new ArrayList<>();
		list.add(new Course(145,"java course","java courses tutorials youtube"));
		list.add(new Course(150,"spring boot course","spring boot for rest api"));
		
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}



	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		list.forEach(e ->{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
				
		});
		
		return course;
	}

	@Override
	public void deleteCourse(int i) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=i).collect(Collectors.toList());
		
		
	}}
