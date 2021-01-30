package com.springrest.springrest.entities;

import org.hibernate.annotations.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "details of the courses available")
public class Course {
	
	 @ApiModelProperty(notes = "The unique id of course")
	private int id;
	 
	 @ApiModelProperty(notes = "The title/name of course")
	 private String title;

	 @ApiModelProperty(notes = "The description of course")
	 private String description;
	public Course(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	 

}
