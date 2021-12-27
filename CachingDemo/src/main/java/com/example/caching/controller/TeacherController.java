package com.example.caching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caching.exception.TeacherNotFoundException;
import com.example.caching.model.Teacher;
import com.example.caching.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

	@Autowired
	private final TeacherService teacherService;

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") String id) throws TeacherNotFoundException {
		Teacher findById = teacherService.findById(id);
		return ResponseEntity.ok(findById);
	}

}
