package com.tka.SpringDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.SpringDB.dao.StudentDao;
import com.tka.SpringDB.entity.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;

	public String InsertData(Student s) {
		String msg = dao.InsertData(s);
		return msg;
	}

	public String DeleteData(int id) {
		String msg = dao.DeleteData(id);
		return msg;
	}

	public String updateData(Student s, int id) {
		String msg = dao.updateData(s, id);
		return msg;
	}

	public List<Student> getAllRecords() {
		return dao.getAllRecords();
	}

	public Student getSingleRecord(int id) {
		return dao.getSingleRecord(id);
	}
}
