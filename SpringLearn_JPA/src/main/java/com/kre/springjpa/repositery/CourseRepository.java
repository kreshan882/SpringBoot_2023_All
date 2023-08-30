package com.kre.springjpa.repositery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kre.springjpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	Page<Course> findByTitleContaining( String title, Pageable pageable);
	
}
