package com.kre.springjpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kre.springjpa.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
