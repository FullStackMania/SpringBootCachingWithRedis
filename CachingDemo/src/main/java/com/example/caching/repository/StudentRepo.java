package com.example.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caching.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String>  {

}
