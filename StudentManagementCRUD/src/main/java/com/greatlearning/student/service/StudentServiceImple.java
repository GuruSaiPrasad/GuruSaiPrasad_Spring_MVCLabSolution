package com.greatlearning.student.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.student.dao.StudentDao;
import com.greatlearning.student.entity.Student;

@Service
@Transactional
public class StudentServiceImple implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);

	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}

	@Override
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(studentId);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	@Transactional
	public Student getStudent(int studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentid);
	}

}
