package com.bass.task.HibernateTask.dao;

import java.util.List;

import com.bass.task.HibernateTask.model.Subject;

public interface SubjectDAO {
	
	List<Subject> get();
	
	Subject get(int id);
	
	void save(Subject subject);
	
	void delete(int id);

}
