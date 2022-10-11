package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Constants;
import com.example.entity.Address;
import com.example.entity.Students;
import com.example.services.StudentsDto;
import com.example.services.StudentsService;

@RestController
public class StudentsController {

	
	final Logger logger= LogManager.getLogger(StudentsController.class);
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping(Constants.STUDENTS)
	public ResponseEntity<Object> saveStudents( @RequestBody StudentsDto studentDto)
	{
		Students student=new Students();
		student.setId(studentDto.getId());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setDateOfBirth(studentDto.getDateOfBirth());
		
		Address address=new Address();
		address.setId(studentDto.getAddressDto().getId());
		address.setSteetName(studentDto.getAddressDto().getStreetName());
		address.setCity(studentDto.getAddressDto().getCity());
		student.setAddress(address);

		
		studentsService.saveStudents(student);
		return ResponseEntity.ok("students inserted");
	}
	
	@GetMapping(Constants.STUDENTS)
	public List<Students> findAll()
	{
		return studentsService.findAll();
		
	}
	
	@GetMapping(Constants.STUDENTS+"/{id}")
	public ResponseEntity<Object> getStudentsById(@PathVariable("id") Long id) {

		return ResponseEntity.ok(studentsService.getStudents(id));
	}
	@DeleteMapping(Constants.STUDENTS+"/{id}")
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
