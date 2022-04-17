package ru.saubulprojects.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.saubulprojects.sms.model.*;
import ru.saubulprojects.sms.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping()
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getListStudents());
		return "student/students";
	}
	
	@GetMapping("/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student/create_student";
	}
	
	@PostMapping("/new")
	public String createStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
}
