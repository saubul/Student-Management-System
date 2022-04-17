package ru.saubulprojects.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.saubulprojects.sms.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	
}
