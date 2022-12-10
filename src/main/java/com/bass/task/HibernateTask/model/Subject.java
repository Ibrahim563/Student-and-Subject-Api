package com.bass.task.HibernateTask.model;



import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name = "level")
	private String Level;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "student_subject",
			joinColumns =  @JoinColumn(name = "Subject_id"),
			inverseJoinColumns = @JoinColumn(name = "Student_id")
			)
	@JsonIgnoreProperties("subjects")
	List<Student> students ;

	public List<Student> getStudents() {
		return students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", Name=" + Name + ", Level=" + Level + "]";
	}

	public void enrollStudent(Student tempStud) {
		if(students.isEmpty()) {
			students = new ArrayList<>();
		}
		students.add(tempStud);
	}
	
	

}
