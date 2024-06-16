package com.tka.sams.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.sams.api.entity.AttendanceRecord;
import com.tka.sams.api.entity.Faculty;
import com.tka.sams.api.entity.Student;
import com.tka.sams.api.entity.Subject;
import com.tka.sams.api.model.AttendanceRecordDTO;
import com.tka.sams.api.model.AttendanceRecordRequest;
import com.tka.sams.api.service.AttendanceRecordService;
import com.tka.sams.api.service.FacultyService;
import com.tka.sams.api.service.StudentService;
import com.tka.sams.api.service.SubjectService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all-attendance-records")
    public List<AttendanceRecord> getAllAttendanceRecords() {
        return attendanceRecordService.getAllAttendanceRecords();
    }

    @PostMapping("/add-attendance")
    public AttendanceRecord createAttendanceRecord(@RequestBody AttendanceRecordRequest request) {
        Faculty faculty = facultyService.getFacultyById(request.getFacultyId());
        Subject subject = subjectService.getSubjectById(request.getSubjectId());
        List<Student> students = studentService.getAllStudentsById(request.getStudentIds());

        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setFaculty(faculty);
        attendanceRecord.setSubject(subject);
        attendanceRecord.setDateTime(request.getDateTime());
        attendanceRecord.setStudents(students);
        attendanceRecord.setNumberOfStudents(request.getStudentIds().size());

        return attendanceRecordService.saveAttendance(attendanceRecord);
    }
}
