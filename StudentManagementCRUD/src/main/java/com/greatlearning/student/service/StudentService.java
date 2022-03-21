package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.entity.Student;

public interface StudentService {
	 public void addStudent(Student student);
	 
	    public List<Student> getAllStudents();
	 
	    public void deleteStudent(Integer studentId);
	 
	    public Student updateStudent(Student student);
	 
	    public Student getStudent(int studentid);
}
