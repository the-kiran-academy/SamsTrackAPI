package com.tka.sams.api.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.tka.sams.api.entity.AttendanceRecord;

public class AttendanceRecordDTO {
    private Long id;
    private Long facultyId;
    private String facultyName; // Assuming you want the faculty's name as well
    private Long subjectId;
    private String subjectName; // Assuming you want the subject's name as well
    private LocalDateTime dateTime;
    private int numberOfStudents;
    private List<StudentDTO> students;

    // Constructor
    public AttendanceRecordDTO(AttendanceRecord record) {
        this.id = record.getId();
        this.facultyId = record.getFaculty().getId();
        this.facultyName = record.getFaculty().getName(); // Assuming Faculty entity has a getName() method
        this.subjectId = record.getSubject().getId();
        this.subjectName = record.getSubject().getName(); // Assuming Subject entity has a getName() method
        this.dateTime = record.getDateTime();
        this.numberOfStudents = record.getNumberOfStudents();
        this.students = record.getStudents().stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
