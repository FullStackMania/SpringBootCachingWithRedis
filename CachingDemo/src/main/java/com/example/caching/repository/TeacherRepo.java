package com.example.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caching.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer>  {

}
