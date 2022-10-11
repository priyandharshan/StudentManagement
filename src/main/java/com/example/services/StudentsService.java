package com.example.services;

import java.util.List;

import com.example.entity.Students;

public interface StudentsService {
	
	Students saveStudents(Students student);
	
	List<Students> findAll();
	StudentsDto getStudents(long id);
	
	void deleteStudents(Long id);

}
