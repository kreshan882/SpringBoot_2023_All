package com.kre.springjpa.repositery;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kre.springjpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	Slice<Course> findByTitleContaining(String string, Pageable firstPageTenRecords);

	
}
