package ru.saubulprojects.sms.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
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
		return studentRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	@Override 
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	@Override
	public Student getStudentById(Long id) {
		return studentRepo.getById(id);
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
}
