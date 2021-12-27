package com.example.caching.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caching.exception.TeacherNotFoundException;
import com.example.caching.model.Teacher;
import com.example.caching.repository.TeacherRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

	@Autowired
	private final TeacherRepo teacherRepo;

	public Teacher findById(String id) throws TeacherNotFoundException {
		Optional<Teacher> findById = teacherRepo.findById(Integer.valueOf(id));
		if (findById.isPresent()) {
			throw new TeacherNotFoundException(String.format("Teacher not found with id %s", id));
		}
		return findById.get();
	}

}
