package com.tka.sams.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.sams.api.entity.Faculty;

@Repository
public class FacultyDao {
	@Autowired
	private SessionFactory factory;

	public Faculty getFacultyById(long facultyId) {
		Session session = null;
		Faculty faculty = null;
		try {
			session = factory.openSession();
			faculty = session.get(Faculty.class, facultyId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return faculty;
	}

	public List<Faculty> getAllFaculties() {
		Session session = null;
		List<Faculty> list = null;
		try {
			session = factory.openSession();

			Criteria criteria = session.createCriteria(Faculty.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public Faculty createFaculty(Faculty faculty) {
		Session session = null;
		Faculty f = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(faculty);
			transaction.commit();
			f = faculty;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return f;
	}

	public Faculty updateFaculty(Faculty facultyDetails) {
		Session session = null;
		Faculty f = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(facultyDetails);
			transaction.commit();
			f = facultyDetails;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return f;
	}

	public String deleteFaculty(long id) {
		Session session = null;
		String msg = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Faculty faculty = session.get(Faculty.class, id);

			if (faculty != null) {
				session.delete(faculty);
				transaction.commit();
				msg = "Deleted !!";
			} else {
				msg = "Not Exists !!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}
}
