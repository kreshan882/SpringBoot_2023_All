package com.kre.springjpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kre.springjpa.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository  extends JpaRepository<CourseMaterial, Long>{

}
