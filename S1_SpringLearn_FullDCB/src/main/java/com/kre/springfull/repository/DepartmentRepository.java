package com.kre.springfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kre.springfull.entity.Department;

// Full Query list DOC: 
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
// ReferanceDoc-> JPA repositery -> Query Method -> Query Creation
//SampleKeyWordWithfunctionName JPA -> JPQL -> NATIVE query (when query complex)
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);

}
