package com.tka.sams.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.sams.api.dao.FacultyDao;
import com.tka.sams.api.entity.Faculty;

@Service
public class FacultyService  {
	
	@Autowired
	private FacultyDao dao;

	public Faculty getFacultyById(long facultyId) {
		
		return dao.getFacultyById(facultyId);
	}

	public List<Faculty> getAllFaculties() {
		return dao.getAllFaculties();
	}

	public Faculty createFaculty(Faculty faculty) {
		return dao.createFaculty(faculty);
	}

	public Faculty updateFaculty(Faculty facultyDetails) {
		return dao.updateFaculty(facultyDetails);
	}

	public String deleteFaculty(long id) {
		return dao.deleteFaculty(id);
		
	}

	
}

