package com.bass.task.HibernateTask.dao;
import java.util.List;

import com.bass.task.HibernateTask.model.Student;

public interface StudentDAO {
	
	List<Student> get();

	Student get(int id);
	
	void save(Student student);
	
	void delete(int id);
	
	
}
