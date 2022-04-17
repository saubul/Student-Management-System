package ru.saubulprojects.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.saubulprojects.sms.service.StudentService;
import ru.saubulprojects.sms.model.Student;
import ru.saubulprojects.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	@Override
	public List<Student> getListStudents() {
		return studentRepo.findAll();
	}
	
	@Override 
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
}
