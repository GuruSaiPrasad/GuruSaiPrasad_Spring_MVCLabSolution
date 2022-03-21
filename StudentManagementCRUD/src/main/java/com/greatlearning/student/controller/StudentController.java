package com.greatlearning.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.service.StudentService;

@Controller
@EnableTransactionManagement
public class StudentController {
	 @Autowired
	    private StudentService studentService;
	 
	    @RequestMapping(value = "/")
	    public ModelAndView listStudent(ModelAndView model) throws IOException{
	        List<Student> listStudent = studentService.getAllStudents() ;
	        model.addObject("Students", listStudent);
	        model.setViewName("list-students");
	        return model;
	    }
	 
	    @RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	    public ModelAndView newStudent(ModelAndView model) {
	        Student student = new Student();
	        model.addObject("Students", student);
	        model.setViewName("students-form");
	        return model;
	    }
	 
	    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	    public ModelAndView saveEmployee(@ModelAttribute Student student) {
	        if (student.getId() == 0) { 
	            studentService.addStudent(student);
	        } else {
	        	student.setId(student.getId());
	            studentService.updateStudent(student);
	        }
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	    public ModelAndView deleteStudent(HttpServletRequest request) {
	        int studentId = Integer.parseInt(request.getParameter("id"));
	        studentService.deleteStudent(studentId);
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	    public ModelAndView editStudent(HttpServletRequest request) {
	        int studentId = Integer.parseInt(request.getParameter("id"));
	        Student  student= studentService.getStudent(studentId);
	        ModelAndView model = new ModelAndView("students-form");
	        model.addObject("Students", student);
	 
	        return model;
	    }
}
