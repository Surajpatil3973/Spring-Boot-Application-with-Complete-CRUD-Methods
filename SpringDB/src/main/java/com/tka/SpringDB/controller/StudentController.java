package com.tka.SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.SpringDB.entity.Student;
import com.tka.SpringDB.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/savedata")
	public String insertData(@RequestBody Student s) {
		String msg = service.InsertData(s);
		return msg;
	}

	@DeleteMapping("/deletedata/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.DeleteData(id);
		return msg;
	}

	@PutMapping("/updatedata/{id}")
	public String updateData(@PathVariable int id, @RequestBody Student s) {
		String msg = service.updateData(s, id);
		return msg;
	}

	@GetMapping("/getallrecords")
	public List<Student> getAllRecords() {
		return service.getAllRecords();
	}

	@GetMapping("/getrecord/{id}")
	public Student getSingleRecord(@PathVariable int id) {
		Student student = service.getSingleRecord(id);
		return student;
	}

}
