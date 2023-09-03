package com.kre.springfull.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Db_table 
@Entity  
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
	 
		@Id  
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long departmentId; // primary key

	    private String departmentName;
	    private String departmentAddress;
	    private String departmentCode;
}
