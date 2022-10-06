package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Students;
import com.example.services.StudentsService;

@RestController
public class StudentsController {

	
	final Logger logger= LogManager.getLogger(StudentsController.class);
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping("/savestudents")
	public Students saveStudents( @RequestBody Students student)
	{
		return studentsService.saveStudents(student);
	}
	
	@GetMapping("/Students")
	public List<Students> findAll()
	{
		return studentsService.findAll();
		
	}
	@DeleteMapping("/Students/{id}")
	public String deleteStudent(@PathVariable("id") Long id)
	{
		studentsService.deleteStudents(id);
		return "Delete successfully";
		
	}
	
	@RequestMapping("/hello")
	public String hello()
	{
		
		logger.error("This going to be die soon");
		logger.info("Info log message");
		return "welcome to  my world";
	}
}
