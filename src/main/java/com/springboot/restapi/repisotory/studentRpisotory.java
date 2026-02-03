package com.springboot.restapi.repisotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Student;

public interface studentRpisotory extends JpaRepository<Student, Integer> {

}
