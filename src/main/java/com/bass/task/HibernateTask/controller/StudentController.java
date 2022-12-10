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
@RequestMapping("/Controller")
public class StudentController {

	@Autowired
	private	StudentDAO studentdao;
	
	@Autowired
	private SubjectDAO subjectdao;
	
	@GetMapping("/Students")
	public List<Student> get(){
		return studentdao.get();
		
	}
	
	@PostMapping("/Students")
	public Student save(@RequestBody Student stud) {
		studentdao.save(stud);
		return stud;
	}
	
	@GetMapping("/Students/{id}")
	public Student get(@PathVariable int id) {
		return studentdao.get(id);	
	
	}
	
	@DeleteMapping("/Students/{id}")
	public void delete(@PathVariable int id) {
		studentdao.delete(id);
	}
	
	@PutMapping("/Students")
	public Student update(@RequestBody Student stud) {
		studentdao.save(stud);
		return stud;
	}
	
	@PutMapping("/{studentId}/Students/{subjectId}")
	public void AddSubjectToStudent(@PathVariable int studentId, @PathVariable int subjectId) {
		Subject tempsub = subjectdao.get(subjectId);
		Student tempstud = studentdao.get(studentId);
		tempstud.AddSubject(tempsub);
		studentdao.save(tempstud);
		
	}
}
