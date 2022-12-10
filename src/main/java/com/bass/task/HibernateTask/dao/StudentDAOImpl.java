package com.bass.task.HibernateTask.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bass.task.HibernateTask.model.Student;

import jakarta.persistence.EntityManager;


@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Student> get() {
		Session currentSession =  entityManager.unwrap(Session.class);
		Query<Student> query =  currentSession.createQuery("from Student",Student.class);
		List<Student> students = 	query.getResultList();
		return students;
		
	}

	@Transactional
	@Override
	public Student get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student TempStud =  currentSession.get(Student.class,id);
		return TempStud;
		
	}

	@Transactional
	@SuppressWarnings("deprecation")
	@Override
	public void save(Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(student);
	}

	@Transactional
	@SuppressWarnings("deprecation")
	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student TempStud =  currentSession.get(Student.class, id);
		for(int i=0;i<TempStud.getSubjects().size();i++) {
			TempStud.getSubjects().get(i).getStudents().remove(TempStud); 
		}
		currentSession.delete(TempStud);
	}

}
