package com.tka.sams.api.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.sams.api.dao.AttendanceRecordDao;
import com.tka.sams.api.entity.AttendanceRecord;

@Service
public class AttendanceRecordService {
	@Autowired
	private AttendanceRecordDao dao;

	public List<AttendanceRecord> getAllAttendanceRecords() {
		List<AttendanceRecord> records = dao.getAllAttendanceRecords();
		 
		List<AttendanceRecord> distinctAttendanceList = records.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(AttendanceRecord::getId)))).stream()
				.collect(Collectors.toList());
		return distinctAttendanceList;
		
	}

	public AttendanceRecord saveAttendance(AttendanceRecord attendanceRecord) {

		return dao.saveAttendance(attendanceRecord);
	}
}
