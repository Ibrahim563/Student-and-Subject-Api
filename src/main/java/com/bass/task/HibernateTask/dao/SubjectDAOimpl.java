package com.bass.task.HibernateTask.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bass.task.HibernateTask.model.Subject;


import jakarta.persistence.EntityManager;

@Repository
public class SubjectDAOimpl implements SubjectDAO {

	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public List<Subject> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Subject> query = currentSession.createQuery("from Subject", Subject.class);
		List<Subject> subjects = query.getResultList();
		return subjects;
	}

	@Transactional
	@Override
	public Subject get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Subject Tempsub = currentSession.get(Subject.class, id);
		return Tempsub;

	}

	@Transactional
	@SuppressWarnings("deprecation")
	@Override
	public void save(Subject subject) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(subject);

	}

	@Transactional
	@SuppressWarnings("deprecation")
	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Subject Tempsub = currentSession.get(Subject.class, id);
		
		for(int i=0;i<Tempsub.getStudents().size();i++) {
			
			Tempsub.getStudents().get(i).getSubjects().remove(Tempsub);
		}
		
		currentSession.delete(Tempsub);
	}

}
