package com.kre.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",  uniqueConstraints = @UniqueConstraint( name = "emailid_unique",
																     columnNames = "email_address" ))
public class Student {

		@Id
		@SequenceGenerator( name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1 )		
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	 	private Long studentId;
	    private String firstName;
	    private String lastName;
	    
	    @Column(name="email_address",nullable = false)
	    private String emailId;
	   // private String guardianId;
	    
	    
	    //different class, but need same table 
	    @Embedded
	    private Guardian guardian;
}


/*
Hibernate: create table student_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into student_sequence values ( 1 )
Hibernate: create table tbl_student (student_id bigint not null, email_address varchar(255) not null, first_name varchar(255), guardian_id varchar(255), last_name varchar(255), primary key (student_id)) engine=InnoDB
Hibernate: alter table tbl_student drop index emailid_unique
Hibernate: alter table tbl_student add constraint emailid_unique unique (email_address)

*/