package ru.saubulprojects.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.saubulprojects.sms.model.*;
import ru.saubulprojects.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getListStudents());
		return "students";
	}
	
}
