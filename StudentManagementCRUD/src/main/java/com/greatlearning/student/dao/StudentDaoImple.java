package com.greatlearning.student.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.student.entity.Student;
@Repository
@Transactional
public class StudentDaoImple implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.openSession().saveOrUpdate(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createCriteria(Student.class)
	                .list();
	}

	@Override
	@Transactional
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		 Student student= (Student) sessionFactory.getCurrentSession().load(
	                Student.class, studentId);
	        if (null != student) {
	            this.sessionFactory.getCurrentSession().delete(student);
	        }

	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);

		return student;
	}

	@Transactional
	public Student getStudent(Integer studentid) {
		// TODO Auto-generated method stub
		 System.out.println("the Incoming "+studentid);
		  Student student= (Student) sessionFactory.openSession().load(Student.class, studentid);
		  System.out.println(student.toString());
		  System.out.println(student.toString());
		  
		  
		return student ;
	}

}
