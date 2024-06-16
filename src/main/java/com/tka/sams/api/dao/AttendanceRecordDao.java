package com.tka.sams.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.sams.api.entity.AttendanceRecord;
import com.tka.sams.api.entity.Faculty;

@Repository
public class AttendanceRecordDao {
	@Autowired
	private SessionFactory factory;

	public List<AttendanceRecord> getAllAttendanceRecords() {
		Session session = null;
		List<AttendanceRecord> list = null;
		try {
			session = factory.openSession();

			Criteria criteria = session.createCriteria(AttendanceRecord.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public AttendanceRecord saveAttendance(AttendanceRecord attendanceRecord) {
		Session session = null;
		AttendanceRecord record = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(attendanceRecord);
			transaction.commit();
			record = attendanceRecord;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return record;
	}
}
