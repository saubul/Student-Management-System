package ru.saubulprojects.sms.service;

import java.util.List;

import ru.saubulprojects.sms.model.Student;

public interface StudentService {
	
	public List<Student> getListStudents();
	
	public Student saveStudent(Student student);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student);
}
