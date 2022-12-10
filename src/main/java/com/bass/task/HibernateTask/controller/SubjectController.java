package com.bass.task.HibernateTask.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bass.task.HibernateTask.dao.StudentDAO;
import com.bass.task.HibernateTask.dao.SubjectDAO;
import com.bass.task.HibernateTask.model.Student;
import com.bass.task.HibernateTask.model.Subject;

@RestController
@CrossOrigin
@RequestMapping("/Subject")
public class SubjectController {
	
	
	@Autowired
	SubjectDAO subjectdao;
	
	@Autowired
	StudentDAO studentdao;
	
	@GetMapping("/subjects")
	public List<Subject> get(){
		return subjectdao.get();
	}
	
	
	@PostMapping("/subjects")
	public Subject save(@RequestBody Subject sub) {
		subjectdao.save(sub);
		return sub;
	}

	
	@GetMapping("/subjects/{id}")
	public Subject get(@PathVariable int id) {
		return subjectdao.get(id);
	}
	
	@PutMapping("/subjects")
	public Subject update(@RequestBody Subject sub) {
		subjectdao.save(sub);
		return sub;
	}
	
	@DeleteMapping("/subjects/{id}")
	public void delete(@PathVariable int id) {
		subjectdao.delete(id);
	}
	
	@PutMapping("/{subjectId}/subjects/{studentId}")
	public void StudentToSubject(@PathVariable int subjectId, @PathVariable int studentId) {
		Subject tempSubject = subjectdao.get(subjectId);
		Student tempStud = studentdao.get(studentId);
		tempSubject.enrollStudent(tempStud);
		subjectdao.save(tempSubject);
 	}
	
}
