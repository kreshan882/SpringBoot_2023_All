package com.kre.springjpa.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kre.springjpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	//1.1) #########JPA Originel***********************************************************************
		//List<Student> studentList=studentRepository.findAll();
	
	//1.2) #########JPA Custom (Java Persistence API)
		//CUSTOM QUERY: where first_neme = "name"
		public List<Student> findByFirstName(String firstName);
		
		//CUSTOM QUERY: where first_neme like '%name%'
		public List<Student> findByFirstNameContaining(String firstName);
		
		//CUSTOM QUERY: where first_neme is not null
		public List<Student> findByFirstNameNotNull();
		
		//CUSTOM QUERY: Stusent->guardian/G -> name/N
		//from tbl_student s1_0 where s1_0.guardian_name=?
		public List<Student> findByGuardianName(String firstName);
		
		public Student findByEmailId(String EmailId);
	
		
	//2.1) ############JPQL (Java Persistence Query Language)************************************************
		@Query("select s from Student s where s.emailId=?1")   //all java class & variable || 1st parameter passing
		public Student getStudendByEmailAddress_QUERY(String EmailId);
		
		
		//only select s.firstName
		@Query("select s.firstName from Student s where s.emailId=?1")   
		public String getStudendFirstNameByEmailAddress_QUERY(String EmailId);
	
	
	//3.1) ############ Native query (good for complex query)*************************************************
	    @Query(
	            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
	            nativeQuery = true
	    )
	    public Student getStudendByEmailAddress_NATIVE(String EmailId);
	    
	    //pass parameter
	    @Query(
	            value = "SELECT * FROM tbl_student s where s.email_address = :emailId and s.first_name = :firstName",
	            nativeQuery = true
	    )
	    public Student getStudendByEmailAddress_NATIVE_PassParams_k(@Param("emailId") String emailId ,@Param("firstName") String firstName);
    
    
    //4.1) ############ @Transactional | @Modifiing Anotation | Native query**********************************
    @Modifying   	// update query
    @Transactional  // in service class roleback also handl in this Anotation
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId_NATIVE(String firstName, String emailId);
}
