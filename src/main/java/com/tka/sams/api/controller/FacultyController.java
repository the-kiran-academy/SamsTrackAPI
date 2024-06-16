package com.tka.sams.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.sams.api.entity.Faculty;
import com.tka.sams.api.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/get-all-faculties")
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @PostMapping("/add-faculty")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/get-faculty-by-id/{id}")
    public Faculty getFacultyById(@PathVariable long id) {
        return facultyService.getFacultyById(id);
    }

    @PutMapping("/update-faculty")
    public Faculty updateFaculty( @RequestBody Faculty facultyDetails) {
        
        return facultyService.updateFaculty(facultyDetails);
    }

    @DeleteMapping("/delete-faculty/{id}")
    public String deleteFaculty(@PathVariable long id) {
       return facultyService.deleteFaculty(id);
    }
}
