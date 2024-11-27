package com.tka.SpringDB.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.SpringDB.entity.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String InsertData(Student s) {   // insert data

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(s);
		tr.commit();
		ss.close();
		return "record is Set";
	}

	public String DeleteData(int id) {     // delete data
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s = ss.get(Student.class, id);
		ss.remove(s);
		tr.commit();
		ss.close();
		return "data is deleted sucessfully";
	}

	public String updateData(Student s, int id) {   // update data
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student std = ss.get(Student.class, id);
		std.setAge(s.getAge());
		std.setName(s.getName());

		ss.merge(std);
		tr.commit();
		ss.close();
		return "data is updated";
	}

	public List<Student> getAllRecords() {   // get all record
		Session ss = factory.openSession();
		List<Student> students = ss.createQuery("from Student", Student.class).list();
		ss.close();
		return students;
	}

	public Student getSingleRecord(int id) {   // get single record
		Session ss = factory.openSession();
		Student s = ss.get(Student.class, id);
		ss.close();
		return s;
	}

}
