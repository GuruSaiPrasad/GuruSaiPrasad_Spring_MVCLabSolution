package com.greatlearning.student.dao;

import java.util.List;

import com.greatlearning.student.entity.Student;

public interface StudentDao {
	 public void addStudent(Student student);
	 
	    public List<Student> getAllStudents();
	 
	    public void deleteStudent(Integer studentId);
	 
	    public Student updateStudent(Student student);
	 
	    public Student getStudent(Integer studentid);
}
