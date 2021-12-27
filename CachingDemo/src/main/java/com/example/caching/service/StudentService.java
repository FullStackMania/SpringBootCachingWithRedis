package com.example.caching.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.caching.exception.StudentNotFoundException;
import com.example.caching.model.Student;
import com.example.caching.repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = {"Student"})
public class StudentService {

	@Autowired
	private final StudentRepo studentRepo;

	@Cacheable(key = "#id")
	public Student getStudentById(String id) throws StudentNotFoundException {
		Optional<Student> findById = studentRepo.findById(id);
		if (!findById.isPresent()) {
			throw new StudentNotFoundException(String.format("Student not found with id %s", id));
		}
		return findById.get();
	}

	public Student saveStudent(Student student) {
		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}

	@CachePut(key = "#student.id")
	public Student updateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> findById = studentRepo.findById(student.getId());
		if (!findById.isPresent()) {
			throw new StudentNotFoundException(String.format("Student not found with id %s", student.getId()));
		}
		Student studentToSave = findById.get();
		BeanUtils.copyProperties(student, studentToSave);
        Student saved = studentRepo.save(studentToSave);
        return saved;
	}


	@CacheEvict(key = "#id")
	public void deleteStudent(String id) throws StudentNotFoundException{
		Optional<Student> findById = studentRepo.findById(id);
		Student student = findById
				.orElseThrow(() -> new StudentNotFoundException(String.format("Student not found with id %s", id)));
        
		studentRepo.delete(student);
	}

}
