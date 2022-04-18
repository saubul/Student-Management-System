package ru.saubulprojects.sms.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/edit/{id}")
	public String editStudentForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		
		return "student/edit_student";
	}
	
	@PostMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student, Errors errors) {
		if(errors.hasErrors()) {
			return "student/edit_student";
		}
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@PostMapping("/new")
	public String createStudent(@Valid @ModelAttribute("student") Student student, Errors errors) {
		
		if(errors.hasErrors()) {
			return "student/create_student";
		}
		
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
