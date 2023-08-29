package com.kre.springjpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kre.springjpa.entity.Guardian;
import com.kre.springjpa.entity.Student;
import com.kre.springjpa.repositery.StudentRepository;

@SpringBootTest
//@DataJpaTest  // after jpa db tested it will flush/clear the data
class SpringLearnJpaApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	
	//@Test
	void saveStudentObject() {
		System.out.println("testing started...................");
		Student student =Student.builder()
							.emailId("kkk3@gmail.com")
							.firstName("raj")
							.lastName("kreshan")
							//.guardianId("111")
							.build();
		
		studentRepository.save(student);
	}
	/*
	testing started...................
	Hibernate: select next_val as id_val from student_sequence for update
	Hibernate: update student_sequence set next_val= ? where next_val=?
	Hibernate: insert into tbl_student (email_address,first_name,guardian_id,last_name,student_id) values (?,?,?,?,?)
	 */
	
	@Test
	void getStudentList() {
		List<Student> studentList=studentRepository.findAll();
		System.out.println("studentList:"+studentList);
	}
	
	@Test
	void saveStudentObjectWithGardian() {
		Guardian guardian=Guardian.builder()
				.name("raj")
				.email("rajendran@gmail.com")
				.mobile("07712312312")
				.build();
		
		Student student =Student.builder()
				.firstName("aaaaaa")
				.lastName("kreshan")
				.emailId("kkk6@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
		/*
		Hibernate: update student_sequence set next_val= ? where next_val=?
		Hibernate: insert into tbl_student (email_address,first_name,guardian_email,guardian_mobile,guardian_name,last_name,student_id) values (?,?,?,?,?,?,?);  
		*/
	
	}
	
	@Test
	void printStudent_byFirstName_CustomeQuery() {
		List<Student> studentList_fn=studentRepository.findByFirstName("aaaaaa");
		System.out.println("studentList_fn:"+studentList_fn);
		/*
		Hibernate: select s1_0.student_id,s1_0.email_address,s1_0.first_name,s1_0.guardian_email,s1_0.guardian_mobile,s1_0.guardian_name,s1_0.last_name 
				   from tbl_student s1_0 where s1_0.first_name=?  
		studentList_fn:[Student(studentId=2, firstName=aaaaaa, lastName=kreshan, emailId=kkk6@gmail.com, 
		                guardian=Guardian(name=raj, email=rajendran@gmail.com, mobile=07712312312))]
		*/
	}
	
	
	@Test
	void printStudent_byGardian_name() {
		List<Student> studentList_guardName=studentRepository.findByGuardianName("rajs");
		System.out.println("studentList_guardName:"+studentList_guardName);
	
	}
	
	@Test  //API with customize
	void print_getStudendByEmailAddress_JPA() {  
		Student student_EmailAddress_JPA=studentRepository.findByEmailId("kkk6@gmail.com");
		System.out.println("student_EmailAddress_JPA:"+student_EmailAddress_JPA);
	
	}
	
	@Test //JPQL(java persistence Query Language)
	void print_getStudendByEmailAddress_QUERY() {  
		Student student_EmailAddress_QUERY=studentRepository.getStudendByEmailAddress_QUERY("kkk6@gmail.com");
		System.out.println("student_EmailAddress_QUERY:"+student_EmailAddress_QUERY);
	
	}
	
	@Test  //Native Query (good for complex query)
	void getStudendByEmailAddress_NATIVE() {  
		Student student_EmailAddress_NATIVE=studentRepository.getStudendByEmailAddress_NATIVE("kkk6@gmail.com");
		System.out.println("student_EmailAddress_NATIVE:"+student_EmailAddress_NATIVE);
	
	}
	
	@Test  //Native Query |with pass parameters
	void getStudendByEmailAddress_NATIVE_PassParams_k() {  
		Student student_EmailAddress_NATIVE_param2=studentRepository.getStudendByEmailAddress_NATIVE_PassParams_k("kkk6@gmail.com","aaaaaa");
		System.out.println("student_EmailAddress_NATIVE_param2:"+student_EmailAddress_NATIVE_param2);
	
	}
	
	
	@Test  //Native Query |update query (@Transactional | @Modifiing )
	void updateStudentNameByEmailId_NATIVE_k() {  
		int updateStatus=studentRepository.updateStudentNameByEmailId_NATIVE("aaaaaa2","kkk6@gmail.com");
		System.out.println("updateStatus:"+updateStatus);
	
	}
	
	

}
